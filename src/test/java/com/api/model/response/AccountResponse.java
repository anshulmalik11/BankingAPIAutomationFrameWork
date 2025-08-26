package com.api.model.response;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

	public class AccountResponse {
	    private String accountNumber;
	    private String accountType;
	    private double balance;
	    private String status;
	    private String branch;
	    private LocalDateTime createdAt;
	    private String ownerName;
	    
	    public AccountResponse() {
	    	
	    }
		public AccountResponse(String accountNumber, String accountType, double balance, String status, String branch,
				LocalDateTime createdAt, String ownerName) {
			super();
			this.accountNumber = accountNumber;
			this.accountType = accountType;
			this.balance = balance;
			this.status = status;
			this.branch = branch;
			this.createdAt = createdAt;
			this.ownerName = ownerName;
		}
		public String getAccountNumber() {
			return accountNumber;
		}
		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}
		public String getAccountType() {
			return accountType;
		}
		public void setAccountType(String accountType) {
			this.accountType = accountType;
		}
		public double getBalance() {
			return balance;
		}
		public void setBalance(double balance) {
			this.balance = balance;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getBranch() {
			return branch;
		}
		public void setBranch(String branch) {
			this.branch = branch;
		}
		public LocalDateTime getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}
		public String getOwnerName() {
			return ownerName;
		}
		public void setOwnerName(String ownerName) {
			this.ownerName = ownerName;
		}
		@Override
		public String toString() {
			return "AccountResponse [accountNumber=" + accountNumber + ", accountType=" + accountType + ", balance="
					+ balance + ", status=" + status + ", branch=" + branch + ", createdAt=" + createdAt
					+ ", ownerName=" + ownerName + "]";
		}
}
