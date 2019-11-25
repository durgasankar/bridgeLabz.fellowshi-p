package com.bridgeLabz.algorithmPrograms;

import com.bridgeLabz.utility.Util;

/**
 * prints the number given in the limit by checking prime, palindrome, anagram.
 * 
 * @author Durgasankar Mishra
 * @created 2019-11-20
 * @version 11.0.5
 */
public class PrimeAnagramPallindrome {
	public static void main(String[] args) {
		System.out.println("Enter the lower limit of the range :");
		int lowerLimit = Util.scanner.nextInt();
		System.out.println("Enter the upper limit of the range :");
		int upperLimit = Util.scanner.nextInt();
		Util.scanner.close();
		System.out.println("Numbers are :");

		for (int number = lowerLimit; number <= upperLimit; number++) {
			if (Util.isPrime(number)) {
				String StringNumber = Integer.toString(number);
				if (Util.isPallindrome(StringNumber)) {
					if (Util.isAnagram(StringNumber, StringNumber)) {
						System.out.println(Integer.parseInt(StringNumber));
					}
				}
			}
		}
	}

}
