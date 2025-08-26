package com.api.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.api.base.TransactionController;
import com.api.model.request.DepositRequest;
import com.api.model.request.TransferRequest;
import com.api.model.response.LoginResponse;
import com.api.utilites.PropertiesUtility;
import com.api.utilites.RestAssuredUtility;

import io.restassured.response.Response;

public class TransactionController_transfer {
	@Test
	public void depositTest() throws IOException {
		RestAssuredUtility assuredUtility = new RestAssuredUtility();
		TransactionController controller = new TransactionController();
		TransferRequest transferRequest = new TransferRequest.Builder()
				.fromAccount("5970700138")
				.toAccount("5934811449")
				.amount(3600)
				.description("Testing transfer amount")
				.build();
		String filePath = ".\\src\\test\\resources\\data.properties";
		String accountNumber = PropertiesUtility.getProperty(filePath, "accountNumber");

		LoginResponse loginResponse = assuredUtility.login();
		Response response = controller.transfer(loginResponse.getToken(), transferRequest);

		response.prettyPrint();
	}
}
