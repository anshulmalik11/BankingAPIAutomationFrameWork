package com.api.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AccountController;
import com.api.base.TransactionController;
import com.api.model.request.TransferRequest;
import com.api.model.response.AccountResponse;
import com.api.model.response.LoginResponse;
import com.api.utilites.PropertiesUtility;
import com.api.utilites.RestAssuredUtility;

import io.restassured.response.Response;

public class SendingMoneyFromAccount {
	
	AccountController accountController = new AccountController();

	private AccountResponse fetchAccount(String token, String acctNo) {
		return accountController.getAccountData(token,acctNo)
				.as(AccountResponse.class);
	}
	
	@Test(dependsOnMethods = "sendingMoneyInDifferentProfile")
	public void SendingMoneyFromOneAccountToOtherAccountTest() throws IOException {
		
//		setUp
		PropertiesUtility props = new PropertiesUtility();
		String filePath = ".\\src\\test\\resources\\data.properties";
		String fromAccountNumber = props.getProperty(filePath,"accountNumber");
		String toAccountNumber = props.getProperty(filePath,"toAccountNumber");
		int amount = Integer.parseInt(props.getProperty(filePath,"amount"));
		
		LoginResponse loginResponse = new RestAssuredUtility().login();		
		

//		getting Before balances
		double beforeA = fetchAccount(loginResponse.getToken(), fromAccountNumber).getBalance();
		double beforeB = fetchAccount(loginResponse.getToken(), toAccountNumber).getBalance();
		
		System.out.println(beforeA);
		System.out.println(beforeB);
		
//		Sending money
		TransferRequest transferRequest = new TransferRequest.Builder()
				.fromAccount(fromAccountNumber)
				.toAccount(toAccountNumber)
				.amount(amount)
				.description("Testing transfer amount")
				.build();
		
		TransactionController controller = new TransactionController();
		controller.transfer(loginResponse.getToken(), transferRequest);
		
//		getting After balances
		double AfterA = accountController.getAccountData(loginResponse.getToken(),fromAccountNumber)
				.as(AccountResponse.class).getBalance();
		
		double AfterB = accountController.getAccountData(loginResponse.getToken(),toAccountNumber)
				.as(AccountResponse.class).getBalance();
		
		System.out.println(AfterA);
		System.out.println(AfterB);
		
		Assert.assertEquals(beforeA-amount, AfterA);
		Assert.assertEquals(beforeB+amount, AfterB);
	}
	
	@Test(priority = 1)
	public void sendingMoneyInDifferentProfile() throws IOException {
		
		PropertiesUtility pro = new PropertiesUtility();
		String filePath = ".\\src\\test\\resources\\data.properties";
		String fromAccountNum = pro.getProperty(filePath, "otherProAccNum");
		String toAccountNum = pro.getProperty(filePath, "accountNumber");
		int amount = Integer.parseInt(pro.getProperty(filePath, "amount"));
		
		LoginResponse loginA = RestAssuredUtility.login("uday1234","uday12345");
		LoginResponse loginB = RestAssuredUtility.login();
		
		double beforeA = fetchAccount(loginA.getToken(), fromAccountNum).getBalance();
		double beforeB = fetchAccount(loginB.getToken(), toAccountNum).getBalance();
		
		System.out.println("before A: "+beforeA+", before B: "+beforeB);
		
		TransactionController controller = new TransactionController();
		
		TransferRequest transferRequest = new TransferRequest.Builder()
				.fromAccount(fromAccountNum)
				.toAccount(toAccountNum)
				.amount(amount)
				.description("testing sending amount from one profiel to another profile")
				.build();
		
		Response response = controller.transfer(loginA.getToken(), transferRequest);
		double afterA = fetchAccount(loginA.getToken(), fromAccountNum).getBalance();
		double afterB = fetchAccount(loginB.getToken(), toAccountNum).getBalance();

		System.out.println("after A: "+afterA+", after B: "+afterB);

		Assert.assertEquals(beforeA-amount, afterA);
		Assert.assertEquals(beforeB+amount, afterB);
	}
}
