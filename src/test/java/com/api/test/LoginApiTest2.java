package com.api.test;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class LoginApiTest2 {

	@Test(description = "Verify if login api is working")
	public void loginTest() {
		 
		Response response = given().
				baseUri("http://64.227.160.186:8080").
				basePath("/api/auth").
				header("Content-Type","application/json").
				body("{\"username\": \"naruto123\",\"password\": \"naruto123\"}"). //username ansh/uday1234 : password ansh1234/uday12345
				post("/login");
		Assert.assertEquals(response.statusCode(), 200); 
		response.prettyPrint();
		
	}
}
