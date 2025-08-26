package com.api.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.api.base.UpiController;
import com.api.model.request.UpiPaymentInitiateRequest;
import com.api.model.response.LoginResponse;
import com.api.utilites.RestAssuredUtility;

import io.restassured.response.Response;

public class Upi_PaymentInitiate {

	@Test
	public void upiPaymentInitiateTest() throws IOException {
		RestAssuredUtility assuredUtility = new RestAssuredUtility();
		LoginResponse loginResponse = assuredUtility.login();
		System.out.println(loginResponse.getToken());
		UpiPaymentInitiateRequest initiateRequest = new UpiPaymentInitiateRequest.Builder()
				.fromUpi("kakku@ptsbi")
				.toUpi("kalia@ptsbi")
				.amount(500)
				.note("upi payment initiate Test")
				.build();
		
		UpiController controller = new UpiController();
		Response response = controller.paymentInitiate(loginResponse.getToken(), initiateRequest);
		response.prettyPrint();
	}
}
