/**
 * 
 */
package com.sample.model;

/**
 * @author ovillamil
 *
 */
public class ProductPrice {

	private Integer basePrice;

	/**
	 * @return the basePrice
	 */
	public Integer getBasePrice() {
		return basePrice;
	}

	/**
	 * @param basePrice the basePrice to set
	 */
	public void setBasePrice(Integer basePrice) {
		this.basePrice = basePrice;
	}

	/**
	 * @param basePrice
	 */
	public ProductPrice(Integer basePrice) {
		super();
		this.basePrice = basePrice;
	}

}
