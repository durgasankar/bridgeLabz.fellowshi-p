package com.bridgeLabz.designPattern.creationalDesignPattern.singleton.Enum;

/**
 * Implementation of ENUM created 2 instance and compared their HashCode
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-23
 * @version 1.8
 */
public class Singleton {

	public static void main(String[] args) {
		ESingleton instance = ESingleton.INSTANCE;
		instance.i = 5;
		instance.show();
		System.out.println(instance.hashCode());

		ESingleton instance2 = ESingleton.INSTANCE;
		instance2.i = 9;
		instance.show();
		System.out.println(instance2.hashCode());

	}

}
