package com.bridgeLabz.objectOrientedPrograms.cl;

import com.bridgeLabz.objectOrientedPrograms.cl.Operation.CliniqueOperation;
import com.bridgeLabz.objectOrientedPrograms.cl.service.ICliniqueService;
import com.bridgeLabz.utility.Util;

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

			default:
				System.out.println("please read instrutions!");
			}
		}

	}

	public static void printInstructions() {
		System.out.println("Available actions :\npress :");
		System.out.println("\t1 -> add doctor to list. \n" + "\t2 -> Book Appointment.\n"
				+ "\t3 -> Search patient details\n" + "\t4 -> print instructions.\n" + "\t5 -> Quit the application\n");
		System.out.println("choose your action :");
	}

	public static void searchDoctorAndBookAppointment() {
		System.out.println("press to search by : 1 -> name, 2 -> id, 3 -> specialization, 4 -> availability ");
		System.out.println("please Enter your choice");
		int choice = Util.scanner.nextInt();
		switch (choice) {
		case 1:
			// search by name
			System.out.println("Please Enter Doctor name :");
			String docName = Util.scanner.next();
			Util.scanner.nextLine();
			service.readDoctorDetails("name", docName);
			break;

		case 2:
			System.out.println("Please Enter Doctor id :");
			String docId = Util.scanner.nextLine();
			Util.scanner.nextLine();
			service.readDoctorDetails("id", docId);
			// search by id
			break;

		case 3:
			System.out.println("Please Enter Doctor specialization :");
			String docSpecialization = Util.scanner.next();
			Util.scanner.nextLine();
			service.readDoctorDetails("specialization", docSpecialization);
			// search by specialization
			break;

		case 4:
			System.out.println("Please Enter Doctor availability time am/pm/both :");
			String docAvailability = Util.scanner.next();
			Util.scanner.nextLine();
			service.readDoctorDetails("availability", docAvailability);
			// search by availability
			break;

		default:
			System.out.println("Please follow instructions...");
			break;
		}
	}

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
			service.readDoctorDetails("mobile", mobile);
			// search by mobile number
			break;

		default:
			System.out.println("Please follow instructions...");
			break;
		}

	}

}
