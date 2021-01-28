/**
 * 
 */
package com.sample.droolscours;

/**
 * @author ovillamil
 *
 */
public class Account {

	private long accountNo;
	private double balance;
	
	/**
	 * 
	 */
	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", balance=" + balance + "]";
	}
	
	/**
	 * 
	 */
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the accountNo
	 */
	public long getAccountNo() {
		return accountNo;
	}
	/**
	 * @param accountNo the accountNo to set
	 */
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
