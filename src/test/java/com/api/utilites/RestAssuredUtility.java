package com.api.utilites;

import java.io.IOException;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.model.request.LoginRequest;
import com.api.model.response.LoginResponse;

public class RestAssuredUtility {
	
	
	public static LoginResponse login() throws IOException {
		PropertiesUtility propertiesUtility = new PropertiesUtility();
		String filePath = ".\\src\\test\\resources\\data.properties";
		String username = propertiesUtility.getProperty(filePath,"username");
		String password = propertiesUtility.getProperty(filePath,"password");
		
		AuthService authService = new AuthService();
		LoginResponse loginResponse = authService.login(new LoginRequest(username, password)).as(LoginResponse.class);
		return loginResponse;
	}
	
	public static LoginResponse login(String username, String password) {
		
		AuthService authService = new AuthService();
		LoginResponse loginResponse = authService.login(new LoginRequest(username, password)).as(LoginResponse.class);
		return loginResponse;
	}
}
