package com.bridgeLabz.functionalPrograms;

import com.bridgeLabz.utility.Util;

/**
 * This class has the functionality of wind chill operation.
 * 
 * @author Durgasankar Mishra
 * @created 2019-11-15
 * @version 1.0
 */
public class WindChill {
	public static void main(String[] args) {
		System.out.println("Eneter temp : ");
		int temperature = Util.scanner.nextInt();
		System.out.println("Enter velocity : ");
		int velocity = Util.scanner.nextInt();

		windChill(temperature, velocity);

	}

	/**
	 * 
	 * @param temperature as Integer
	 * @param velocity    as Integer
	 * @return Boolean
	 */
	private static boolean windChill(int temperature, int velocity) {
		if (Math.abs(temperature) < 50) {
			if (velocity > 120 && velocity < 3) {
				System.out.println("Opps... Invalid");
				return false;
			} else {
				double windChill = 35.74 + 0.6215 * temperature
						+ (0.4275 * temperature - 35.75) * Math.pow(velocity, 0.16);
				System.out.println("Temperature = " + temperature);
				System.out.println("Wind speed  = " + velocity);
				System.out.println("Wind chill  = " + windChill);
				return true;
			}
		} else {
			System.out.println("Plz enter correct t value");
			return false;
		}
	}

}
