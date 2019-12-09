package com.bridgeLabz.designPattern.singleton;

/**
 * This class has the functionality of getting a threadSafe object of instance.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-09
 * @version 11.0.5
 */
public class ThreadSafeSingleton {
	private static ThreadSafeSingleton instance;

	/**
	 * Constructor to initialize the class and as it is private new istance cannot
	 * be created.
	 */
	private ThreadSafeSingleton() {

	}

	/**
	 * Synchronized keyword make this method threadSafe.
	 * 
	 * @return Class type new Instance
	 */
	public static synchronized ThreadSafeSingleton getInstance() {
		if (instance == null) {
			instance = new ThreadSafeSingleton();
		}
		return instance;
	}
	

}
