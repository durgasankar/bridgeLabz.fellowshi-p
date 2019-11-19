package com.bridgeLabz.utility;

public class Sorting {

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

	public static int[] insertionSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			boolean swapping = true;
			for (int j = i + 1; j < array.length; j++) {
				swapping = false;
				if (array[i] > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
					swapping = true;
				}
			}
		}
		return array;
	}

}
