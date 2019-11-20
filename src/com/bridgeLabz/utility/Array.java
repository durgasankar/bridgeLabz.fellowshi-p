package com.bridgeLabz.utility;

/**
 * This class holds all the reusable functions of Arrays.
 * 
 * @author Durgasankar Mishra
 * @created 2019-11-14
 */
public class Array {
	/**
	 * print 1D Integer array
	 * 
	 * @param it takes 1D Integer array as input
	 */
	public static void print1DArray(int array[]) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	/**
	 * print 1D String array
	 * 
	 * @param array takes 1D String array as input
	 */
	public static void print1DArray(String array[]) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	/**
	 * prints the values of 2D array
	 * 
	 * @param it takes a parameter integer 2D array as input
	 */
	public static void print2DArray(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * loop iterate till middle element and swaps the position of index based on i
	 * value if it is odd t do not swap the position of middle value if it is even
	 * it swaps the position of middle value and returns the revered array.
	 * 
	 * @param arr takes a parameter integerArray
	 * @return revered Array.
	 */
	public static int[] reversedArray(int[] arr) {
		for (int i = 0; i < arr.length / 2; i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = temp;
		}
		return arr;
	}

}
