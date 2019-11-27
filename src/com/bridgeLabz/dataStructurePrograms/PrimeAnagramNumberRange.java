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
	public static void main(String[] args) {
		// initialization of array
		int arr[] = new int[1000];
		// logic to check the prime numbers
		int number = 2;
		for (int i = 0; i < arr.length; i++) {
			if (Util.isPrime(number)) {

				arr[i] = number;
			}
			number++;
		}
		System.out.println("Numbers that are prime and anagram : ");
		
		// logic to check prime numbers are anagram or not.
		for (int k = 0; k < arr.length; k++) {
			for (int j = k + 1; j < arr.length; j++) {
				if (Util.isAnagram(arr[k], arr[j]) && (arr[k] != 0 && arr[j] != 0)) {
					System.out.println(arr[k] + " " + arr[j]);
				}
			}
		}
	}

}
