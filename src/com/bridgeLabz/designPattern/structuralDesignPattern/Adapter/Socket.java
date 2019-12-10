package com.bridgeLabz.designPattern.structuralDesignPattern.Adapter;

/**
 * Socket class has one method which returns new Object of Volt class.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-10
 * @version 11.0.5
 */
public class Socket {
	/**
	 * This function returns new Object of Volt class type whenever is called.
	 * 
	 * @return new Object of Volt class
	 */
	public Volt getVolt() {
		return new Volt(120);
	}

}
