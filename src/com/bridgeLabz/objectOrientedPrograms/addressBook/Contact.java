package com.bridgeLabz.objectOrientedPrograms.addressBook;

/**
 * This class has the functionality of first name , last name , email , address
 * , phone Number and getter methods and constructor to initialize the class and
 * a static class type object which helps in accessing the class directly whose
 * return type is class type.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-01
 * @version 11.0.5
 */
public class Contact {
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private long phoneNumber;

	/**
	 * constructor to initialize the class.
	 * 
	 * @param firstName   as String input parameter.
	 * @param lastName    as String input parameter.
	 * @param email       as String input parameter.
	 * @param address     as String input parameter.
	 * @param phoneNumber as Long input parameter.
	 */
	public Contact(String firstName, String lastName, String email, String address, long phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	/**
	 * getter method to get firstName
	 * 
	 * @return String data
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * getter method to get lastName
	 * 
	 * @return String data
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * getter method to get emailId
	 * 
	 * @return String data
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * getter method to get address
	 * 
	 * @return String data
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * getter method to get phone Number
	 * 
	 * @return Long data
	 */
	public long getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * This method takes first name , last name , email id , address, phone number
	 * as input parameter and returns the new class type static object.
	 * 
	 * @param firstName   as String input parameter.
	 * @param lastName    as String input parameter.
	 * @param email       as String input parameter.
	 * @param address     as String input parameter.
	 * @param phoneNumber as Long input parameter.
	 * @return Class type new Contact
	 */
	public static Contact createContact(String firstName, String lastName, String email, String address,
			long phoneNumber) {
		return new Contact(firstName, lastName, email, address, phoneNumber);
	}

	/**
	 * override method of toString which prints the data as single String.
	 */
	@Override
	public String toString() {
		return this.firstName + " " + this.lastName;
	}

}
