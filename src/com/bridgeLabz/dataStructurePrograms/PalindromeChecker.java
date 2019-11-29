package com.bridgeLabz.dataStructurePrograms;

import com.bridgeLabz.dataStructurePrograms.generics.Deque;
import com.bridgeLabz.utility.Util;

/**
 * User gives a String as input and fetch all characters and transfer them to to
 * a Dequeue generic type and fetch first character and last characters checks
 * for equality continues till last 2 characters remains in the Dequeue. if all
 * removal characters of first and last equalize then the input String is
 * palindrome.
 * 
 * @author Durgasankar Mishra
 * @created 2019-11-26
 * @version 11.0.5
 */
public class PalindromeChecker {
	private static Deque<Character> deque = new Deque<Character>();

	/**
	 * it deletes first character and deletes last character continues till 2
	 * characters remains on the String if both removal characters matches then it
	 * returns boolean value.
	 * 
	 * @return Boolean value
	 */
	public static boolean palindromeChecker() {
		boolean isMatching = false;
		while (deque.size() > 1) {
			if (deque.deleteFirst() == deque.deleteLast()) {
				isMatching = true;
			}
		}
		return isMatching;
	}

	public static void main(String[] args) {
		System.out.println("Please Enter a String :");
		String inputString = Util.scanner.nextLine();

		// each characters are fetched and added to the a list of Dequeue.
		for (int i = 0; i < inputString.length(); i++) {
			char character = inputString.charAt(i);
			deque.addLast(character);
		}
		if (palindromeChecker()) {
			System.out.println(inputString + " =>  is palindrome...");
		} else {
			System.out.println(inputString + " =>  is not palindrome...");
		}

	}

}
