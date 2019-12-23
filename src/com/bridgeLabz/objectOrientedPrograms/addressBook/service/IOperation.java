package com.bridgeLabz.objectOrientedPrograms.addressBook.service;

import com.bridgeLabz.objectOrientedPrograms.addressBook.model.Contact;

/**
 * This interface has some unimplemented methods.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-12
 * @version 11.0.5
 */
public interface IOperation {

	/**
	 * Add a new Contact.
	 * 
	 * @param contact class type as input parameter.
	 * @return boolean value.
	 */
	boolean addNewContact(Contact contact);

	/**
	 * Update an existing contact.
	 * 
	 * @param oldContact as class type input parameter
	 * @param newContact as class type input parameter
	 * @return boolean value
	 */
	boolean updateContact(Contact oldContact, Contact newContact);

	/**
	 * delete an existing Contact.
	 * 
	 * @param contact as class type input parameter
	 * @return boolean value
	 */
	boolean deleteContact(Contact contact);

	/**
	 * Print inDetail contact.
	 */
	void printIndetailContact();

	/**
	 * prints only the full name of all contacts.
	 */
	void printFullName();

	/**
	 * Search a contact.
	 * 
	 * @param firstName as String input parameter
	 * @return Contact class type
	 */
	Contact searchContact(String firstName);

	/**
	 * Search Contact and returns firstName.
	 * 
	 * @param contact class type input parameter
	 * @return String value
	 */
	String searchContact(Contact contact);

	/**
	 * writes all data of address book to JSON file and returns the string
	 * 
	 * @return String values of JSON
	 */
	String writeDataToJson();

}