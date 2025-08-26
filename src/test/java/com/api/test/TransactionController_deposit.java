package com.api.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.api.base.TransactionController;
import com.api.model.request.DepositRequest;
import com.api.model.response.LoginResponse;
import com.api.utilites.PropertiesUtility;
import com.api.utilites.RestAssuredUtility;

import io.restassured.response.Response;

public class TransactionController_deposit {

	@Test
	public void depositTest() throws IOException {
		RestAssuredUtility assuredUtility = new RestAssuredUtility();
		TransactionController controller = new TransactionController();
		String filePath = ".\\src\\test\\resources\\data.properties";
		String accountNumber = PropertiesUtility.getProperty(filePath,"accountNumber");
		
		DepositRequest depositRequest = new DepositRequest.Builder()
				.accountNumber(accountNumber)
				.amount(3000)
				.description("Testing Transfer")
				.build();
		
		LoginResponse loginResponse = assuredUtility.login();
		Response response = controller.Deposit(loginResponse.getToken(), depositRequest);
		
		response.prettyPrint();
	}
}
