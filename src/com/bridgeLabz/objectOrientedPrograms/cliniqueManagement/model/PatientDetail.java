package com.bridgeLabz.objectOrientedPrograms.cliniqueManagement.model;

/**
 * This is the Model class of Patient which bears the functionality of name, id,
 * mobile number, age and all getter setters of above functionality.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-19
 * @version 1.8
 */

public class PatientDetail {

	private String name;
	private String id;
	private long mobileNumber;
	private int age;

	/**
	 * Constructor to initialize the class
	 */
	public PatientDetail() {
		super();

	}

	/**
	 * Getter method to get name
	 * 
	 * @return String value
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter method to set name
	 * 
	 * @param name as String parameter
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter method to get id
	 * 
	 * @return String value
	 */
	public String getId() {
		return id;
	}

	/**
	 * Setter method to set id
	 * 
	 * @param id as String parameter
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Getter method to get mobile number
	 * 
	 * @return long value
	 */
	public long getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * Setter method to Set mobile number
	 * 
	 * @param mobileNumber as Long input parameter
	 */
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * Getter method to get age
	 * 
	 * @return Integer value
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Setter method to set age
	 * 
	 * @param age as integer input parameter
	 */
	public void setAge(int age) {
		this.age = age;
	}

}
