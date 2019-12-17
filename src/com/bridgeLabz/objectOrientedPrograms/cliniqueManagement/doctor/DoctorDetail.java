package com.bridgeLabz.objectOrientedPrograms.cliniqueManagement.doctor;

public class DoctorDetail {

	private String name;
	private int id;
	private String specialization;
	private String availability;

	public DoctorDetail(String anme, int id, String specialization, String availability) {
		this.name = anme;
		this.id = id;
		this.specialization = specialization;
		this.availability = availability;
	}

	public DoctorDetail() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
	
	public static DoctorDetail addDoctor(String name, int id, String specialization, String availability) {
		return new DoctorDetail(name, id, specialization, availability);
	}

}
