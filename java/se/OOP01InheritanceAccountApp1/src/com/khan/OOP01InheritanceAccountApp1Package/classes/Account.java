/**
 * 
 */
package com.khan.OOP01InheritanceAccountApp1Package.classes;

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 *
 */
public class Account {
	
	private final String accNo;
	private double balance;

	/**
	 * @param accNo
	 */
	public Account(String accNo) {
		super();
		this.accNo = accNo;
		System.out.println("\n\tBase Constructor has been called .");
	}

	/**
	 * 
	 */
	public Account() {
		// TODO Auto-generated constructor stub
		
		this("");
	}

	/**
	 * @return the accNo
	 */
	public final String getAccNo() {
		return accNo;
	}

	/**
	 * @return the balance
	 */
	public final double getBalance() {
		return balance;
	}
	
	public final String deposit(double amount) {
		
		balance += amount;
		return "\n\tDeposited " + amount + " Yen Successfully .";
	}
	
	public String withdraw(double amount) {
		
		balance -= amount;
		return "\n\tWithdrawn " + amount + " Yen Successfully .";
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n\tAccount [accNo = ").append(accNo).append(", balance = ").append(balance).append(" Yen Only]");
		return builder.toString();
	}

}
