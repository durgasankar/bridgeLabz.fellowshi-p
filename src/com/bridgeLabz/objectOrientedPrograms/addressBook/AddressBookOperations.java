package com.bridgeLabz.objectOrientedPrograms.addressBook;

import java.util.ArrayList;
import com.bridgeLabz.utility.UtilJson;

/**
 * This class Implements IOperation interface and Overrides all unimplemented
 * functions and defines functionalities like add new contact, update existing
 * contact search the contact on basis of name , search the contact on basis of
 * contact object remove the contact and find the contact from the list on the
 * basis of first name and print the inDetail contact and also print on the
 * basis of first name and last name . and writes all value to JSON file.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-01
 * @modified 2019-12-12
 * @updated -> addition of Interface and addition of JSON file writing method.
 * @version 11.0.5
 */
public class AddressBookOperations implements IOperation {
	protected static ArrayList<Contact> addressBook;

	/**
	 * Constructor to initialize arrayList
	 * 
	 * @param addressBookName as input parameter
	 */
	public AddressBookOperations() {
		addressBook = new ArrayList<Contact>();
	}

	/**
	 * takes Contact class type input parameter and checks whether it is present or
	 * not if not present then add the contact to the list.
	 * 
	 * @param contact class type as input parameter.
	 * @return boolean value.
	 */
	@Override
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
		return addressBook.indexOf(contact);
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
			Contact fetchedContact = addressBook.get(i);
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
	@Override
	public boolean updateContact(Contact oldContact, Contact newContact) {
		int foundPosition = findContact(oldContact);
		if (foundPosition < 0) {
			System.out.println(oldContact.toString() + " was not found!");
		}
		addressBook.set(foundPosition, newContact);
		return true;
	}

	/**
	 * 
	 * This function checks whether the contact is present or not in the list, if
	 * present then it simply display the full Name of the contact else return null.
	 * 
	 */
	@Override
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
	 */
	@Override
	public Contact searchContact(String firstName) {
		int position = findContact(firstName);
		if (position >= 0) {
			return addressBook.get(position);
		}
		return null;
	}

	/**
	 * This function takes Contact as input parameter and checks whether it is
	 * Present or not, if found then successfully delete the contact else reply with
	 * a message that contact not exist.
	 * 
	 */
	@Override
	public boolean deleteContact(Contact contact) {
		int foundPosition = findContact(contact);
		if (foundPosition < 0) {
			System.out.println(contact.toString() + " was not found!");
			return false;
		}
		addressBook.remove(foundPosition);
		System.out.println(contact.toString() + " successfully deleted!");
		return true;
	}

	/**
	 * just prints the complete information of the customer like first name, last
	 * name, address, mail id, mobile number.
	 */
	@Override
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
	@Override
	public void printFullName() {
		System.out.println("contact list :");
		for (int i = 0; i < addressBook.size(); i++) {
			System.out.println((i + 1) + " . " + addressBook.get(i).toString());
		}
	}

	/**
	 * writes all data of address book to JSON file and returns the string
	 * 
	 * @return String values of JSON
	 */
	@Override
	public String writeDataToJson() {
		String addressBookJson = UtilJson.convertObjectToJson(addressBook);
		return addressBookJson;
	}

}
