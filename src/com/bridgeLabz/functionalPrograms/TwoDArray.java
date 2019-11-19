package com.bridgeLabz.functionalPrograms;

import com.bridgeLabz.utility.Array;
import com.bridgeLabz.utility.Util;

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
