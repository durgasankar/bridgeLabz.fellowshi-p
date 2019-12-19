package com.bridgeLabz.objectOrientedPrograms.cliniqueManagement.service;

public interface ICliniqueService {

	void addDoctor();

	void readPatientDetails(String key, String value);

	void readDoctorDetails(String key, String value);

	void printDoctorList();

	void printPatientList();

}