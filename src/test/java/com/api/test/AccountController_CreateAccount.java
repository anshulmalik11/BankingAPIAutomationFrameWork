package com.api.test;

import org.testng.annotations.Test;

import com.api.base.AccountController;
import com.api.base.AuthService;
import com.api.model.request.CreateAccountRequest;
import com.api.model.request.LoginRequest;
import com.api.model.response.LoginResponse;

import io.restassured.response.Response;

public class AccountController_CreateAccount {

	@Test
	public void createAccountTest() {
		AuthService authService = new AuthService();
		
		AccountController accountController = new AccountController();
		LoginResponse loginResponse = authService.login(new LoginRequest("naruto123", "naruto123")).as(LoginResponse.class);
		CreateAccountRequest accountRequest = new CreateAccountRequest("SALARY", "NORTH");
		
		Response response = accountController.createAccount(loginResponse.getToken(), accountRequest);
		response.prettyPrint();
	}
}
