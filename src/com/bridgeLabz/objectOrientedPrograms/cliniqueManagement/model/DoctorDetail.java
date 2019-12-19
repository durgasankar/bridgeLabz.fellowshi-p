package com.bridgeLabz.objectOrientedPrograms.cliniqueManagement.model;

/**
 * This is the Model class of Doctor which bears the functionality of name, id,
 * availability,patientCount and all getter setters of above functionality.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-19
 * @version 1.8
 */
public class DoctorDetail {

	private String name;
	private String id;
	private String specialization;
	private String availability;
	private long patientCount;

	/**
	 * Constructor to initialize the class
	 */
	public DoctorDetail() {
		super();
	}

	/**
	 * Getter method to get name
	 * 
	 * @return String value
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter method to set name
	 * 
	 * @param name as String parameter
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter method to get id
	 * 
	 * @return String value
	 */
	public String getId() {
		return id;
	}

	/**
	 * Setter method to set id
	 * 
	 * @param id as String parameter
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Getter method to get specialization
	 * 
	 * @return String value
	 */
	public String getSpecialization() {
		return specialization;
	}

	/**
	 * Setter method to set specialization
	 * 
	 * @param specialization as String input parameter
	 */
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	/**
	 * Getter method to get availability
	 * 
	 * @return String value
	 */
	public String getAvailability() {
		return availability;
	}

	/**
	 * Setter method to set availability
	 * 
	 * @param availability as String input parameter
	 */
	public void setAvailability(String availability) {
		this.availability = availability;
	}

	/**
	 * Getter method to get patient count
	 * 
	 * @return long value
	 */
	public long getPatientCount() {
		return patientCount;
	}

	/**
	 * Setter method to set the count
	 * 
	 * @param patientCount as long input parameter.
	 */
	public void setPatientCount(long patientCount) {
		this.patientCount = patientCount;
	}

}
