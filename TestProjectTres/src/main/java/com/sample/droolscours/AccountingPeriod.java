/**
 * 
 */
package com.sample.droolscours;

import java.util.Date;

/**
 * @author ovillamil
 *
 */
public class AccountingPeriod {

	private Date startDate;
	private Date endDate;
	
	
	
	@Override
	public String toString() {
		return "AccountingPeriod [startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
	/**
	 * 
	 */
	public AccountingPeriod() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
