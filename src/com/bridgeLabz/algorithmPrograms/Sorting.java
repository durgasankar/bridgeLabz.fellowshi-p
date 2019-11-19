package com.bridgeLabz.algorithmPrograms;

import com.bridgeLabz.utility.Array;
import com.bridgeLabz.utility.Util;

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

	public static void main(String[] args) {

		String[] array = Util.readFiles("C:\\Users\\durgasankar\\eclipse-workspace\\binarySearch.txt");
		String[] array1 = insertionSort(array);
		Array.print1DArray(array);
		System.out.println("--------------------------------------");
		Array.print1DArray(array1);
	}

}
