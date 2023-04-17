package com.Bank;

public abstract class Account{
	
	private int accountNumber;
	
	protected double balance;

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(int accountNumber) {
		this.accountNumber = accountNumber;
		balance = 0;
	}

	public int getAccountNumber() {
		return this.accountNumber;
	}

	public double getBalance() {
		return this.balance;
	}
	
	public abstract void deposit(double amount);
	
	public abstract void withdraw(double amount);

}