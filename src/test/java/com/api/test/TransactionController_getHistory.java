package com.api.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.api.base.TransactionController;
import com.api.model.response.LoginResponse;
import com.api.utilites.PropertiesUtility;
import com.api.utilites.RestAssuredUtility;

import io.restassured.response.Response;

public class TransactionController_getHistory {

	@Test
	public void depositTest() throws IOException {
		RestAssuredUtility assuredUtility = new RestAssuredUtility();
		TransactionController controller = new TransactionController();
		String filePath = ".\\src\\test\\resources\\data.properties";
		String accountNumber = PropertiesUtility.getProperty(filePath,"accountNumber");
		
		LoginResponse loginResponse = assuredUtility.login();
		Response response = controller.getHistory(loginResponse.getToken(), accountNumber);
		
		response.prettyPrint();
	}
}
