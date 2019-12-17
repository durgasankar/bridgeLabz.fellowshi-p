package com.bridgeLabz.objectOrientedPrograms.cliniqueManagement.Implementation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.bridgeLabz.objectOrientedPrograms.cliniqueManagement.doctor.DoctorDetail;
import com.bridgeLabz.objectOrientedPrograms.cliniqueManagement.patient.PatientDetail;
import com.bridgeLabz.utility.Util;
import com.bridgeLabz.utility.UtilJson;

public class Implementation {
	private static final String PATH_DOCTOR = "doctor.json";
	private static final String PATH_PATIENT = "patient.json";
	private static final String PATH_APPOINTMENT = "appointment.json";
	private static JSONArray jsonArray = new JSONArray();
	private static JSONObject jsonObject = new JSONObject();
	private static Random random = new Random();

	@SuppressWarnings("unchecked")
	public static void addDoctor() {
		// reading old data from file.
		if (UtilJson.readJSONArray(PATH_DOCTOR) != null) {
			jsonArray = UtilJson.readJSONArray(PATH_DOCTOR);
		}

		DoctorDetail newDoctor = new DoctorDetail();

		System.out.println("Enter Doctor information :\n");
		// name
		System.out.println("Enter Doctor name :");
		String name = Util.scanner.next();
		newDoctor.setName(name);
		Util.scanner.nextLine();
		// id
		String id = doctorIdGnerator();
		newDoctor.setId(id);
		// specialization
		System.out.println("Enter Doctor specialization :");
		String specialization = Util.scanner.next();
		newDoctor.setSpecialization(specialization);
		// availability
		System.out.println("Availablity : press 1 -> am, 2 -> pm, 3 -> both :");
		int choice = Util.scanner.nextInt();
		String availabile = docAvailability(choice);
		newDoctor.setAvailability(availabile);
		// patient count
		newDoctor.setPatientCount(0);

		// adding json object
		jsonObject.put("name", newDoctor.getName());
		jsonObject.put("id", newDoctor.getId());
		jsonObject.put("specialization", newDoctor.getSpecialization());
		jsonObject.put("availability", newDoctor.getAvailability());
		jsonObject.put("patient count", newDoctor.getPatientCount());
		// adding object to json array
		if (jsonArray.add(jsonObject)) {
			// writing array data to json file
			UtilJson.writeDataToJSONArray(PATH_DOCTOR, jsonArray);
			System.out.println("patient " + newDoctor.getId() + " resistered successfully.\n");
		} else {
			System.out.println("Error adding " + newDoctor.getId() + " to file");
		}

	}

	/**
	 * takes integer value as input and returns String data.
	 * 
	 * @param inputData as Integer input parameter
	 * @return String value.
	 */
	private static String docAvailability(int inputData) {
		if (inputData == 1)
			return "am";
		else if (inputData == 2)
			return "pm";
		else if (inputData == 3)
			return "both";
		return "both";

	}

	/**
	 * This function generate random id for patient.
	 * 
	 * @return String data
	 */
	private static String patientIdGnerator() {
		String inputId = "#Pa";
		inputId += random.nextInt(10000);
		return inputId;
	}

	/**
	 * This function generate random id for doctor
	 * 
	 * @return String data
	 */
	private static String doctorIdGnerator() {
		String inputId = "#Dr";
		inputId += random.nextInt(100);
		return inputId;
	}

	@SuppressWarnings("unchecked")
	public static void addPatient(String patientId, String doctorId) {
		// reading old data from file.
		if (UtilJson.readJSONArray(PATH_PATIENT) != null) {
			jsonArray = UtilJson.readJSONArray(PATH_PATIENT);
		}

		PatientDetail newPatient = new PatientDetail();

		System.out.println("Enter Doctor information :\n");
		// name
		System.out.println("Enter Patient name :");
		String patientName = Util.scanner.next();
		newPatient.setName(patientName);
		Util.scanner.nextLine();
		// id
		patientId = patientIdGnerator();
		newPatient.setId(patientId);
		// mobile
		System.out.println("Please enter mobile Number :");
		long number = Util.scanner.nextLong();
		newPatient.setMobileNumber(number);
		// age
		System.out.println("Enter patient age :");
		int age = Util.scanner.nextInt();
		newPatient.setAge(age);
		// adding data to json object
		jsonObject.put("name", newPatient.getName());
		jsonObject.put("id", newPatient.getId());
		jsonObject.put("mobile", newPatient.getMobileNumber());
		jsonObject.put("age", newPatient.getAge());
		// adding doctor id
		jsonObject.put("doctor id", doctorId);

		// adding the object to jsonArray
		if (jsonArray.add(jsonObject)) {
			System.out.println("patient " + newPatient.getId() + " resistered successfully.\n");
		} else {
			System.out.println("error adding patient.");
		}
		// writing array data to json file
		UtilJson.writeDataToJSONArray(PATH_PATIENT, jsonArray);

	}

