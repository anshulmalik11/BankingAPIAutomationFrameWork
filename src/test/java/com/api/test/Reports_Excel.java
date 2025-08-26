package com.api.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.api.base.ReportsController;
import com.api.model.response.LoginResponse;
import com.api.utilites.PropertiesUtility;
import com.api.utilites.RestAssuredUtility;

import io.restassured.response.Response;

public class Reports_Excel {

	@Test
	public void excelReportTest() throws IOException {
		LoginResponse loginResponse = new RestAssuredUtility().login();
		ReportsController controller = new ReportsController();
		Response response = controller.ExcelReport(loginResponse.getToken(), 
				PropertiesUtility.getProperty(".\\src\\test\\resources\\data.properties", "accountNumber"));
		System.out.println(response.statusLine());
	}
}
