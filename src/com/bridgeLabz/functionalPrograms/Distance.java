package com.bridgeLabz.functionalPrograms;

import com.bridgeLabz.utility.Util;

/**
 * This class has the functionality of finding distance.
 * 
 * @author Durgasankar Mishra
 * @created 2019-11-13
 * @version 1.0
 */
public class Distance {
	public static void main(String[] args) {
		System.out.println("Enter the value of x1Coordinate , x2Coordinate, y1Coordinate, y2Coordinate");
		int x1Coordinate = Util.scanner.nextInt();
		int x2Coordinate = Util.scanner.nextInt();
		int y1Coordinate = Util.scanner.nextInt();
		int y2Coordinate = Util.scanner.nextInt();

		euclidianDistance(x1Coordinate, x2Coordinate, y1Coordinate, y2Coordinate);

	}

	/**
	 * Calculation of euclid distance.
	 * 
	 * @param x1Coordinate as Integer
	 * @param x2Coordinate as Integer
	 * @param y1Coordinate as Integer
	 * @param y2Coordinate as Integer
	 */
	private static void euclidianDistance(int x1Coordinate, int x2Coordinate, int y1Coordinate, int y2Coordinate) {
		double d1 = Math.pow(x1Coordinate - y1Coordinate, 2);
		double d2 = Math.pow(x2Coordinate - y2Coordinate, 2);
		double euclidDist = Math.sqrt(d1 + d2);

		System.out.println("Euclid distance = " + euclidDist);
	}

}
