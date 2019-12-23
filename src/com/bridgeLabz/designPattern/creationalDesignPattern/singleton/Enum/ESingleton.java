package com.bridgeLabz.designPattern.creationalDesignPattern.singleton.Enum;

/**
 * ENUM which is of public static final and has a method show
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-23
 * @version 1.8
 */
public enum ESingleton {
	INSTANCE;

	int i;

	public void show() {
		System.out.println(i);
	}

}
