/**
 * 
 */
package com.sample.droolscours;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author ovillamil
 *
 */
public class CashFlow {

	private Date date;
	private double amount;
	private int type;
	private long accountNo;
	public static int CREDIT = 1;
	public static int DEBIT = 2;

	@Override
	public String toString() {
		StringBuffer buff = new StringBuffer();
		buff.append("-----CashFlow-----)\n");
		buff.append("Account no=" + this.accountNo + "\n");
		if (this.date != null) {
			buff.append("Mouvement Date= " + DateFormat.getDateInstance().format(this.date) + "\n");
		} else {
			buff.append("No Mouvement date was set\n");
		}
		buff.append("Mouvement Amount=" + this.amount + "\n");
		buff.append("-----CashFlow end--)");
		return buff.toString();
	}

	/**
	 * 
	 */
	public CashFlow() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
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

}
