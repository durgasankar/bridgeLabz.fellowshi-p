package com.bridgeLabz.basicCorePrograms;

import com.bridgeLabz.utility.Util;

/**
 * A coin is flipped and head percentage is calculated . user gives the input as
 * number of times the coin is needed to be flipped.
 * 
 * @author Durgasankar Mishra
 * @created 2019-11-14
 * @version 11.0.5
 */

public class FlipCoin {
	/**
	 * User gives the input as number of times the coin is need to be flipped. Every
	 * time a random number is generated. if it is less than 0.5 o/p is head. After
	 * the termination of loop head percentage is returned by the function.
	 * 
	 * @param times parameter determines number of times coin need to be flipped.
	 * @return head percentage.
	 */
	private static double flipPercentage(int times) {
		double heads = 0;
		for (int i = 0; i <= times; i++) {
			if (Math.random() > 0.5) {
				heads++;
			}
		}
		return (heads / times) * 100;
	}

	public static void main(String[] args) {
		System.out.println("Enter Number of Times coin to be flipped");
		int times = Util.scanner.nextInt();
		double percentage = flipPercentage(times);
		System.out.println("Head percentage : " + String.format("%.2f", percentage));
	}

}
