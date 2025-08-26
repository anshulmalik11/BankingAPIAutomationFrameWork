package com.api.model.request;

public class UpiId {

	private String upiId;

	public UpiId(String upiId) {
		super();
		this.upiId = upiId;
	}

	public String getUpiId() {
		return upiId;
	}

	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}

	@Override
	public String toString() {
		return "UpiId [upiId=" + upiId + "]";
	}
	
}
