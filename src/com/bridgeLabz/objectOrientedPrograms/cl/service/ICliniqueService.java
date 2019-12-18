package com.bridgeLabz.objectOrientedPrograms.cl.service;

public interface ICliniqueService {

	void addDoctor();

	void addPatient(String patientId, String doctorId);

	void readPatientDetails(String key, String value);

	void readDoctorDetails(String key, String value);

}