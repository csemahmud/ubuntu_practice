/**
 * 
 */
package com.khan.OOP01InheritanceAccountApp1Package.classes;

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 *
 */
public class SavingsAccount extends Account {
	
	private final double interestAmount;

	/**
	 * @param accNo
	 * @param interestAmount
	 */
	public SavingsAccount(String accNo, double interestAmount) {
		super(accNo);
		this.interestAmount = interestAmount;
		System.out.println("\n\tSavings Constructor has been called .");
	}

	/**
	 * @param accNo
	 */
	public SavingsAccount(String accNo) {
		this(accNo, 0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	public SavingsAccount() {
		// TODO Auto-generated constructor stub
		
		this("");
	}

	/**
	 * @return the interestAmount
	 */
	public final double getInterestAmount() {
		return interestAmount;
	}

	@Override
	public String withdraw(double amount) {
		// TODO Auto-generated method stub
		
		if(getBalance() - amount >= 10_000) {
			
			return super.withdraw(amount);
			
		}
		
		return "\n\tUnderflow !!! Insufficient Balance ";
	}

}
