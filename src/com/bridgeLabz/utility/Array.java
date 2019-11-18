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
	public static void print1DIntegerArray(int array[]) {
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}

	/**
	 * print 1D String array
	 * 
	 * @param array takes 1D String array as input
	 */
	public static void print1DStringArray(String array[]) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	/**
	 * This is only applicable on sorted array and it will find the integer value
	 * and returns its position as per Zero index.
	 * 
	 * @param inputArray take String Array as parameter.
	 * @param key        is the value which to be Searched.
	 * @return the position of the searching Element.
	 */
	public static int binarySearchInteger(int[] inputArray, int key) {
		int start = 0;
		int end = inputArray.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (key == inputArray[mid]) {
				return mid;
			}
			if (key < inputArray[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	/**
	 * prints the values of 2D array
	 * 
	 * @param it takes a parameter integer 2D array as input
	 */
	public static void print2DIntegerArray(int[][] array) {
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
