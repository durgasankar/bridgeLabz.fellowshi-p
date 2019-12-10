package com.bridgeLabz.designPattern.structuralDesignPattern.adapter;

/**
 * This class Extends SockClass and Implements SocketAdapter Interface which has
 * 3 undefined methods for implementation.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-10
 * @version 11.0.5
 */
public class SocketClassAdapter extends Socket implements SocketAdapter {
	/**
	 * Default 120 volt as input Volt.
	 */
	@Override
	public Volt get120Volt() {

		return getVolt();
	}

	/**
	 * returns 12 Volt after applying convertVolt method
	 */
	@Override
	public Volt get12Volt() {
		Volt volt = getVolt();
		return convertVolt(volt, 10);
	}

	/**
	 * returns 3 Volt after applying convertVolt method
	 */
	@Override
	public Volt get3Volt() {
		Volt volt = getVolt();
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
