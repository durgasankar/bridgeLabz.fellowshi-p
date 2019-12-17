package com.bridgeLabz.objectOrientedPrograms.cliniqueManagement.patient;

public class PatientDetail {
	private String name;
	private int id;
	private long mobileNumber;
	private int age;

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

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public PatientDetail(String name, int id, long mobileNumber, int age) {
		this.name = name;
		this.id = id;
		this.mobileNumber = mobileNumber;
		this.age = age;
	}

	public PatientDetail() {
		super();
	}

	public static PatientDetail addPatient(String name, int id, long mobileNumber, int age) {
		return new PatientDetail(name, id, mobileNumber, age);
	}

}
