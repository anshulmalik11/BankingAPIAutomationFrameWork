package com.api.base;

import com.api.model.request.ChangePasswordRequest;
import com.api.model.request.PartialProfileUpdateRequest;
import com.api.model.request.ProfileRequest;

import io.restassured.response.Response;

public class UserProfileManagment extends BaseService {

	private static final String BASE_PATH = "/api/users/";
	
	public Response changePassword(String token, ChangePasswordRequest payload) {
		setAuthToken(token);
		return putRequest(payload, BASE_PATH+"change-password");
	}
	
	public Response getProfile(String token) {
		setAuthToken(token);
		return getRequest(BASE_PATH+"profile");
	}
	
	public Response updateProfile(String token, ProfileRequest payload) {
		setAuthToken(token);
		return putRequest(payload, BASE_PATH+"profile");
	}
	
	public Response deleteProfile(String token) {
		setAuthToken(token);
		return deleteRequest(BASE_PATH+"profile");
	}
	
	public Response partialUpdateProfile(String token, PartialProfileUpdateRequest payload) {
		setAuthToken(token);
		return patchRequest(payload, BASE_PATH+"profile");
	}
}
