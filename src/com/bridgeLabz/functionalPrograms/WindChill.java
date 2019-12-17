package com.bridgeLabz.functionalPrograms;

import java.util.Scanner;

public class WindChill {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Eneter temp : ");
		int t = sc.nextInt();
		System.out.println("Enter velocity : ");
		int v = sc.nextInt();

		windChill(t, v);

	}

	private static boolean windChill(int t, int v) {
		if (Math.abs(t) < 50) {
			if (v > 120 && v < 3) {
				System.out.println("Opps... Invalid");
				return false;
			} else {
				double w = 35.74 + 0.6215 * t + (0.4275 * t - 35.75) * Math.pow(v, 0.16);
				System.out.println("Temperature = " + t);
				System.out.println("Wind speed  = " + v);
				System.out.println("Wind chill  = " + w);
				return true;
			}
		} else {
			System.out.println("Plz enter correct t value");
			return false;
		}
	}

}
