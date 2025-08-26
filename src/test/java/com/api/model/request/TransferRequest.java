package com.api.model.request;

public class TransferRequest {

	private String fromAccount;
	private String toAccount;
	private int amount;
	private String description;

	public TransferRequest() {

	}

	public TransferRequest(String fromAccount, String toAccount, int amount, String description) {
		super();
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.amount = amount;
		this.description = description;
	}

	public String getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}

	public String getToAccount() {
		return toAccount;
	}

	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "TransferRequest [fromAccount=" + fromAccount + ", toAccount=" + toAccount + ", amount=" + amount
				+ ", description=" + description + "]";
	}

	public static class Builder {

		private String fromAccount;
		private String toAccount;
		private int amount;
		private String description;

		public Builder fromAccount(String fromAccount) {
			this.fromAccount = fromAccount;
			return this;
		}
		
		public Builder toAccount(String toAccount) {
			this.toAccount = toAccount;
			return this;
		}

		public Builder amount(int amount) {
			this.amount = amount;
			return this;
		}

		public Builder description(String description) {
			this.description = description;
			return this;
		}
		
		public TransferRequest build() {
			TransferRequest request = new TransferRequest(fromAccount, toAccount, amount, description);
			return request;
		}
	}
}