	@SuppressWarnings({ "unchecked", "unused" })
	private void bookAppointment(JSONObject doctorObject) {
		String patientId = "";
		String doctorId = (String) doctorObject.get("id");
		int patientCount = (int) doctorObject.get("patientCount");
		if (patientCount >= 5) {
			System.out.println("Doctor is busy take appointment tomorrow...");
			String tomorrowDate = LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-mm-dd"));
			String response = Util.scanner.nextLine().toLowerCase().trim();
			if (response.equals("y")) {
				int count = 0;
				JSONArray jsonArray = UtilJson.readJSONArray(PATH_APPOINTMENT);
				JSONObject jsonObject = new JSONObject();
				patientId = patientIdGnerator();
				jsonObject.put("doctorId", doctorId);
				jsonObject.put("patientId", patientId);
				jsonObject.put("appointment date", tomorrowDate);

				if (jsonArray.add(jsonObject)) {
					System.out.println("Appointment of patient id : " + patientId + " sheduled for " + tomorrowDate);
					UtilJson.writeDataToJSONArray(PATH_APPOINTMENT, jsonArray);
					// controller main menu
				} else {
					System.out.println("Opps... appointment sheduling failed.\n");
				}
			}

		} else {
			patientId = patientIdGnerator();
			addPatient(patientId, doctorId);
			doctorObject.put("patient count", patientCount + 1);
			updateDoctor(doctorObject);
			System.out.println("Appointment of patient id : " + patientId + "fixed today.");

			// controller main menu

		}

	}

	public void readPatientDetails(String key, String value) {
		// reading old data from file.
		if (UtilJson.readJSONArray(PATH_PATIENT) != null) {
			jsonArray = UtilJson.readJSONArray(PATH_PATIENT);
			@SuppressWarnings("rawtypes")
			Iterator iterator = jsonArray.iterator();
			@SuppressWarnings("unused")
			JSONObject patientObject;
			while (iterator.hasNext()) {
				if ((patientObject = (JSONObject) iterator.next()).containsKey(value)) {
					System.out.println("\n patient details :");
					System.out.println("id : " + jsonObject.get("id") + "\t");
					System.out.println("name : " + jsonObject.get("name") + "\t");
					System.out.println("mobile : " + jsonObject.get("mobile") + "\t");
					System.out.println("age : " + jsonObject.get("age") + "\t");
				}
			}
//			Clinique.menu
		}
		System.out.println("Empty list.. plz add patient.");
	}

	@SuppressWarnings("unchecked")
	private void updateDoctor(JSONObject currentDoctorObject) {
		jsonArray = UtilJson.readJSONArray(PATH_DOCTOR);

		JSONArray updatedArray = new JSONArray();
		@SuppressWarnings("rawtypes")
		Iterator iterator = jsonArray.iterator();

		while (iterator.hasNext()) {
			JSONObject nextDoctorObject = (JSONObject) iterator.next();
			if (nextDoctorObject.get("id").equals(currentDoctorObject.get("id"))) {
				updatedArray.add(currentDoctorObject);
			} else {
				updatedArray.add(nextDoctorObject);
			}
		}
		UtilJson.writeDataToJSONArray(PATH_DOCTOR, updatedArray);
	}

	public void readDoctorDetails(String key, String value) {
		// reading old data from file.
		if (UtilJson.readJSONArray(PATH_DOCTOR) != null) {
			jsonArray = UtilJson.readJSONArray(PATH_DOCTOR);
			@SuppressWarnings("rawtypes")
			Iterator iterator = jsonArray.iterator();
			@SuppressWarnings("unused")
			JSONObject patientObject;
			while (iterator.hasNext()) {
				if ((patientObject = (JSONObject) iterator.next()).containsKey(value)) {
					System.out.println("\n patient details :");
					System.out.println("id : " + jsonObject.get("id") + "\t");
					System.out.println("specialization : " + jsonObject.get("specialization") + "\t");
					System.out.println("availability : " + jsonObject.get("availability") + "\t");
					System.out.println("patientCount : " + jsonObject.get("patientCount") + "\t");
				}
			}
//			Clinique.menu
		}
		System.out.println("Empty list.. plz add doctor.");
	}

	public static void main(String[] args) {

//		Implementation.addPatient();
		Implementation.addDoctor();
//		Implementation.addDoctor();
//		readPatientDetails();
	}

}
