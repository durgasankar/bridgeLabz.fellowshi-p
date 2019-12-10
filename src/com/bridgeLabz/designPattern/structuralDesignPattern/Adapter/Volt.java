package com.bridgeLabz.designPattern.structuralDesignPattern.Adapter;

/**
 * This class has one integer type variable to set and get volt
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-10
 * @version 11.0.5
 */
public class Volt {
	private int volts;

	/**
	 * Constructor to initialize the class
	 * 
	 * @param volts as Integer type input parameter
	 */
	public Volt(int volts) {
		this.volts = volts;
	}

	/**
	 * Getter method to get Volts.
	 * 
	 * @return Integer value
	 */
	public int getVolts() {
		return volts;
	}

	/**
	 * Setter method to set the data.
	 * 
	 * @param volts as Integer type Input parameter.
	 */
	public void setVolts(int volts) {
		this.volts = volts;
	}

}
