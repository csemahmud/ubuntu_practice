/**
 * 
 */
package com.khan.OOP01InheritanceAccountApp1Package;

import java.util.ArrayList;
import java.util.List;

import com.khan.OOP01InheritanceAccountApp1Package.classes.Account;
import com.khan.OOP01InheritanceAccountApp1Package.classes.CheckingAccount;
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
		
		List<Account> accountList = new ArrayList<>();
		accountList.add(aSavingsAccount);
		accountList.add(aCheckingAccount);
		accountList.add(new Account("SV:002") {

			@Override
			public String withdraw(double amount) {
				if(getBalance() - amount >= 10_000) {
					
					return super.withdraw(amount);
					
				}
				
				return "\n\tUnderflow !!! Insufficient Balance ";
			}
			
		});
		
		showTransactions(accountList);

	}

	private static void showTransactions(List<Account> accountList) {
		// TODO Auto-generated method stub
		
		accountList.stream().forEach(currentAccount -> {
			
			System.out.println(currentAccount.deposit(50_000));
			System.out.println(currentAccount.withdraw(10_000));
			System.out.println(currentAccount.withdraw(100_000));
			System.out.println(currentAccount);
			
		});
		
	}

}
