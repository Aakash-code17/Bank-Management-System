package com.Bank;

public class SavingsAccount extends Account {

	private double interestRate;

	public SavingsAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SavingsAccount(int accountNumber, double interestRate) {
		super(accountNumber);
		this.interestRate = interestRate;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double calcInterest() {
		return  balance * interestRate;
		
	}
	
	public void applyInterest() {
		double interest= calcInterest();
		System.out.printf("Interest amount %.2f added to balance%n",interest);
		deposit(interest);
	}
	
	public void deposit(double amount) {
	
		if(amount > 0) {
			balance = balance+amount;
			System.out.printf("Amount %.2f deposited%n",amount);
			System.out.printf("Current balance is: %.2f%n",balance);
	     } else {
			System.out.println("A negative amount cannot deposited");
		}	    
	}
	
	public void withdraw(double amount) {
		if(amount > 0)
		{
		   if((amount) <= balance)
		   {
		 	  System.out.printf("Amount %.2f withdraw%n",amount);
		 	 balance-=amount;
			  System.out.printf("Current balance is: %.2f%n",balance);
		   }
		 }else {
			  System.out.println("Negative amount cannot be withdraw!");
		   }	
        }
}
