package com.khan.OOP01InheritanceAccountApp1Package.classes;

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 *
 */
public interface IAccount {

	/**
	 * @return the accNo
	 */
	String getAccNo();

	/**
	 * @return the balance
	 */
	double getBalance();

	/**
	 * @param balance the balance to set
	 */
	void setBalance(double balance);

	String deposit(double amount);

	String withdraw(double amount);

	String bankTransfer(String transferToAccNo, double amount);

    @Override
	String toString();

}