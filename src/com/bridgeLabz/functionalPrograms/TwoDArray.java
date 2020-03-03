package com.bridgeLabz.functionalPrograms;

import com.bridgeLabz.utility.Array;
import com.bridgeLabz.utility.Util;

/**
 * This class has the functionality displaying 2D array.
 * 
 * @author Durgasankar Mishra
 * @created 2019-11-15
 * @version 1.0
 */
public class TwoDArray {

	public static void main(String[] args) {
		System.out.println("Enter total rows : ");
		int rows = Util.scanner.nextInt();
		System.out.println("Enter total columns");
		int columns = Util.scanner.nextInt();

		int[][] arr = new int[rows][columns];

		System.out.println("Enter the values : ");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = Util.scanner.nextInt();
			}
		}

		Array.print2DArray(arr);

	}

}
