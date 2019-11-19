package com.bridgeLabz.algorithmPrograms;

import java.util.Arrays;
import com.bridgeLabz.utility.Array;
import com.bridgeLabz.utility.Searching;
import com.bridgeLabz.utility.Util;

/**
 * Binary Search String execution by taking the input from the file present at
 * other location
 * 
 * @author Durgasankar Mishra
 * @created 2019-11-19
 * @version 11.05.0
 */

public class BinarySearch {

	public static void main(String[] args) {
		String[] array = Util.readFiles("C:\\Users\\durgasankar\\eclipse-workspace\\binarySearch.txt");
		Array.print1DArray(array);
		System.out.println("Enter the String You want to search for :");
		String saerchingString = Util.scanner.nextLine();
		Arrays.sort(array);
		if (Searching.binarySearch(array, saerchingString) >= 0) {
			System.out.println("Found!");
		} else {
			System.out.println("Not Found!");
		}
	}

}
