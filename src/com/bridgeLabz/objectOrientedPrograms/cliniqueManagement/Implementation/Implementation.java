package com.bridgeLabz.objectOrientedPrograms.cliniqueManagement.Implementation;

import java.util.Random;

import com.bridgeLabz.objectOrientedPrograms.cliniqueManagement.doctor.DoctorDetail;
import com.bridgeLabz.objectOrientedPrograms.cliniqueManagement.patient.PatientDetail;
import com.bridgeLabz.utility.Util;
import com.bridgeLabz.utility.UtilJson;

public class Implementation {
	private static final String PATH_DOCTOR = "doctor.json";
	private static final String PATH_PATIENT = "patient.json";
//	private static DoctorDetail doctor = new DoctorDetail();
//	private static PatientDetail patient = new PatientDetail();
//	private static JSONObject mainJsonObject = new JSONObject();
//	private static ObjectMapper objectMapper = new ObjectMapper();

	public static void addPatient() {
		System.out.println("Enter patient information :");
		System.out.println("Enter patient name :");
		String name = Util.scanner.nextLine();
		int id = generateId();
		System.out.println("Enter patient mobile Number");
		long mobileNumber = Util.scanner.nextLong();
		System.out.println("Enter patient age");
		int age = Util.scanner.nextInt();
		PatientDetail.addPatient(name, id, mobileNumber, age);
		String jsonData = UtilJson.convertObjectToJson(PatientDetail.addPatient(name, id, mobileNumber, age));
		Util.writeToFile(jsonData, PATH_PATIENT);

	}

	public static void addDoctor() {
		System.out.println("Enter Doctor information :\n");
		System.out.println("Enter Doctor name :");
		String name = Util.scanner.next();
		Util.scanner.hasNextLine();
		int id = generateId();
		System.out.println("Enter Doctor specialization :");
		String specialization = Util.scanner.next();
		System.out.println("Enter Doctor's availabilty :");
		String availabile = Util.scanner.next();
		DoctorDetail newDoctor = DoctorDetail.addDoctor(name, id, specialization, availabile);
		String jsonData = UtilJson.convertObjectToJson(newDoctor);
		Util.writeToFile(jsonData, PATH_DOCTOR);

	}

	private static int generateId() {
		Random random = new Random();
		return random.nextInt(1000) + 1;
	}

	public void readDoctorDetail() {
		String doctorFile = Util.readFile(PATH_DOCTOR);
		DoctorDetail doctor = UtilJson.convertJsonToJava(doctorFile, DoctorDetail.class);
		System.out.println("\nDoctor Information:");
		System.out.println("Name: " + doctor.getName() + "\t");
		System.out.println("id: " + doctor.getId() + "\t");
		System.out.println("Specialization: " + doctor.getSpecialization() + "\t");
		System.out.println("Availability: " + doctor.getAvailability() + "\t");
	}

	public static void readPatientDetails() {
		String patientFile = Util.readFile(PATH_PATIENT);
		PatientDetail patient = UtilJson.convertJsonToJava(patientFile, PatientDetail.class);
		System.out.println("\nPatient Information:");
		System.out.println("Name: " + patient.getName() + "\t");
		System.out.println("ID: " + patient.getId() + "\t");
		System.out.println("mobileNumber :" + patient.getMobileNumber() + "\t");
		System.out.println("Age :" + patient.getAge() + "\t");
	}

	public void updatePatient() {

	}

	public static void main(String[] args) {
//		System.out.println(generateId());
//		Implementation.addPatient();
//		Implementation.addDoctor();
		readPatientDetails();
	}

}
