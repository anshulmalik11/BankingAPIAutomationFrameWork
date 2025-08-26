package com.api.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.api.base.UpiController;
import com.api.model.response.LoginResponse;
import com.api.utilites.PropertiesUtility;
import com.api.utilites.RestAssuredUtility;

import io.restassured.response.Response;

public class Upi_paymentStatus {

	@Test
	public void upiPaymentStatusTest() throws IOException {
		LoginResponse loginResponse = new RestAssuredUtility().login();
		UpiController controller = new UpiController();
		String FilePath = ".\\src\\test\\resources\\data.properties";
		String transcationRef = PropertiesUtility.getProperty(FilePath, "transactionReference");
		Response response = controller.paymentStatus(loginResponse.getToken(), transcationRef);
		response.prettyPrint();
		System.out.println(response.statusCode());
	}
}
