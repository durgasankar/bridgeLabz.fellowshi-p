package com.bridgeLabz.designPattern.structuralDesignPattern.adapter;

/**
 * This class Implements SocketAdapter Interface which has 3 undefined methods
 * for implementation. access SocketClass by creating object.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-10
 * @version 11.0.5
 */
public class SocketObjectAdapter implements SocketAdapter {

	private Socket socket = new Socket();

	/**
	 * Default 120 volt as input Volt.
	 */
	@Override
	public Volt get120Volt() {

		return socket.getVolt();
	}

	/**
	 * returns 12 Volt after applying convertVolt method
	 */
	@Override
	public Volt get12Volt() {
		Volt volt = socket.getVolt();
		return convertVolt(volt, 10);
	}

	/**
	 * returns 3 Volt after applying convertVolt method
	 */
	@Override
	public Volt get3Volt() {
		Volt volt = socket.getVolt();
		return convertVolt(volt, 40);
	}

	/**
	 * returns volt after converting to required value.
	 * 
	 * @param volt Class type as Input parameter
	 * @param i    as Integer value
	 * @return new Object of Volt class type.
	 */
	private Volt convertVolt(Volt volt, int i) {
		return new Volt(volt.getVolts() / i);
	}

}
