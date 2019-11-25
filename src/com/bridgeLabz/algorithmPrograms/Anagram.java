package com.bridgeLabz.algorithmPrograms;

import com.bridgeLabz.utility.Util;

/**
 * prints the number given in the limit by checking anagram.
 * 
 * @author Durgasankar Mishra
 * @created 2019-11-20
 * @version 11.0.5
 */
public class Anagram {

	public static void main(String[] args) {
		System.out.println("Please enter First String :");
		String str1 = Util.scanner.nextLine();
		System.out.println("Please enter Second String :");
		String str2 = Util.scanner.nextLine();
		Util.scanner.close();
		if (Util.isAnagram(str1, str2)) {
			System.out.println("Anagram");
		} else {
			System.out.println("not anagram");
		}
	}

}
