package com.bridgeLabz.algorithmPrograms;

import com.bridgeLabz.utility.Array;
import com.bridgeLabz.utility.Sorting;
import com.bridgeLabz.utility.Util;

public class InsertionSort {

	public static void main(String[] args) {

		String[] array = Util.readFile("C:\\Users\\durgasankar\\eclipse-workspace\\binarySearch.txt").split(",");
		String[] array1 = Sorting.insertionSort(array);
		Array.print1DArray(array);
		System.out.println("--------------------------------------");
		Array.print1DArray(array1);
	}

}
