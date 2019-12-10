package com.bridgeLabz.designPattern.structuralDesignPattern.adapter;

/**
 * This class has all the Implementation of SocketClassAdapter and
 * SocketObjectAdapter class methods.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-10
 * @version 11.0.5
 */
public class AdapterImplementation {
	/**
	 * This function has all implementation of SocketClassAdapter method by creating
	 * instance of that class.
	 */
	private static void implSocketClassAdapter() {
		SocketAdapter socketClassAdapter = new SocketClassAdapter();
		Volt v3 = getVolt(socketClassAdapter, 3);
		Volt v12 = getVolt(socketClassAdapter, 12);
		Volt v120 = getVolt(socketClassAdapter, 120);
		System.out.println("v3 volts using Class Adapter : " + v3.getVolts());
		System.out.println("v12 volts using Class Adapter : " + v12.getVolts());
		System.out.println("v120 volts using Class Adapter : " + v120.getVolts());

	}

	/**
	 * This function has all implementation of SocketObjectAdapter method by
	 * creating instance of that class.
	 */
	private static void implSocketObjectAdapter() {
		SocketAdapter socketObjectAdapter = new SocketObjectAdapter();
		Volt v3 = getVolt(socketObjectAdapter, 3);
		Volt v12 = getVolt(socketObjectAdapter, 12);
		Volt v120 = getVolt(socketObjectAdapter, 120);
		System.out.println("v3 volts using Object Adapter : " + v3.getVolts());
		System.out.println("v12 volts using Object Adapter : " + v12.getVolts());
		System.out.println("v120 volts using Object Adapter : " + v120.getVolts());
	}

	/**
	 * takes SockAdterper object and integer input value as input parameter and
	 * returns the value of that class.
	 * 
	 * @param sockAdapter Class type as input parameter
	 * @param inputValue  of Integer type
	 * @return Volt of Class type.
	 */
	private static Volt getVolt(SocketAdapter sockAdapter, int inputValue) {
		switch (inputValue) {
		case 3:
			return sockAdapter.get3Volt();
		case 12:
			return sockAdapter.get12Volt();
		case 120:
			return sockAdapter.get120Volt();
		default:
			return sockAdapter.get120Volt();
		}
	}

	public static void main(String[] args) {
		implSocketClassAdapter();
		implSocketObjectAdapter();
	}

}
