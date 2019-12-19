package com.bridgeLabz.objectOrientedPrograms.cl.Operation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.bridgeLabz.objectOrientedPrograms.cl.model.DoctorDetail;
import com.bridgeLabz.objectOrientedPrograms.cl.model.PatientDetail;
import com.bridgeLabz.objectOrientedPrograms.cl.service.ICliniqueService;
import com.bridgeLabz.utility.Util;
import com.bridgeLabz.utility.UtilJson;

public class CliniqueOperation implements ICliniqueService {
	private static final String PATH_DOCTOR = "doctor.json";
	private static final String PATH_PATIENT = "patient.json";
	private static final String PATH_APPOINTMENT = "appointment.json";
	private static JSONArray globalJsonArray = new JSONArray();
	private static Random random = new Random();

	@SuppressWarnings("unchecked")
	@Override

	public void addDoctor() {
		JSONObject doctorJsonObject = new JSONObject();
		// reading old data from file.
		if (UtilJson.readJSONArray(PATH_DOCTOR) != null) {
			globalJsonArray = UtilJson.readJSONArray(PATH_DOCTOR);
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
		doctorJsonObject.put("name", newDoctor.getName());
		doctorJsonObject.put("id", newDoctor.getId());
		doctorJsonObject.put("specialization", newDoctor.getSpecialization());
		doctorJsonObject.put("availability", newDoctor.getAvailability());
		doctorJsonObject.put("patientCount", newDoctor.getPatientCount());
		// adding object to json array
		if (globalJsonArray.add(doctorJsonObject)) {
			// writing array data to json file
			UtilJson.writeDataToJSONArray(PATH_DOCTOR, globalJsonArray);
			System.out.println("Dr." + newDoctor.getName() + "  Hospital Id : " + newDoctor.getId()
					+ " resistered successfully.\n");
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
	@Override
	public void addPatient(String patientId, String doctorId) {
		// reading old data from file.
		JSONArray jsonArray = new JSONArray();
		JSONObject patientJsonObject = new JSONObject();
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
		patientJsonObject.put("name", newPatient.getName());
		patientJsonObject.put("id", newPatient.getId());
		patientJsonObject.put("mobile", newPatient.getMobileNumber());
		patientJsonObject.put("age", newPatient.getAge());
		// adding doctor id
		patientJsonObject.put("doctorId", doctorId);

		// adding the object to jsonArray
		if (jsonArray.add(patientJsonObject)) {
			// writing array data to json file
			UtilJson.writeDataToJSONArray(PATH_PATIENT, jsonArray);
			System.out.println("patient " + newPatient.getId() + " resistered successfully.\n");
		} else {
			System.out.println("error adding patient.");
		}

	}

	@SuppressWarnings({ "unchecked" })
	private void bookAppointment(JSONObject doctorObject) {
		// read data from appointment path
		JSONArray jsonArray = null;
		if (UtilJson.readJSONArray(PATH_APPOINTMENT) != null) {
			jsonArray = UtilJson.readJSONArray(PATH_APPOINTMENT);
		} else {
			jsonArray = new JSONArray();
		}
		String patientId = "";
		String doctorId = (String) doctorObject.get("id");
		long patientCount = (long) doctorObject.get("patientCount");
		// date set up
		LocalDate today = LocalDate.now();
		LocalDate tomorrow = today.plusDays(1);
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String tomorrowDate = tomorrow.format(format);
		String todayDate = today.format(format);
		// if patient count increases above 5 of a single doctor
		if (patientCount >= 5) {
			System.out.println("Doctor's chamber is full. Do you want to shift to tomorrow...[y/n]");
			String response = Util.scanner.nextLine().toLowerCase().trim();
			if (response.equals("y")) {

				JSONObject jsonObject = new JSONObject();
				patientId = patientIdGnerator();
				addPatient(patientId, doctorId);
				jsonObject.put("doctorId", doctorId);
				jsonObject.put("patientId", patientId);
				jsonObject.put("appointmentDate", tomorrowDate);
				jsonArray.add(jsonObject);
				System.out.println("Appointment of patient id : " + patientId + " sheduled for " + tomorrowDate
						+ " with Dr." + doctorObject.get("name"));
				UtilJson.writeDataToJSONArray(PATH_APPOINTMENT, jsonArray);

			}
			// patient count less than 5 of single doc
		} else {
			JSONObject jsonObject = new JSONObject();
			patientId = patientIdGnerator();
			addPatient(patientId, doctorId);
			doctorObject.put("patientCount", patientCount + 1);
			updateDoctor(doctorObject);
			// writing data to json appointment
			jsonObject.put("doctorId", doctorId);
			jsonObject.put("patientId", patientId);
			jsonObject.put("appointmentDate", todayDate);
			jsonArray.add(jsonObject);
			System.out.println("Appointment of patient id : " + patientId + " fixed today.");
			UtilJson.writeDataToJSONArray(PATH_APPOINTMENT, jsonArray);
		}

	}

	@SuppressWarnings("rawtypes")
	@Override
	public void readPatientDetails(String key, String value) {
		// reading old data from file.
		if (UtilJson.readJSONArray(PATH_PATIENT) == null) {
			System.out.println("Empty list.. plz add patient.");
			return;
		}
		globalJsonArray = UtilJson.readJSONArray(PATH_PATIENT);
		Iterator iterator = globalJsonArray.iterator();
		// displaying all records of searched patient.
		JSONObject patientObject;
		while (iterator.hasNext()) {
			if ((patientObject = (JSONObject) iterator.next()).get(key).equals(value)) {
				System.out.println("patient details :\n------------------");
				System.out.println("id : " + patientObject.get("id") + "\t");
				System.out.println("name : " + patientObject.get("name") + "\t");
				System.out.println("mobile : " + patientObject.get("mobile") + "\t");
				System.out.println("age : " + patientObject.get("age") + "\t");
			}
		}

	}

	@SuppressWarnings("unchecked")
	private void updateDoctor(JSONObject currentDoctorObject) {
		globalJsonArray = UtilJson.readJSONArray(PATH_DOCTOR);

		JSONArray updatedArray = new JSONArray();
		@SuppressWarnings("rawtypes")
		Iterator iterator = globalJsonArray.iterator();

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

	@SuppressWarnings("rawtypes")
	@Override
	public void readDoctorDetails(String key, String value) {
		// reading old data from file.
		JSONArray readOldFile = UtilJson.readJSONArray(PATH_DOCTOR);
		if (readOldFile == null) {
			System.out.println("Empty list.. plz add doctor.");
			return;
		}
		globalJsonArray = UtilJson.readJSONArray(PATH_DOCTOR);
		Iterator iterator = globalJsonArray.iterator();
		JSONObject currentDoctorObject = null;
		JSONObject previousDoctorObject = null;
		int doctorCount = 1;

		while (iterator.hasNext()) {

			if ((currentDoctorObject = (JSONObject) iterator.next()).get(key).equals(value)) {
				previousDoctorObject = currentDoctorObject;
				System.out.println("\nDoctor No : " + doctorCount++ + "\n--------------");
				System.out.println("id : " + currentDoctorObject.get("id") + "\t");
				System.out.println("name :" + currentDoctorObject.get("name") + "\t");
				System.out.println("specialization : " + currentDoctorObject.get("specialization") + "\t");
				System.out.println("availability : " + currentDoctorObject.get("availability") + "\t");
				System.out.println("patientCount : " + currentDoctorObject.get("patientCount") + "\t");

				System.out.println("Do you want to take appointment : [y/n]");
				String appointmentChoice = Util.scanner.next().trim();
				Util.scanner.nextLine();
				if (appointmentChoice.equalsIgnoreCase("y")) {
					bookAppointment(previousDoctorObject);
				} else {
					System.out.println("Not a problem...");
					return;
				}
			}
		}
	}

	private static void printPatientList() {
		JSONArray readOldFileArray = UtilJson.readJSONArray(PATH_PATIENT);
		if (readOldFileArray == null) {
			System.out.println("Empty list.. plz add doctor.");
			return;
		}
		Iterator iterator = readOldFileArray.iterator();
		JSONObject jsonObject;
		int count = 1;
		System.out.println("All patients resisted with hospital :\n------------------------------------");
		while (iterator.hasNext()) {
			jsonObject = (JSONObject) iterator.next();
			System.out.println("patient No : " + count++ + "\n---------------");
			System.out.println("id\t: " + jsonObject.get("id"));
			System.out.println("name\t: " + jsonObject.get("name"));
			System.out.println("mobile\t: " + jsonObject.get("mobile"));
			System.out.println("age\t: " + jsonObject.get("age"));
			System.out.println("doctor\t: " + jsonObject.get("doctorId"));
			System.out.println();
		}

	}
	
//
//	public static void main(String[] args) {
//		printPatientList();
//	}
}
