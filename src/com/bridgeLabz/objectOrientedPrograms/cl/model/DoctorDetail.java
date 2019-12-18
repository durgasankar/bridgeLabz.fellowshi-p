package com.bridgeLabz.objectOrientedPrograms.cl.model;

public class DoctorDetail {

	private String name;
	private String id;
	private String specialization;
	private String availability;
	private long patientCount;

	public DoctorDetail() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public long getPatientCount() {
		return patientCount;
	}

	public void setPatientCount(long patientCount) {
		this.patientCount = patientCount;
	}

}
