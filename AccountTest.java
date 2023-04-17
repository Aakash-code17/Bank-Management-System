package com.Bank;

import java.util.*;

public class AccountTest {

	public static void main(String[] args) {
    
		Scanner key=new Scanner(System.in); 
		
		// Create array of Accounts
        Account accounts[] = new Account[10];	
        int numAccounts=0;
        
	    int choice;
	    
	       do {
	    	   choice=menu(key);
	    	   System.out.println();
	    	   
	    	   if(choice==1){
	    		   accounts[numAccounts++]=createAccount(key);
	    	   }else if(choice==2) {
	    	       doDeposit(accounts,numAccounts,key);  
	    	   }else if(choice==3) {
	    	       doWithdraw(accounts,numAccounts,key);
	    	   }else if(choice==4) {
	    	       applyInterest(accounts,numAccounts,key);
	    	   }else{
	    	       System.out.println("GoodBye!");
	    	   }
	    	   System.out.println();   
	       }while(choice!=5); 
	    }
	    
	public static int accountMenu(Scanner key) {
		System.out.println("Select Account Type");
        System.out.println("1. Current Account");
        System.out.println("2. Savings Account");
        
        int choice;
        do {
        	System.out.println("Enter choice: ");
        	choice =key.nextInt();
        	if(choice < 1 ||choice >2)
        	{
        		System.out.println("Please enter the valid choice: ");	
        	}
        }while(choice < 1 ||choice >2);
		return choice;
	}
	
	  public static int searchAccount(Account accounts [], int count, int accountNumber) {

	        for(int i=0; i<count; i++) {
	            if(accounts[i].getAccountNumber() == accountNumber) {
	                return i;
	            }
	        }
	        return -1; 
	    }
		
		public static Account createAccount(Scanner key) {
			
			Account account=null;
			int choice=accountMenu(key);
			
			int accountNumber;
			System.out.println("Enter Account Number: ");
			accountNumber=key.nextInt();
			
			if(choice==1)
			{
			    account=new CurrentAccount(accountNumber);
			}
			else {
				System.out.println("Please enter InterestRate:");
				double ir=key.nextDouble();
			    account=new SavingsAccount(accountNumber,ir);
			}
			return account;
		}
		
		public static void doDeposit(Account accounts [], int count, Scanner key) {
	        // Get the account number
	        System.out.print("\nPlease enter account number: ");
	        int accountNumber = key.nextInt();

	        // search for account
	        int index = searchAccount(accounts, count, accountNumber);

	        if(index >= 0) {
	            // Amount
	            System.out.print("Please enter Deposit Amount: ");
				double amount = key.nextDouble();

	            accounts[index].deposit(amount);
	        } else {
	            System.out.println("No account exist with AccountNumber: " + accountNumber);
	        }
	    }
		
       public static void doWithdraw(Account accounts[],int count,Scanner key) {
			
			System.out.print("\nPlease Enter the account number: ");
			int accountNumber=key.nextInt();
			
			// search for account
			int index=searchAccount(accounts,count,accountNumber);
			
			if(index>=0)
			{
				System.out.print("Please enter Withdraw Amount: ");
	            double amount = key.nextDouble();
	            
	            accounts[index].withdraw(amount);
			}else {
				System.out.println("No account exist with AccountNumber: " + accountNumber);
			}
			
		}
       
       public static void applyInterest(Account accounts[],int count,Scanner key) {
    	   
    	   System.out.println("Please Enter the account number: ");
    	   int accountNumber=key.nextInt();
    	   
    	   int index=searchAccount(accounts,count,accountNumber);
    	   
    	   if(index >=0) {
    		   
    		   if(accounts[index] instanceof SavingsAccount) {
    			  ((SavingsAccount)accounts[index]).applyInterest();
    		   }
    	   }else {
    		   System.out.println("No account exist with AccountNumber: " + accountNumber);   
    	   }
    	   
       } 
       
       public static int menu(Scanner key) {
       	System.out.println("Bank Account menu:");
       	System.out.println("1: Create New Account");
       	System.out.println("2: Deposit Funds");
       	System.out.println("3: Withdraw Funds");
       	System.out.println("4: Apply Interest");
       	System.out.println("5: Quit");
       	
       	int choice;
       
           do {
				System.out.println("Enter choice: ");
				choice=key.nextInt();
				if(choice < 1 || choice > 5)
				{
				     System.out.println("Please enter valid choice: ");   
				}
			}while(choice < 1 || choice > 5);
				return choice;
       }
	}

