/**
 * 
 */
package com.khan.OOP01InheritanceAccountApp1Package.classes;

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 *
 */
public final class CheckingAccount extends Account {
	
	private int noOfTransactions;
	private final double serviceCharge;
	private final double bankTransferFee = 500;

	/**
	 * @param accNo
	 * @param serviceCharge
	 */
	public CheckingAccount(String accNo, double serviceCharge) {
		super(accNo);
		this.serviceCharge = serviceCharge;
		System.out.println("\n\tChecking Constructor has been called .");
	}

	/**
	 * @param accNo
	 */
	public CheckingAccount(String accNo) {
		this(accNo, 0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	public CheckingAccount() {
		// TODO Auto-generated constructor stub
		
		this("");
	}

	/**
	 * @return the noOfTransactions
	 */
	public final int getNoOfTransactions() {
		return noOfTransactions;
	}

	/**
	 * @param noOfTransactions the noOfTransactions to set
	 */
	public final void setNoOfTransactions(int noOfTransactions) {
		this.noOfTransactions = noOfTransactions;
	}

	/**
	 * @return the serviceCharge
	 */
	public final double getServiceCharge() {
		return serviceCharge;
	}

	/**
	 * @return the bankTransferFee
	 */
	public final double getBankTransferFee() {
		return bankTransferFee;
	}

	@Override
	public final String bankTransfer(String transferToAccNo, double amount) {
		// TODO Auto-generated method stub
			
		setBalance(getBalance() - amount - bankTransferFee);
		return "\n\tTransferred " + amount + " Yen to account : " 
				+ transferToAccNo + " Successfully .";
	}

}
