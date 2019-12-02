package com.bridgeLabz.objectOrientedPrograms.addressBook;

import java.util.ArrayList;

/**
 * This class has a array list which store the data of the address book. Some
 * functionalities like add new contact, update existing contact search the
 * contact on basis of name , search the contact on basis of contact object
 * remove the contact and find the contact from the list on the basis of first
 * name and print the inDetail contact and also print on the basis of first name
 * and last name .
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-01
 * @version 11.0.5
 */
public class AddressBookOperations {
	private String addressBookName;
	public ArrayList<Contact> addressBook;

	/**
	 * Constructor to initialize arrayList and assign the name to the address book.
	 * 
	 * @param addressBookName as input parameter
	 */
	public AddressBookOperations(String addressBookName) {
		this.addressBookName = addressBookName;
		this.addressBook = new ArrayList<Contact>();
	}

	/**
	 * getter method which returns name of address book
	 * 
	 * @return name of address book
	 */
	public String getAddressBookName() {
		return addressBookName;
	}

	/**
	 * setter method allows you to set the name of your address book.
	 * 
	 * @param addressBookName
	 */
	public void setAddressBookName(String addressBookName) {
		this.addressBookName = addressBookName;
	}

	/**
	 * takes Contact class type input parameter and checks whether it is present or
	 * not if not present then add the contact to the list.
	 * 
	 * @param contact class type as input parameter.
	 * @return boolean value.
	 */
	public boolean addNewContact(Contact contact) {
		if (findContact(contact.getFirstName()) >= 0) {
			System.out.println("Contact already exist!");
			return false;
		} else {
			addressBook.add(contact);
			return true;
		}
	}

	/**
	 * This function takes contact as parameter and returns the index value of the
	 * entry contact if exist in the list value greater than equal to zero else
	 * returns negative value
	 * 
	 * @param contact as Class type data
	 * @return Integer value.
	 */
	private int findContact(Contact contact) {
		return this.addressBook.indexOf(contact);
	}

	/**
	 * Overloaded method of findContact takes firstName as input parameter it
	 * matches with all the contact present in the list. if matches it returns the
	 * index value of the contact which is greater than equals to zero.
	 * 
	 * @param firstName as input parameter to check
	 * @return integer value
	 */
	private int findContact(String firstName) {
		for (int i = 0; i < addressBook.size(); i++) {
			Contact fetchedContact = this.addressBook.get(i);
			if (fetchedContact.getFirstName().equals(firstName)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * This method takes oldContact and newContact as class type input parameter
	 * checks for position. if position found then it replace new contact details in
	 * the place of old contact after successfully update returns boolean value.
	 * 
	 * @param oldContact as class type input parameter
	 * @param newContact as class type input parameter
	 * @return boolean value
	 */
	public boolean updateContact(Contact oldContact, Contact newContact) {
		int foundPosition = findContact(oldContact);
		if (foundPosition < 0) {
			System.out.println(oldContact.toString() + " was not found!");
		}
		this.addressBook.set(foundPosition, newContact);
		System.out.println(oldContact.getFirstName() + " updated successfully. ");
		return true;
	}

	/**
	 * 
	 * This function checks whether the contact is present or not in the list, if
	 * present then it simply display the full Name of the contact else return null.
	 * 
	 * @param contact class type input parameter
	 * @return String value
	 */
	public String searchContact(Contact contact) {
		if (findContact(contact) >= 0) {
			return contact.toString();
		}
		return null;
	}

	/**
	 * This function takes FirstName as input parameter and checks the index
	 * position of the contact. if found then it returns whole contact class type
	 * value else return null value.
	 * 
	 * @param firstName as String input parameter
	 * @return Contact class type
	 */
	public Contact searchContact(String firstName) {
		int position = findContact(firstName);
		if (position >= 0) {
			return this.addressBook.get(position);
		}
		return null;
	}

	/**
	 * This function takes Contact as input parameter and checks whether it is
	 * Present or not, if found then successfully delete the contact else reply with
	 * a message that contact not exist.
	 * 
	 * @param contact as class type input parameter
	 * @return boolean value
	 */
	public boolean deleteContact(Contact contact) {
		int foundPosition = findContact(contact);
		if (foundPosition < 0) {
			System.out.println(contact.toString() + " was not found!");
			return false;
		}
		this.addressBook.remove(foundPosition);
		System.out.println(contact.toString() + " successfully deleted!");
		return true;
	}

	/**
	 * just prints the complete information of the customer like first name, last
	 * name, address, mail id, mobile number.
	 */
	public void printIndetailContact() {
		System.out.println("contact list :");
		for (int i = 0; i < addressBook.size(); i++) {
			System.out.println((i + 1) + ". First Name -> " + addressBook.get(i).getFirstName() + "\n   Last Name -> "
					+ addressBook.get(i).getLastName() + "\n   Address -> " + addressBook.get(i).getAddress()
					+ "\n   Email id -> " + addressBook.get(i).getEmail() + "\n   mobile no -> "
					+ addressBook.get(i).getPhoneNumber());
		}
	}

	/**
	 * prints the complete name of the customer first name and last name.
	 */
	public void printFullName() {
		System.out.println("contact list :");
		for (int i = 0; i < addressBook.size(); i++) {
			System.out.println((i + 1) + " . " + addressBook.get(i).toString());
		}
	}

}
