package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.model.request.LoginRequest;
import com.api.model.response.LoginResponse;

import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListener.class)
public class Authentication_LoginApiTest {

	@Test(description = "Verify if login API is working..")
	public void loginTest() {
		
		LoginRequest loginRequest = new LoginRequest("ansh", "ansh1234");
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);
		LoginResponse loginResponse = response.as(LoginResponse.class);
//		response.prettyPrint();
		System.out.println("Token Value: "+loginResponse.getToken());
		System.out.println("Email: "+loginResponse.getEmail());
		
		Assert.assertTrue(loginResponse.getToken() != null);
		Assert.assertEquals(loginResponse.getEmail(), "anshul@gamil.com");
		Assert.assertEquals(loginResponse.getId(), 1083);
	}
}
