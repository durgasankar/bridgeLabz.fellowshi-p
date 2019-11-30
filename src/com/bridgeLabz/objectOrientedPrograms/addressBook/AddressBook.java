package com.bridgeLabz.objectOrientedPrograms.addressBook;

import com.bridgeLabz.utility.Util;

public class AddressBook {
	private static AddressBookOperations myAddressBook = new AddressBookOperations("admin");

	private static void printInstructions() {
		System.out.println("Available actions :\npress");
		System.out.println("1 -> quit the application\n" + "2 -> add a new contact\n"
				+ "3 -> update an existing contact\n" + "4 -> remove an existing contact\n"
				+ "5 -> search a contact from the book\n" + "6 -> print indetail address book\n"
				+ "7 -> print contact full name only\n" + "8 -> print instructions");
		System.out.println("choose your action :");
	}

	private static void addNewContact() {
		System.out.println("Enter new Contact First Name :");
		String firstName = Util.scanner.nextLine();
		System.out.println("Enter Last Name :");
		String lastName = Util.scanner.nextLine();
		System.out.println("Enter Email id :");
		String email = Util.scanner.nextLine();
		System.out.println("Enter address :");
		String address = Util.scanner.nextLine();
		System.out.println("Enter phone Number :");
		Long phoneNumber = Util.scanner.nextLong();

		Contact newContact = Contact.createContact(firstName, lastName, email, address, phoneNumber);
		if (myAddressBook.addNewContact(newContact)) {
			System.out.println("New contact with name " + firstName + " added successfully.");
		} else {
			System.out.println("cannot add " + firstName + " already on file.");
		}
	}

	private static void updateContact() {
		System.out.println("Enter existing contact first Name :");
		String existingContactFirstName = Util.scanner.nextLine();
		Contact existingContactRecord = myAddressBook.searchContact(existingContactFirstName);
		if (existingContactRecord == null) {
			System.out.println("Contact not found!");
			return;
		}
		String firstName = existingContactRecord.getFirstName();
		String lastName = existingContactRecord.getLastName();
		System.out.println("Enter Email id :");
		String email = Util.scanner.nextLine();
		System.out.println("Enter address :");
		String address = Util.scanner.nextLine();
		System.out.println("Enter phone Number :");
		Long phoneNumber = Util.scanner.nextLong();
		Contact newContact = Contact.createContact(firstName, lastName, email, address, phoneNumber);
		if (myAddressBook.updateContact(existingContactRecord, newContact)) {
			System.out.println("record updated succesfully.");
		} else {
			System.out.println("Error updating record!");
		}

	}

	private static void deleteContact() {
		System.out.println("Enter first Name of contact you want to delete :");
		String existingContactFirstName = Util.scanner.nextLine();
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

	private static void searchIndetailContact() {
		System.out.println("Enter first Name of contact you want search :");
		String contactFirstName = Util.scanner.nextLine();
		Contact existingContactRecord = myAddressBook.searchContact(contactFirstName);
		if (existingContactRecord == null) {
			System.out.println("Contact not found!");
			return;
		}
		System.out.println("First Name -> " + existingContactRecord.getFirstName() + "\n  Last Name -> "
				+ existingContactRecord.getLastName() + "\n  Address -> " + existingContactRecord.getAddress()
				+ "\n  Email id -> " + existingContactRecord.getEmail() + "\n  mobile no -> "
				+ existingContactRecord.getPhoneNumber());
	}

	public static void main(String[] args) {
		printInstructions();
		boolean quit = false;
		while (!quit) {
			System.out.println("\nEnter action : (8 -> show available actions)");
			int action = Util.scanner.nextInt();
			switch (action) {
			case 1:
				quit = true;
				break;

			case 2:
				addNewContact();
				break;

			case 3:
				updateContact();
				break;

			case 4:
				deleteContact();
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
				printInstructions();
				break;

			default:
				System.out.println("Please read instructions!");
			}
		}
	}

}
