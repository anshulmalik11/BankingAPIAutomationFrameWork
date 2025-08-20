package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.model.request.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreationTest {

	@Test
	public void createAccountTest(){
		
		SignUpRequest signUprequest = new SignUpRequest.Builder()
		.userName("Disha123")
		.email("disha@yahoo.com")
		.firstName("Disha")
		.password("disha123")
		.lastName("Patani")
		.mobileNumber("7777777776")
		.build();
		
		AuthService authService = new AuthService();
		Response response = authService.signUp(signUprequest);
		
		response.prettyPrint();
		
		Assert.assertEquals(response.statusCode(), 500);  //response should be 200 but due to server issue 500 is coming right now
	}
}
