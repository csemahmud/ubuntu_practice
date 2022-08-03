/**
 * 
 */
package com.khan.OOP01InheritanceAccountApp1Package;

import java.util.ArrayList;
import java.util.List;

import com.khan.OOP01InheritanceAccountApp1Package.classes.CheckingAccount;
import com.khan.OOP01InheritanceAccountApp1Package.classes.IAccount;
import com.khan.OOP01InheritanceAccountApp1Package.classes.SavingsAccount;

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 *
 */
public class MainProgram {

	/**
	 * 
	 */
	public MainProgram() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("\n\n\n\tOOP01InheritanceAccountApp1 ..... ");
		SavingsAccount aSavingsAccount = new SavingsAccount("SV:001", 4500);
		CheckingAccount aCheckingAccount = new CheckingAccount("CK:001", 2500);
		
		List<IAccount> accountList = new ArrayList<>();
		accountList.add(aSavingsAccount);
		accountList.add(aCheckingAccount);
		accountList.add(new IAccount() {
			
			private String accNo = "SV:002";
			private double balance = 0;
			private final double bankTransferFee = 250;

			/**
			 * @return the accNo
			 */
			@Override
			public final String getAccNo() {
				return accNo;
			}

			/**
			 * @return the balance
			 */
			@Override
			public final double getBalance() {
				return balance;
			}
			
			/**
			 * @param balance the balance to set
			 */
			@Override
			public final void setBalance(double balance) {
				this.balance = balance;
			}

			@Override
			public String withdraw(double amount) {
				if(getBalance() - amount >= 10_000) {
					
					return "\n\tWithdrawn " + amount + " Yen Successfully .";
					
				}
				
				return "\n\tUnderflow !!! Insufficient Balance ";
			}

			@Override
			public String bankTransfer(String transferToAccNo, double amount) {
				// TODO Auto-generated method stub
				
				if(getBalance() - amount - bankTransferFee >= 10_000) {
					
					setBalance(getBalance() - amount - bankTransferFee);
					return "\n\tTransferred " + amount + " Yen to account : " 
							+ transferToAccNo + " Successfully .";
					
				}
				
				return "\n\tUnderflow !!! Insufficient Balance ";
			}

			@Override
			public String deposit(double amount) {
				// TODO Auto-generated method stub
				
				balance += amount;
				return "\n\tDeposited " + amount + " Yen Successfully .";
			}

			@Override
			public String toString() {
				StringBuilder builder = new StringBuilder();
				builder.append("\n\tAccount [accNo = ").append(accNo).append(", balance = ").append(balance).append(" Yen Only]");
				return builder.toString();
			}
			
		});
		
		showTransactions(accountList);

	}

	private static void showTransactions(List<IAccount> accountList) {
		// TODO Auto-generated method stub
		
		accountList.stream().forEach(currentAccount -> {
			
			System.out.println(currentAccount.deposit(50_000));
			System.out.println(currentAccount.withdraw(10_000));
			System.out.println(currentAccount.withdraw(100_000));
			System.out.println(currentAccount.bankTransfer("MUFG:123", 10_000));
			System.out.println(currentAccount.bankTransfer("MUFG:123", 100_000));
			System.out.println(currentAccount);
			
		});
		
	}

}
