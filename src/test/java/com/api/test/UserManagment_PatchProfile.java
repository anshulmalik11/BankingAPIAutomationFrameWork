package com.api.test;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagment;
import com.api.model.request.LoginRequest;
import com.api.model.request.PartialProfileUpdateRequest;
import com.api.model.response.LoginResponse;

import io.restassured.response.Response;

public class UserManagment_PatchProfile {

	@Test
	public void patchProfileTest() {
		
		AuthService authService = new AuthService();
		Response loginRequest = authService.login(new LoginRequest("naruto123", "naruto123"));
		LoginResponse loginResponse = loginRequest.as(LoginResponse.class);
		
		PartialProfileUpdateRequest partialProfileUpdateRequest = new PartialProfileUpdateRequest.Builder()
				.firstname("sasuke").lastName("ucahiha").email("naruto.fox@yahoo.com").build();
		
		UserProfileManagment managmentService = new UserProfileManagment();
		Response response = managmentService.partialUpdateProfile(loginResponse.getToken(), partialProfileUpdateRequest);
		
		response.prettyPrint();
		
		Response profileResponse = managmentService.getProfile(loginResponse.getToken());
		profileResponse.prettyPrint();
	}
}
