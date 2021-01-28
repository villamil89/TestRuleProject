/**
 * 
 */
package com.sample.droolscours;

/**
 * @author ovillamil
 *
 */
public class User {
	
	private Integer age;
	private Integer type;
	private Integer discount;
	private String name;
	
	public static Integer GOLD = 1;
	public static Integer SILVER = 2;
	public static Integer NA = 3;
	
	/**
	 * @param type
	 * @param age
	 * @param name
	 */
	public User(Integer age, Integer type, String name) {
		super();
		this.type = type;
		this.age = age;
		this.name = name;
	}
	/**
	 * 
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
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
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	/**
	 * @return the discount
	 */
	public Integer getDiscount() {
		return discount;
	}
	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
