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
	private static int[][] arr = new int[10][100];

	/**
	 * if prime then it add the data in a group of 100 elements till it reaches user
	 * define range data.
	 * 
	 * @param start as integer value.
	 * @param end   as integer value.
	 * @return integer array of numbers.
	 */
	public static int[][] findPrime(int start, int end) {
		while (start <= end) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					if (Util.isPrime(start)) {
						arr[i][j] = start;
					}
					start++;
				}
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		int start = 1;
		int end = 1000;
		findPrime(start, end);
		Array.print2DArray(arr);

	}

}
