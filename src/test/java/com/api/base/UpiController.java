package com.api.base;

import com.api.model.request.QRCodeRequest;
import com.api.model.request.UpiId;
import com.api.model.request.UpiPaymentInitiateRequest;

import io.restassured.response.Response;

public class UpiController extends BaseService {
	
	private static final String BASE_PATH = "/api/upi/";
	
	public Response paymentInitiate(String token, UpiPaymentInitiateRequest payload) {
		setAuthToken(token);
		return postRequest(payload, BASE_PATH+"payment/initiate");
	}
	public Response paymentStatus(String token, String transactionRef) {
		setAuthToken(token);
		return getRequest(BASE_PATH+"payment/status/"+transactionRef);
	}
	
	public Response QRGenerator(String token, QRCodeRequest payload) {
		setAuthToken(token);
		return postRequest(payload, BASE_PATH+"qr-code/generator");
	}
	
	public Response upiVerify(String token, UpiId payload) {
		setAuthToken(token);
		return postRequest(payload, BASE_PATH+"verify");
	}
}
