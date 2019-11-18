package com.bridgeLabz.functionalPrograms;

import java.util.Scanner;

public class Quadratic {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter the value of a, b, c");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		quadraticNumber(a, b, c);

	}

	private static void quadraticNumber(int a, int b, int c) {
		System.out.println("Quadratic equation : " + a + "x^2 + " + b + "x + " + c);

		if (a == 0) {
			System.out.println("a must not be 0 else linear equation");
		} else {

			double delta = Math.sqrt(Math.abs(b * b - 4 * a * c));

			double root1 = ((double) (-b) + delta) / 2 * a;
			double root2 = ((double) (-b) - delta) / 2 * a;
			System.out.println("x1 : " + root1 + "\t&&" + "\tx2 : " + root2);
		}

	}

}
