package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagmentService;
import com.api.model.request.LoginRequest;
import com.api.model.request.ProfileRequest;
import com.api.model.response.LoginResponse;
import com.api.model.response.UserProfileResponse;

import io.restassured.response.Response;

public class UpdateProfileTest {

	@Test
	public void updateProfileTest() {
		
		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest("ansh", "ansh1234"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		response.prettyPrint();
		
		System.out.println("----------------------------------------");
		
		
		UserProfileManagmentService managmentService = new UserProfileManagmentService();
		response = managmentService.getProfile(loginResponse.getToken());
		response.prettyPrint();
		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		Assert.assertEquals(userProfileResponse.getUsername(), "ansh");
		
		System.out.println("----------------------------------------");

		ProfileRequest profileRequest = new ProfileRequest.Builder()
				.firstname("Disha")
				.lastname("patani")
				.email("Disha@gmail.com")
				.mobilenumber("84428263842")
				.build();
		
		response = managmentService.updateProfile(loginResponse.getToken(), profileRequest);
		response.prettyPrint();
	}
}
