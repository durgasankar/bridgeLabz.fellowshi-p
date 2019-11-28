package com.bridgeLabz.dataStructurePrograms;

import com.bridgeLabz.utility.Array;
import com.bridgeLabz.utility.Util;

public class Test {
	private static int[][] arr = new int[10][100];

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

	// matching temp value
	private static int[][] anagramChecker(int[][] arr) {
		int[][] tempArr = new int[10][100];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr[i].length; j++) {
				if (Util.isAnagram(arr[i][0], arr[i][j])) {
					tempArr[i][0] = arr[i][0];
					tempArr[i][j] = arr[i][j];
				}
			}
		}
		return tempArr;
	}

	public static void main(String[] args) {
		int start = 1;
		int end = 1000;
		findPrime(start, end);
		int[][] anagramArrray = anagramChecker(arr);
		Array.print2DArray(anagramArrray);

	}

}
