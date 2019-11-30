package com.bridgeLabz.objectOrientedPrograms.addressBook;

public class Contact {
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private long phoneNumber;

	public Contact(String firstName, String lastName, String email, String address, long phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

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
