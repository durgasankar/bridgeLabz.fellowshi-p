package com.bridgeLabz.utility;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class TestSearching {
	int[] testArray = new int[10];
	String[] strArray = new String[10];

	@Before
	public void test_searching_preCondition() {
		int number = 1;
		for (int i = 0; i < testArray.length; i++)
			testArray[i] = number++;
		Arrays.sort(testArray);
		System.out.println(Arrays.toString(testArray));
	}
	@Before
	public void test_searching_String_precondition() {
		strArray[0] = "raja";
		strArray[1] = "ramesh";
		strArray[2] = "suresh";
		strArray[3] = "ritesh";
		strArray[4] = "ravan";
		strArray[5] = "shyam";
		strArray[6] = "yadav";
		strArray[7] = "lalu";
		strArray[8] = "bhalu";
		strArray[9] = "zack";
		Arrays.sort(strArray);
		System.out.println(Arrays.toString(strArray));
		
	}

	@Test
	public void test_searching_Integer_positiveData() {
		assertEquals(2, Searching.binarySearch(testArray, 3));
	}

	@Test
	public void test_searching_Integer_startingValue() {
		assertEquals(0, Searching.binarySearch(testArray, 1));
	}

	@Test
	public void test_searching_Integer_lastValue() {
		assertEquals(9, Searching.binarySearch(testArray, 10));
	}

	@Test
	public void test_searching_Integer_inputNotPresentInArray() {
		assertEquals(-1, Searching.binarySearch(testArray, -3));
	}
	
	@Test
	public void test_searching_String_positiveData() {
		assertEquals(0,Searching.binarySearch(strArray, "bhalu"));
	}
	
	@Test
	public void test_searching_String_inputNotPresentInArray() {
		assertEquals(-1, Searching.binarySearch(strArray, "aaaaaaaa"));
	}

}
