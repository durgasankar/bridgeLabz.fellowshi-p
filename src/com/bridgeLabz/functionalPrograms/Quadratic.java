package com.bridgeLabz.functionalPrograms;

import com.bridgeLabz.utility.Util;

/**
 * This class has the functionality of gambling.
 * 
 * @author Durgasankar Mishra
 * @created 2019-11-13
 * @version 1.0
 */
public class Quadratic {
	public static void main(String[] args) {
		System.out.println("Enter the value of a, b, c");
		int a = Util.scanner.nextInt();
		int b = Util.scanner.nextInt();
		int c = Util.scanner.nextInt();
		quadraticNumber(a, b, c);

	}

	/**
	 * 
	 * @param a as Integer
	 * @param b as Integer
	 * @param c as Integer
	 */
	private static void quadraticNumber(int a, int b, int c) {
		System.out.println("Quadratic equation : " + a + "x^2 + " + b + "x + " + c);

		if (a == 0) {
			System.out.println("a must not be 0 else linear equation");
		}

		double delta = Math.sqrt(Math.abs(b * b - 4 * a * c));
		double root1 = ((double) (-b) + delta) / 2 * a;
		double root2 = ((double) (-b) - delta) / 2 * a;
		System.out.println("x1 : " + root1 + "\t&&" + "\tx2 : " + root2);

	}

}
