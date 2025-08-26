package com.api.base;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService { //wrapper for Rest Assured

	// base url
	// creating the request
	//handling the response
	
	private static final String BASE_URL = "http://64.227.160.186:8080";
	private RequestSpecification requestSpecification;
	
//	static {
//		RestAssured.filters(new LogginFilters());
//	}
	
	public BaseService() {
		requestSpecification = given().baseUri(BASE_URL);
		
	}
	
	protected void setAuthToken(String tokenName) {
		requestSpecification.header("Authorization","Bearer "+tokenName);
	}
	
	protected Response getRequest(String endpoint) {
		return requestSpecification.get(endpoint);
	}
	
	protected Response postRequest(Object payload, String endpoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
	}
	
	protected Response putRequest(Object payload, String endpoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).put(endpoint);
	}
	
	protected Response patchRequest(Object payload, String endpoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).patch(endpoint);
	}
	
	protected Response deleteRequest(String endpoint) {
		return requestSpecification.delete(endpoint);
	}
	
}
