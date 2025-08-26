package com.api.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.api.base.AccountController;
import com.api.model.response.LoginResponse;
import com.api.utilites.RestAssuredUtility;

import io.restassured.response.Response;

public class AccountController_getAccountList {

	@Test
	public void getAccountListTest() throws IOException {
		RestAssuredUtility assuredUtility = new RestAssuredUtility();
		LoginResponse loginResponse = assuredUtility.login();
		
		AccountController accountController =  new AccountController();
		Response response = accountController.getAccountList(loginResponse.getToken());
		response.prettyPrint();
		
	}
}
