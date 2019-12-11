package com.bridgeLabz.designPattern.singletonLink;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import java.lang.reflect.Constructor;
import org.junit.Test;

import com.bridgeLabz.designPattern.creationalDesignPattern.singleton.eagerInitialization.Singleton;

public class TestSingletonLink {

	@Test
	public void test_singletonLink_compareByHashcode() {
		int ref1HashCode = Singleton.getInstance().hashCode();
		assertEquals(ref1HashCode, Singleton.getInstance().hashCode());
	}

	// reflection API
	/**
	 * Breaking of Singleton reference by using reflection API collected the class
	 * name then collected the constructor of the class and changed the access of
	 * the constructor to public then created new instance and checked the hashCode
	 * of the instance its different so we broke the singleton of the class.
	 * 
	 */
	@Test
	public void test_singletonLink_compareByHashCode_reflectionAPI() throws Exception {
		Object ref1HashCode = Singleton.getInstance().hashCode();
		@SuppressWarnings("rawtypes")
		Class clazz = Class.forName("com.bridgeLabz.designPattern.creationalDesignPattern.singleton.eagerInitialization.Singleton");
		@SuppressWarnings("unchecked")
		Constructor<Singleton> ctor = clazz.getDeclaredConstructor();
		ctor.setAccessible(true);
		int ref2HashCode = ctor.newInstance().hashCode();

		assertNotEquals(ref1HashCode, ref2HashCode);

	}
	
}
