package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.model.request.SignUpRequest;

import io.restassured.response.Response;

public class Authentication_ProfileCreation {

	@Test
	public void createProfileTest(){
		
		SignUpRequest signUprequest = new SignUpRequest.Builder()
		.userName("naruto123")
		.email("naruto@yahoo.com")
		.firstName("naruto")
		.password("naruto123")
		.lastName("uzumaki")
		.mobileNumber("7777777776")
		.build();
		
		AuthService authService = new AuthService();
		Response response = authService.signUp(signUprequest);
		
		response.prettyPrint();
		
		Assert.assertEquals(response.statusCode(), 200); 
	}
}
