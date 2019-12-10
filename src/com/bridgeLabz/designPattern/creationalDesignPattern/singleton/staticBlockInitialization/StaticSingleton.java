package com.bridgeLabz.designPattern.creationalDesignPattern.singleton.staticBlockInitialization;

/**
 * This class contains a private constructor returns new Instance when ever it
 * is called.As constructor is private it will create only one instance.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-09
 * @version 11.0.5
 */
public class StaticSingleton {
	private static StaticSingleton instance;

	private StaticSingleton() {

	}

	static {
		instance = new StaticSingleton();
	}

	public static StaticSingleton getInstance() {
		return instance;
	}

}
