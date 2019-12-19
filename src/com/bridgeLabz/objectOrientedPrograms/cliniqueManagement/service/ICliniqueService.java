package com.bridgeLabz.objectOrientedPrograms.cliniqueManagement.service;

/**
 * This Interface has certain unimplemented functionality.
 * 
 * @author Durgasanakar Mishra
 * @created 219-12-19
 * @version 1.8
 */
public interface ICliniqueService {
	/**
	 * UnImplemented functionality of adding a doctor
	 */
	void addDoctor();

	/**
	 * UnImplemented functionality of reading patient directory and searching
	 * Particular patient.
	 * 
	 * @param key
	 * @param value
	 */
	void readPatientDetails(String key, String value);

	/**
	 * This function has Unimplemented functionality which takes Doctor key and
	 * parameter value as String input parameter and search particular doctor and
	 * book appointment of the searching person
	 * 
	 * @param key   as String input parameter
	 * @param value as String input parameter
	 */
	void searchDoctorBookAppointment(String key, String value);

	/**
	 * Unimplemented functionality of displaying all doctors associated with the
	 * hospital
	 */
	void printDoctorList();

	/**
	 * Unimplemented functionality of displaying all patients associated with the
	 * hospital
	 */
	void printPatientList();

}