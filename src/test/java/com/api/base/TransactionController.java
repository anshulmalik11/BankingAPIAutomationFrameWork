package com.api.base;

import com.api.model.request.DepositRequest;
import com.api.model.request.TransferRequest;
import com.api.model.request.WithdrawRequest;

import io.restassured.response.Response;

public class TransactionController extends BaseService {

	private static final String BASE_PATH = "/api/transactions/";
	
	public Response Deposit(String token, DepositRequest payload) {
		setAuthToken(token);
		return postRequest(payload, BASE_PATH+"deposit");
	}
	
	public Response getHistory(String token, String accountNumber) {
		setAuthToken(token);
		return getRequest(BASE_PATH+"history?accountNumber="+accountNumber+"&page=0&size=10");
	}
	
	public Response transfer(String token, TransferRequest payload) {
		setAuthToken(token);
		return postRequest(payload, BASE_PATH+"transfer");
	}
	
	public Response transferInitiate(String token, TransferRequest payload) {
		setAuthToken(token);
		return postRequest(payload, BASE_PATH+"transfer/initiate");
	}
	
	public Response withdraw(String token, WithdrawRequest payload) {
		setAuthToken(token);
		return postRequest(payload, BASE_PATH+"withdraw");
	}
}
