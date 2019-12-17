package com.bridgeLabz.algorithmPrograms;

import com.bridgeLabz.utility.Array;
import com.bridgeLabz.utility.Sorting;

public class BubbleSort {
	public static void main(String[] args) {
		
		int[] array = {10,90,45,91,25,73,64,32,16};
		Array.print1DArray(array);
		System.out.println("Bubble sort");
		Sorting.bubbleSort(array);
		Array.print1DArray(array);
	}

}
