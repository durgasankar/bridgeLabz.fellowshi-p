package com.bridgeLabz.designPattern.singletonLink;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * In this class we created two instances as this is static we created by
 * calling class name checked their hashCodes. both the hash code found to be
 * equal which signifies that this class is Singleton as further instances
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
	private static void print(String name, Singleton object) {
		System.out.println(String.format("Object : %s, Hashcode : %d", name, object.hashCode()));
	}

	public static void main(String[] args) throws Exception {
		/**
		 * we cannot create object as constructor is private.
		 */
//		Singleton singleton = new Singleton();
		/**
		 * Both the hashCodes are equal which proves new Instances cannot be created.
		 */
		Singleton ref1 = Singleton.getInstance();
		Singleton ref2 = Singleton.getInstance();

		print("ref1", ref1);
		print("ref2", ref2);

		// reflection API
		/**
		 * Breaking of Singleton reference by using reflection API collected the class
		 * name then collected the constructor of the class and changed the access of
		 * the constructor to public then created new instance and checked the hashCode
		 * of the instance its different so we broke the singleton of the class.
		 * 
		 */
		@SuppressWarnings("rawtypes")
		Class clazz = Class.forName("com.bridgeLabz.designPattern.singletonLink.Singleton");
		@SuppressWarnings("unchecked")
		Constructor<Singleton> ctor = clazz.getDeclaredConstructor();
		ctor.setAccessible(true);

		Singleton ref3 = ctor.newInstance();

		print("ref3", ref3);

		// SeriaLizable
		/**
		 * 
		 */
		@SuppressWarnings("resource")
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ref2.ser"));
		oos.writeObject(ref2);
		@SuppressWarnings("resource")
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ref2.ser"));
		Singleton ref4 = (Singleton) ois.readObject();
		
		print("ref4", ref4);
	}

}
