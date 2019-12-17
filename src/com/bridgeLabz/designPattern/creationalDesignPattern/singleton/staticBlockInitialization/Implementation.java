package com.bridgeLabz.designPattern.creationalDesignPattern.singleton.staticBlockInitialization;

/**
 * In this class we created two instances as this is static we created by
 * calling class name checked their hashCodes. both the hash code found to be
 * equal which signifies that this class is StaticSingleton as further instances
 * cannot be created.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-07
 * @version 11.0.5
 */

public class Implementation {

	/**
	 * Just a formated Print statement to get the hashCode.
	 * 
	 * @param name   as String input parameter
	 * @param object as Object type input parameter
	 */
	private static void print(String name, StaticSingleton object) {
		System.out.println(String.format("Object : %s, Hashcode : %d", name, object.hashCode()));
	}

	public static void main(String[] args) {
		StaticSingleton ref1 = StaticSingleton.getInstance();
		StaticSingleton ref2 = StaticSingleton.getInstance();

		print("ref1", ref1);
		print("ref2", ref2);

	}

}
