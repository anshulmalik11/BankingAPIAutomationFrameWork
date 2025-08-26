package com.api.test;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagment;
import com.api.model.request.LoginRequest;
import com.api.model.response.LoginResponse;

import io.restassured.response.Response;

public class UserManagement_DeleteProfile {

	@Test
	public void deleteProfileRequest() {
		
		AuthService authService = new AuthService();
		LoginResponse loginResponse = authService.login(new LoginRequest("naruto123", "naruto123")).as(LoginResponse.class);
		UserProfileManagment managmentService = new UserProfileManagment();
		Response deleteResponse = managmentService.deleteProfile(loginResponse.getToken());
		deleteResponse.prettyPrint();
		
	}
}
