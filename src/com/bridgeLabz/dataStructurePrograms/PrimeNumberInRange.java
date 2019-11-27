package com.bridgeLabz.dataStructurePrograms;

import com.bridgeLabz.utility.Array;
import com.bridgeLabz.utility.Util;

/**
 * it checks the data if it is prime or not . if prime then it add the data in a
 * group of 100 elements till it reaches user define range data. if the number
 * is found to be prime then prints the data. in 2D array.
 * 
 * @author Durgasankar Mishra
 * @created 2019-11-27
 * @version 11.0.5
 */
public class PrimeNumberInRange {

	public int[][] primeChecker(int[][] arr) {
		int startingNumber = 1;
		while (startingNumber < 1000) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					if (Util.isPrime(startingNumber)) {
						arr[i][j] = startingNumber;
					}
					startingNumber++;
				}
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		PrimeNumberInRange primeChecking = new PrimeNumberInRange();
		int[][] intPrimeArray = new int[10][100];
		primeChecking.primeChecker(intPrimeArray);
		System.out.println("Prime Numbers are :\n--------------------");
		Array.print2DArray(intPrimeArray);
	}

}
