package com.bridgeLabz.utility;

/**
 * all type of sorting algorithms. bubble sort , merge sort, insertion sort and
 * all.
 * 
 * @author Durgasankar Mishra
 *
 */
public class Sorting {
	/**
	 * This method will sort the String array using insertion sort in java algorithm
	 * 
	 * @param arr array as the parameter
	 * @return sorted String array
	 */
	public static String[] insertionSort(String[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i].compareTo(array[j]) > 0) {
					String temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}

	/**
	 * This method will sort the integer array using insertion sort in java
	 * algorithm
	 * 
	 * @param array array as the parameter
	 * @return sorted integer array
	 */
	public static int[] insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int valueToSort = array[i];
			int j = i;
			/**
			 * loop will continue unless the value is not sorted at particular position
			 */
			while (j > 0 && array[j - 1] > valueToSort) {
				array[j] = array[j - 1];
				j--;
			}
			array[j] = valueToSort;
		}
		return array;
	}

	/**
	 * largest element of unsorted part will bubble up to the largest index of
	 * unsorted part.
	 * 
	 * @param array integer array as parameter
	 * @return sorted array of integer type.
	 */
	public static int[] bubbleSort(int array[]) {
		int n = array.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					// swap temporary variable and array[i]
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		return array;

	}

}
