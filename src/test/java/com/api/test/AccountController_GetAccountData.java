package com.api.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.api.base.AccountController;
import com.api.model.response.LoginResponse;
import com.api.utilites.PropertiesUtility;
import com.api.utilites.RestAssuredUtility;

import io.restassured.response.Response;

public class AccountController_GetAccountData {

	@Test
	public void getAccountDetailsTest () throws IOException {
		PropertiesUtility propertiesUtility = new PropertiesUtility();
		String filePath = ".\\src\\test\\resources\\data.properties";
		String accountNumber = propertiesUtility.getProperty(filePath,"accountNumber");
		RestAssuredUtility restAssuredUtility = new RestAssuredUtility();
		LoginResponse loginResponse = restAssuredUtility.login();
		
		AccountController accountController = new AccountController();
		Response response = accountController.getAccountData(loginResponse.getToken(),accountNumber);
		response.prettyPrint();
	}
}
