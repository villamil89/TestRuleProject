package com.myspace.testruleproject;

/**
 * This class was automatically generated by the data modeler tool.
 */

public class User implements java.io.Serializable {

	static final long serialVersionUID = 1L;

	public static Integer GOLD = 1;
	public static Integer SILVER = 2;
	public static Integer NA = 3;

	private java.lang.Integer age;

	private java.lang.Integer type;

	private java.lang.Integer discount;

	private java.lang.String name;

	/**
	 * 
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param discount
	 *            the discount to set
	 */
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public java.lang.Integer getAge() {
		return this.age;
	}
	public void setAge(java.lang.Integer age) {
		this.age = age;
	}
	public java.lang.Integer getType() {
		return this.type;
	}
	public void setType(java.lang.Integer type) {
		this.type = type;
	}
	public java.lang.Integer getDiscount() {
		return this.discount;
	}
	public void setDiscount(java.lang.Integer discount) {
		this.discount = discount;
	}
	public java.lang.String getName() {
		return this.name;
	}
	public void setName(java.lang.String name) {
		this.name = name;
	}
	public User(java.lang.Integer age, java.lang.Integer type,
			java.lang.Integer discount, java.lang.String name) {
		this.age = age;
		this.type = type;
		this.discount = discount;
		this.name = name;
	}
}