package com.bridgeLabz.algorithmPrograms;

import java.util.Random;

import com.bridgeLabz.utility.Util;

public class RandomNumberOutPut {
	/**
	 * takes lower limit integer value and upper limit integer value and generate
	 * random number in between the assigned value.
	 * 
	 * @param lowerLimit integer value from user
	 * @param upperLimit integer value from user
	 * @return integer value.
	 * @created 2019-11-21
	 */
	private static int thinkNumberInRange(int lowerLimit, int upperLimit) {
		Random random = new Random();
		int userThought = random.nextInt(upperLimit - lowerLimit) + lowerLimit;
		return userThought;
	}

	public static void main(String[] args) {
		System.out.println("Enter Lower positive range :");
		int lowerRange = Util.scanner.nextInt();
		System.out.println("Enter Higher positive range :");
		int higherRange = Util.scanner.nextInt();
		int userThought = thinkNumberInRange(lowerRange, higherRange);
		System.out.println(userThought);
		long powerOfTwo = (long) Util.powerOfTwo(userThought);
		System.out.println("Two to the Power " + userThought + " is " + powerOfTwo);
	}

}
