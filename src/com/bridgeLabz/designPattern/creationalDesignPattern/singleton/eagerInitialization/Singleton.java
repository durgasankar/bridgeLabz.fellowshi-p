package com.bridgeLabz.designPattern.creationalDesignPattern.singleton.eagerInitialization;

import java.io.Serializable;

/**
 * This is Single ton class example.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-07
 * @version 11.0.5
 */
@SuppressWarnings("serial")
public class Singleton implements Serializable {
	/**
	 * just a static class type variable
	 */
	private static Singleton singleInstance = new Singleton();

	/**
	 * constructor as private so that restrict from creating objects.
	 */
	private Singleton() {
		System.out.println("Private constructor");
	}

	/**
	 * just a getter function to get Instance
	 * 
	 * @return Class type data.
	 */
	public static Singleton getInstance() {
		return singleInstance;
	}

}
