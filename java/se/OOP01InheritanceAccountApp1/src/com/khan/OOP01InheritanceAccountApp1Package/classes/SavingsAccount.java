/**
 * 
 */
package com.khan.OOP01InheritanceAccountApp1Package.classes;

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 *
 */
public final class SavingsAccount extends Account {
	
	private final double interestAmount;
	private final double bankTransferFee = 250;

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

	/**
	 * @return the bankTransferFee
	 */
	public final double getBankTransferFee() {
		return bankTransferFee;
	}

	@Override
	public final String withdraw(double amount) {
		// TODO Auto-generated method stub
		
		if(getBalance() - amount >= 10_000) {
			
			return super.withdraw(amount);
			
		}
		
		return "\n\tUnderflow !!! Insufficient Balance ";
	}

	@Override
	public final String bankTransfer(String transferToAccNo, double amount) {
		// TODO Auto-generated method stub
		
		if(getBalance() - amount - bankTransferFee >= 10_000) {
			
			setBalance(getBalance() - amount - bankTransferFee);
			return "\n\tTransferred " + amount + " Yen to account : " 
					+ transferToAccNo + " Successfully .";
			
		}
		
		return "\n\tUnderflow !!! Insufficient Balance ";
	}

}
