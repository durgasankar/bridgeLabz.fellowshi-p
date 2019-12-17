package com.bridgeLabz.dataStructurePrograms;

import com.bridgeLabz.utility.Util;

/**
 * Takes a array checks for prime Number and all prime Numbers are added to a
 * array. and each numbers are checked with its next number checked for anagram
 * condition if found anagram then it prints the numbers which are anagram
 * 
 * @author Durgasankar Mishra
 * @created 2019-11-27
 * @version 11.0.5
 */
public class PrimeAnagramNumberRange {
	/**
	 * takes 1D array as input and checks for anagram conditions if satisfied then
	 * transfer all elements to 2D array and then finally display them.
	 * 
	 * @param inputArray as input 1D array
	 */
	public static void anagramCheckerPrinter(int[] inputArray) {
		int[] tempArray = new int[inputArray.length];
		for (int k = 0; k < inputArray.length; k++) {
			for (int j = k + 1; j < inputArray.length; j++) {
				if (Util.isAnagram(inputArray[k], inputArray[j]) && (inputArray[k] != 0 && inputArray[j] != 0)) {
					// System.out.println(arr[k] + " " + arr[j]);
					//transfered all elements to temporary 1D array.
					tempArray[k] = inputArray[k];
				}
			}
		}
		/**
		 * printing of 2D array.
		 */
		int x = 0;
		int[][] twoDArray = new int[10][100];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 100; j++) {
				twoDArray[i][j] = tempArray[x];
				x++;
				if (twoDArray[i][j] != 0)
					System.out.print(twoDArray[i][j] + "\t");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		// initialization of array
		int arr[] = new int[1000];
		// logic to check the prime numbers
		int number = 0;
		for (int i = 0; i < arr.length; i++) {
			if (Util.isPrime(number)) {

				arr[i] = number;
			}
			number++;
		}
		System.out.println("Numbers that are prime and anagram : ");

		anagramCheckerPrinter(arr);

	}

}
