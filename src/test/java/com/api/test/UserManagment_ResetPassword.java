package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagment;
import com.api.model.request.ChangePasswordRequest;
import com.api.model.request.LoginRequest;
import com.api.model.response.LoginResponse;
import com.api.utilites.JavaUtilities;
import com.api.utilites.PropertiesUtility;

import io.restassured.response.Response;

public class UserManagment_ResetPassword {

	@Test
	public void resetPasswordTest() throws Throwable {
		String filePath = "./src/test/resources/currentPassword.properties";
		PropertiesUtility properties = new PropertiesUtility();
		String currentPassword = properties.getProperty(filePath,"current");
		
		JavaUtilities javaUtilities = new JavaUtilities();
		String newPassword = "chinu"+ javaUtilities.ranNum();
		System.out.println(newPassword);
		
		UserProfileManagment managmentService = new UserProfileManagment();
		ChangePasswordRequest passwordRequest = new ChangePasswordRequest(currentPassword,newPassword);
		AuthService authService = new AuthService();
		LoginRequest loginRequest = new LoginRequest("Vani123",currentPassword);
		
		Response response = authService.login(loginRequest);
		response.prettyPrint();
		LoginResponse loginResponse = response.as(LoginResponse.class);
		
		Response changeResponse = managmentService.changePassword(loginResponse.getToken(), passwordRequest);
//		System.out.println(changeResponse.statusCode());
		changeResponse.prettyPrint();
		
		Assert.assertEquals(changeResponse.statusCode(), 200);
		
		properties.setProperty(filePath,"current", newPassword);
		
	}
}
