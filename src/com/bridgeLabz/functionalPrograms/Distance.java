package com.bridgeLabz.functionalPrograms;

import java.util.Scanner;

public class Distance {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter the value of x1 , x2, y1, y2");
		int x1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y1 = sc.nextInt();
		int y2 = sc.nextInt();

		euclidianDistance(x1, x2, y1, y2);

	}

	private static void euclidianDistance(int x1, int x2, int y1, int y2) {
		double d1 = Math.pow(x1 - y1, 2);
		double d2 = Math.pow(x2 - y2, 2);
		double euclidDist = Math.sqrt(d1 + d2);

		System.out.println("Euclid distance = " + euclidDist);
	}

}
