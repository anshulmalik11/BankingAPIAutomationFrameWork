package com.api.base;

import com.api.model.request.CreateAccountRequest;

import io.restassured.response.Response;

public class AccountController extends BaseService {

	private static final String BASE_PATH = "/api/";
	
	public Response createAccount(String token, CreateAccountRequest payload) {
		
		setAuthToken(token);
		return postRequest(payload, BASE_PATH+"accounts");
	}
	
	public Response getAccountData(String token, String accountNumber) {
		setAuthToken(token);
		return getRequest(BASE_PATH+"accounts/"+accountNumber);
	}
	
	public Response getAccountList(String token) {
		setAuthToken(token);
		return getRequest(BASE_PATH+"accounts/user");
	}
}
