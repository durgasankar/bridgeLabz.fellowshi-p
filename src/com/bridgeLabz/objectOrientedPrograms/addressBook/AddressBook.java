package com.bridgeLabz.objectOrientedPrograms.addressBook;

import com.bridgeLabz.utility.Util;

/**
 * This class is the main implementation of the address book class which bears
 * the functionality of adding a contact updating a contact , deleting a contact
 * from directory, searching a contact on basis of first name, quit application
 * and displaying inDetail information of the contact. This class allow the user
 * to implement above functionality by pressing the keys mentioned in the
 * working directory . After user uses the application all data were written to
 * the JSON file.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-1
 * @modified 2019-12-12
 * @updated -> allows user to update on basis of email, phone number, address.
 * @version 11.0.5
 */
public class AddressBook {
	private static IOperation myAddressBook = new AddressBookOperations();
	private static final String ADDRESSBOOK_NAME = "jsonAddressBook.json";

	private static void printMainInstructions() {
		System.out.println("Available actions :\npress :");
		System.out.println("\t1 -> quit the application.\n" + "\t2 -> add a new contact.\n"
				+ "\t3 -> update an existing contact.\n" + "\t4 -> remove an existing contact.\n"
				+ "\t5 -> search a contact from the book.\n" + "\t6 -> print indetail address book.\n"
				+ "\t7 -> print full name.\n" + "\t8 -> print instructions.");
		System.out.println("choose your action :");
	}

	/**
	 * Allows user to enter their first name , last name, email id , address , phone
	 * number and create a new contact by using contact class static method then add
	 * this contact to the non generic list.after successfully addition of contact a
	 * Confirmation message is shown to the user.
	 */
	private static void addNewContact() {
		System.out.println("Enter First Name :");
		String firstName = Util.scanner.next();
		Util.scanner.nextLine();
		System.out.println("Enter Last Name :");
		String lastName = Util.scanner.next();
		Util.scanner.nextLine();
		System.out.println("Enter Email id :");
		String email = Util.scanner.next();
		Util.scanner.nextLine();
		System.out.println("Enter address :");
		String address = Util.scanner.next();
		Util.scanner.nextLine();
		System.out.println("Enter phone Number :");
		Long phoneNumber = Util.scanner.nextLong();
		Util.scanner.nextLine();

		Contact newContact = Contact.createContact(firstName, lastName, email, address, phoneNumber);
		if (myAddressBook.addNewContact(newContact)) {
			System.out.println("New contact " + firstName + " added successfully.");

		} else {
			System.out.println("cannot add " + firstName + " already on file.");
		}
	}

	/**
	 * Takes first name as user input and and on the basis of user input it search
	 * from the list if the data matches found then it returns the contact and ask
	 * the user to give the details which needed to be updated . after the details
	 * given from the user side it update the old tails with new details and after
	 * successfully update a confirmation message is displayed to the user.
	 */
	private static void updateContact() {
		System.out.println("Enter existing contact first Name :");
		String existingContactFirstName = Util.scanner.next();
		Contact existingContactRecord = myAddressBook.searchContact(existingContactFirstName);
		if (existingContactRecord == null) {
			System.out.println("Contact not found!");
			return;
		}
		String firstName = existingContactRecord.getFirstName();
		String lastName = existingContactRecord.getLastName();
		String email = existingContactRecord.getEmail();
		String address = existingContactRecord.getAddress();
		long phoneNumber = existingContactRecord.getPhoneNumber();
		System.out.println("Enter update action : 1-> email, 2-> address, 3-> phoneNumber, 4-> update all");
		int action = Util.scanner.nextInt();
		switch (action) {

		case 1:
			System.out.println("Enter email id :");
			email = Util.scanner.next();
			// update email
			break;
		case 2:
			System.out.println("Enter address :");
			address = Util.scanner.next();
			// update address
			break;
		case 3:
			System.out.println("Enter Phone Number :");
			phoneNumber = Util.scanner.nextLong();
			// update phone
			break;
		case 4:
			System.out.println("Enter email id :");
			email = Util.scanner.next();
			System.out.println("Enter address :");
			address = Util.scanner.next();
			System.out.println("Enter Phone Number :");
			phoneNumber = Util.scanner.nextLong();
			// update all email, address, phone number
			break;
		}
		Contact newContact = Contact.createContact(firstName, lastName, email, address, phoneNumber);
		if (myAddressBook.updateContact(existingContactRecord, newContact)) {
			System.out.println("Record updated succesfully.");
		} else {
			System.out.println("Error updating record!");
		}

	}

	/**
	 * Takes first name as user input and and on the basis of user input it search
	 * from the list if the data matches found then it successfully delete the
	 * contact and display a confirmation message to the user after successfully
	 * deletion of contact detail.
	 */
	private static void deleteContact() {
		System.out.println("Enter first Name of contact you want to delete :");
		String existingContactFirstName = Util.scanner.next();
		Contact existingContactRecord = myAddressBook.searchContact(existingContactFirstName);
		if (existingContactRecord == null) {
			System.out.println("Contact not found!");
			return;
		}

		if (myAddressBook.deleteContact(existingContactRecord)) {
			System.out.println("Successfully deleted.");
		} else {
			System.out.println("error deleting record!");
		}
	}

	/**
	 * Takes first name as user input and and on the basis of user input it search
	 * from the list if the data matches found then it display inDetail details of
	 * the customer which he want to search for.
	 */
	private static void searchIndetailContact() {
		System.out.println("Enter first Name of contact you want search :");
		String contactFirstName = Util.scanner.next();
		Contact existingContactRecord = myAddressBook.searchContact(contactFirstName);
		if (existingContactRecord == null) {
			System.out.println("Contact not found!");
			return;
		}
		System.out.println("  First Name -> " + existingContactRecord.getFirstName() + "\n  Last Name -> "
				+ existingContactRecord.getLastName() + "\n  Address -> " + existingContactRecord.getAddress()
				+ "\n  Email id -> " + existingContactRecord.getEmail() + "\n  mobile no -> "
				+ existingContactRecord.getPhoneNumber());
	}

	public static void main(String[] args) {
		System.out.println("Welcome to address book.\n----------------------");
		printMainInstructions();
		boolean quit = false;
		while (!quit) {
			System.out.println("\nEnter action : (press : 8 -> show available actions)");
			int action = Util.scanner.nextInt();
			switch (action) {
			case 1:
				quit = true;
				System.out.println("Thank you  for using application");
				break;

			case 2:
				addNewContact();
				Util.writeToFile(myAddressBook.writeDataToJson(), ADDRESSBOOK_NAME);
				break;

			case 3:
				updateContact();
				Util.writeToFile(myAddressBook.writeDataToJson(), ADDRESSBOOK_NAME);
				break;

			case 4:
				deleteContact();
				Util.writeToFile(myAddressBook.writeDataToJson(), ADDRESSBOOK_NAME);
				break;

			case 5:
				searchIndetailContact();
				break;

			case 6:
				myAddressBook.printIndetailContact();
				break;

			case 7:
				myAddressBook.printFullName();
				break;

			case 8:
				printMainInstructions();
				break;

			default:
				System.out.println("Please read instructions!");
			}
		}

	}

}
