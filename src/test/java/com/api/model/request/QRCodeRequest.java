package com.api.model.request;

public class QRCodeRequest {

	private String merchantVpa;
	private String merchantName;
	private int amount;
	private String transactionNote;
	
	public QRCodeRequest() {
		
	}

	public QRCodeRequest(String merchantVpa, String merchantName, int amount, String transactionNote) {
		super();
		this.merchantVpa = merchantVpa;
		this.merchantName = merchantName;
		this.amount = amount;
		this.transactionNote = transactionNote;
	}

	public String getMerchantVpa() {
		return merchantVpa;
	}

	public void setMerchantVpa(String merchantVpa) {
		this.merchantVpa = merchantVpa;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getTransactionNote() {
		return transactionNote;
	}

	public void setTransactionNote(String transactionNote) {
		this.transactionNote = transactionNote;
	}

	@Override
	public String toString() {
		return "QRCodeRequest [merchantVpa=" + merchantVpa + ", merchantName=" + merchantName + ", amount=" + amount
				+ ", transactionNote=" + transactionNote + "]";
	}

	public static class Builder {

		private String merchantVpa;
		private String merchantName;
		private int amount;
		private String transactionNote;

		public Builder merchantVpa(String merchantVpa) {
			this.merchantVpa = merchantVpa;
			return this;
		}

		public Builder merchantName(String merchantName) {
			this.merchantName = merchantName;
			return this;
		}

		public Builder amount(int amount) {
			this.amount = amount;
			return this;
		}

		public Builder transactionNote(String transactionNote) {
			this.transactionNote = transactionNote;
			return this;
		}

		public QRCodeRequest build() {
			QRCodeRequest codeRequest = new QRCodeRequest(merchantVpa, merchantName, amount, transactionNote);
			return codeRequest;
		}
	}
}
