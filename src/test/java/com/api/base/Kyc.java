package com.api.base;

import io.restassured.response.Response;

public class Kyc extends BaseService{

	private static final String BASE_PATH= "/api/kyc/";
	
	public Response getKycStatus(String token) {
		setAuthToken(token);
		return getRequest(BASE_PATH+"status");
	}
	
	public Response uploadKyc (String token, Object payload) {
		setAuthToken(token);
		return postRequest(payload, BASE_PATH+"upload");
	}
}
