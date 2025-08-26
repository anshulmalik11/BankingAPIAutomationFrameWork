package com.api.base;

import io.restassured.response.Response;

public class ReportsController extends BaseService{

	private static final String BASE_Path = "/api/reports/statement/";
	
	public Response ExcelReport(String token, String accountNumber) {
		setAuthToken(token);
		return getRequest(BASE_Path+"excel?accountNumber="+accountNumber);
	}
	
	
	public Response pdfReport(String token, String accountNumber) {
		setAuthToken(token);
		return getRequest(BASE_Path+"pdf?accountNumber="+accountNumber);
	}
}
