package com.dollarsbank.model;

public class Account {
	
	private int accountId;
	private int customerId;
	private double balance;
	
	private static int maxId = 0;
	
	public Account(int accountId, int customerId, double balance) {
		super();
		if (accountId > maxId ) {
			maxId = accountId;
		}
		this.accountId = accountId;
		this.customerId = customerId;
		this.balance = balance;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public static int generateAccountId() {
		return ++maxId;
	}

	@Override
	public String toString() {
		return "Account Info [AccountId= " + getAccountId() + ", CustomerId= " + getCustomerId() + ", Balance= "
				+ getBalance() + "]";
	}
	
	
}
