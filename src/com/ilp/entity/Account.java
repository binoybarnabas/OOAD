package com.ilp.entity;

public  class Account {

	private String accountNo;
	private double accountBalance;
	private Product accountType;

	public Account(String accountNo, double accountBalance, Product accountType) {
		super();
		this.accountNo = accountNo;
		this.accountBalance = accountBalance;
		this.accountType = accountType;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Product getAccountType() {
		return accountType;
	}

	public void setAccountType(Product accountType) {
		this.accountType = accountType;
	}
	


}
