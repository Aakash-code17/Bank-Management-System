package com.Bank;

public class CurrentAccount extends Account{
	
	private static double FEE=0.5;

	public CurrentAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CurrentAccount(int accountNumber) {
		super(accountNumber);
		// TODO Auto-generated constructor stub
	}
	
	public void deposit(double amount) {
		if(amount > 0) {
			balance+=amount;
			System.out.printf("Amount %.2f deposited%n",amount);
			
			balance -=FEE;
			System.out.printf("Fee %.2f applied%n",FEE);
			System.out.printf("Current balance is:%.2f%n",balance);
		}else {
			System.out.println("A negative amount cannot be deposited");
		}
	}
	
	public void withdraw(double amount) {
		if(amount > 0) {
			if((amount+FEE) <= balance) {
				System.out.printf("Amount %.2f withdraw%n",amount);
				balance-=amount;
				
				balance-=FEE;
				System.out.printf("Fee %.2f applied%n",FEE);
				System.out.printf("Current balance is: %.2f%n",balance);
			}
		}else {
			System.out.println("Negative amount cannot be withdraw!");
		}
	}
}
