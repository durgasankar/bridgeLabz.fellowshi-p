package com.bridgeLabz.functionalPrograms;

import com.bridgeLabz.utility.Util;

/**
 * This class has the functionality of Finding sum of three numbers.
 * 
 * @author Durgasankar Mishra
 * @created 2019-11-13
 * @version 1.0
 */
public class SumOfThreeIntegers {
	public static void main(String[] args) {
		System.out.println("Enter the length of array : ");
		int length = Util.scanner.nextInt();

		int[] arr = new int[length];
		System.out.println("Enter the values : ");

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Util.scanner.nextInt();
		}
		System.out.println("Triplets are : ");
		findTriplet(arr);

	}

	/**
	 * Finding triplets.
	 * 
	 * @param arr as Integer array
	 */
	private static void findTriplet(int[] arr) {
		boolean found = false;
		for (int i = 0; i < arr.length - 2; i++) {
			for (int j = i + 1; j < arr.length - 1; j++) {
				for (int k = j + 1; k < arr.length; k++) {
					if (arr[i] + arr[j] + arr[k] == 0) {
						System.out.println(arr[i]);
						System.out.println(arr[j]);
						System.out.println(arr[k]);
						found = true;
					}
				}
			}
		}
		if (found == false) {
			System.out.println("Not Exist");
		}
	}

}
