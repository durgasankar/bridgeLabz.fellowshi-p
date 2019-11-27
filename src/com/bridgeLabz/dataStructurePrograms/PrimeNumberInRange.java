package com.bridgeLabz.dataStructurePrograms;

import com.bridgeLabz.utility.Util;

/**
 * it checks the data if it is prime or not . if prime then it add the data in a
 * group of 100 elements till it reaches user define range data. if the number
 * is found to be prime then prints the data.
 * 
 * @author Durgasankar Mishra
 * @created 2019-11-27
 * @version 11.0.5
 */
public class PrimeNumberInRange {
	/**
	 * check the data of 2d array and prints it.
	 * 
	 * @param array 2d array as input parameter
	 */
	private static void print(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] != 0)
					System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] primeNumberArray = new int[10][100];
		int number = 1;
		while (number < 1000) {
			for (int i = 0; i < primeNumberArray.length; i++) {
				for (int j = 0; j < primeNumberArray[i].length; j++) {
					if (Util.isPrime(number)) {
						primeNumberArray[i][j] = number;
					}
					number++;
				}
			}
		}
		print(primeNumberArray);

	}

}
