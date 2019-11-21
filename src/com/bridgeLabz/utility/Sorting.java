package com.bridgeLabz.utility;

import java.util.List;

/**
 * all type of sorting algorithms. bubble sort , merge sort, insertion sort and
 * all of generic type insertionSort.
 * 
 * @author Durgasankar Mishra
 * @created 2019-11-20
 * @version 11.0.5
 */
public class Sorting {
	/**
	 * This method will sort the String array using insertion sort in java algorithm
	 * 
	 * @param arr array as the parameter
	 * @return sorted String array
	 * @created 2019-11-20
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
	 * @created 2019-11-20
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
	 * @created 2019-11-19
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

	/**
	 * swap first element with second element and store it in a List of any type.
	 * 
	 * @param <G>       generic class type as input Parameter.
	 * @param list      for storing the data in Collections type.
	 * @param firstPos  as a parameter which need to be swapped.
	 * @param secondPos as parameter for swapping
	 * @created 2019-11-21
	 */
	private static <G extends Comparable<G>> void swap(List<G> list, int firstPos, int secondPos) {
		G temp = list.get(firstPos);
		list.set(firstPos, list.get(secondPos));
		list.set(secondPos, temp);
	}

	/**
	 * Generic Type Class implements Comparable interface which has one comparedTo
	 * method which works by returning an integer value that is either positive,
	 * negative, or zero. This loops will continue unless each value is sorted .
	 * after sorting all elements it will return the list
	 * 
	 * @param <G>  generic class type as input Parameter.
	 * @param list for storing the data in Collections type.
	 * @return sorted generic type data in collection type.
	 * @created 2019-11-21
	 */
	public static <G extends Comparable<G>> List<G> selectionSort(List<G> list) {
		for (int i = 0; i < list.size(); i++) {
			int minPos = -1;
			G minValue = list.get(i);
			for (int j = i + 1; j < list.size(); j++) {
				G secondPosition = list.get(j);
				/**
				 * works by returning an integer value that is either positive, negative, or
				 * zero. It compares the object by making the call to the object that is the
				 * argument. A negative number means that the object making the call is “less”
				 * than the argument.
				 */
				if (minValue.compareTo(secondPosition) > 0) {
					minPos = j;
					minValue = list.get(j);
				}
			}
			/**
			 * if minimum value returned is greater than 0 it swap the searching element
			 * with minimum position.
			 */
			if (minPos >= 0) {
				swap(list, i, minPos);
			}
		}
		return list;
	}

}
