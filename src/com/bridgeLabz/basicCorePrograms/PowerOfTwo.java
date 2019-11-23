package com.bridgeLabz.basicCorePrograms;

import java.util.Scanner;

import com.bridgeLabz.utility.Util;

public class PowerOfTwo {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// 11
		System.out.println("Enter the power of Two");
		int power = sc.nextInt();
		double result = Util.powerOfTwo(power);

		if (power >= 1 && power <= 31) {
			System.out.println("2 ^ " + power + " = " + result);

			if (Util.isLeapYear((int)result) == true) {
				System.out.println(result + " is a leap year");
			} else {
				System.out.println(result + " not a leap year");
			}
		} else {
			System.out.println("Invalid Power");
		}
	}

	

}
