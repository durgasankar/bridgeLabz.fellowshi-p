package com.bridgeLabz.objectOrientedPrograms.cliniqueManagement;

import com.bridgeLabz.objectOrientedPrograms.cliniqueManagement.Operation.CliniqueOperation;
import com.bridgeLabz.objectOrientedPrograms.cliniqueManagement.service.ICliniqueService;
import com.bridgeLabz.utility.Util;

/**
 * Implementation of the Clinic management System.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-19
 * @version 1.8
 */
public class Implementation {
	private static ICliniqueService service = new CliniqueOperation();

	public static void main(String[] args) {

		System.out.println("Welcome to r20jc134 hospital\n-----------------------------");
		printInstructions();
		boolean isQuit = false;
		while (!isQuit) {
			System.out.println("\nEnter action : (press : 4 -> show available actions)");
			int action = Util.scanner.nextInt();
			switch (action) {

			case 1:
				service.addDoctor();
				// add doctor
				break;

			case 2:
				searchDoctorAndBookAppointment();
				// search available doctors and book appointment
				break;

			case 3:
				searchPatientDetails();
				// search patient details
				break;

			case 4:
				printInstructions();
				// print instructions
				break;

			case 5:
				System.out.println("Thank you visit again...");
				isQuit = true;
				// quit application
				break;

			case 6:
				service.printDoctorList();
				// print all doctor list
				break;

			case 7:
				service.printPatientList();
				// print all patient list
				break;

			default:
				System.out.println("please read instrutions!");
			}
		}

	}

	/**
	 * Instructors displayed to the user to use the application.
	 */
	public static void printInstructions() {
		System.out.println("Available actions :\npress :");
		System.out.println("\t1 -> add doctor to list. \n" + "\t2 -> Book Appointment.\n"
				+ "\t3 -> Search patient details\n" + "\t4 -> print instructions.\n" + "\t5 -> Quit the application\n"
				+ "\t6 -> print doctor List associated with hospital\n"
				+ "\t7 -> print patient List associated with hospital\n");
		System.out.println("choose your action :");
	}

	/**
	 * This function allows the user to search doctor on the basis of name, id,
	 * specialization,availability. if found then proceed with appointment
	 * procedure.
	 */
	public static void searchDoctorAndBookAppointment() {
		System.out.println("press to search by : 1 -> name, 2 -> id");
		System.out.println("please Enter your choice");
		int choice = Util.scanner.nextInt();
		switch (choice) {
		case 1:
			// search by name
			System.out.println("Please Enter Doctor name :");
			String docName = Util.scanner.next();
			Util.scanner.nextLine();
			service.searchDoctorBookAppointment("name", docName);
			break;

		case 2:
			System.out.println("Please Enter Doctor id :");
			String docId = Util.scanner.nextLine();
			Util.scanner.nextLine();
			service.searchDoctorBookAppointment("id", docId);
			// search by id
			break;

//		case 3:
//			System.out.println("Please Enter Doctor specialization :");
//			String docSpecialization = Util.scanner.next();
//			Util.scanner.nextLine();
//			service.searchDoctorBookAppointment("specialization", docSpecialization);
//			// search by specialization
//			break;
//
//		case 4:
//			System.out.println("Please Enter Doctor availability time am/PM/both :");
//			String docAvailability = Util.scanner.next();
//			Util.scanner.nextLine();
//			service.searchDoctorBookAppointment("availability", docAvailability);
//			// search by availability
//			break;
//
		default:
			System.out.println("Please follow instructions...");
			break;
		}
	}

	/**
	 * This function allows the user to search patients on the basis of name, id,
	 * phone number if found then display all information of that patient.
	 */
	public static void searchPatientDetails() {
		System.out.println("press to search by : 1 -> name, 2 -> id, 3 -> mobileNumber ");
		System.out.println("please Enter your choice");
		int choice = Util.scanner.nextInt();
		switch (choice) {
		case 1:
			// search by name
			System.out.println("Please Enter Patient name :");
			String patName = Util.scanner.next();
			Util.scanner.nextLine();
			service.readPatientDetails("name", patName);
			break;

		case 2:
			System.out.println("Please Enter patient id :");
			String patId = Util.scanner.nextLine();
			Util.scanner.nextLine();
			service.readPatientDetails("id", patId);
			// search by id
			break;

		case 3:
			System.out.println("Please Enter patient mobile Number :");
			String mobile = Util.scanner.next();
			Util.scanner.nextLine();
			service.searchDoctorBookAppointment("mobile", mobile);
			// search by mobile number
			break;

		default:
			System.out.println("Please follow instructions...");
			break;
		}

	}

}
