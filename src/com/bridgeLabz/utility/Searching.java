package com.bridgeLabz.utility;

import java.util.List;

/**
 * To search whether the element is present in the array or not.
 * 
 * @author Durgasankar Mishra
 * @created 2019-11-19
 * @version 11.0.5
 */

public class Searching {

	/**
	 * This is only applicable on sorted array and it will find the integer value
	 * and returns its position as per Zero index.
	 * 
	 * @param inputArray take String Array as parameter.
	 * @param key        is the value which to be Searched.
	 * @return the position of the searching Element.
	 * @created 2019-11-19
	 */
	public static int binarySearch(int[] inputArray, int key) {
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
	 * This is only applicable on sorted array and it will find the String value and
	 * returns its position as per Zero index.
	 * 
	 * @param names input array as a parameter.
	 * @param key   as parameter which is need to be searched from the array.
	 * @return index of key if it is present in input array else return negative.
	 * @created 2019-11-20
	 */
	public static int binarySearch(String[] names, String key) {
		int first = 0;
		int last = names.length - 1;
		while (first <= last) {
			int middle = (last + (last - first)) / 2;
			int result = key.compareTo(names[middle]);
			if (result == 0) {
				return middle;
			}
			if (result > 0) {
				first = middle + 1;
			} else {
				last = middle - 1;
			}
		}
		return -1;
	}

	/**
	 * Iterate to last of the array and return the index position of the array. it
	 * return index value of the key if present.
	 * 
	 * @param <G>  generic class type as input Parameter.
	 * @param list accept list of any List type.
	 * @param key  as value to be search
	 * @return integer value
	 * @created 2019-11-21
	 */

	public static <G> int linearSearch(List<G> list, G key) {
		for (int index = 0; index < list.size(); index++) {
			if (key.equals(list.get(index))) {
				return index;
			}
		}
		return -1;
	}

	/**
	 * Iterate to last of the array and return the index position of the array. it
	 * return index value of the key if present.
	 * 
	 * @param <G>   generic class type as input Parameter.
	 * @param array accept array of any Class type.
	 * @param key   as value to be search
	 * @return integer value
	 */
	public static <G> int linearSearch(G[] array, G key) {
		for (int index = 0; index < array.length; index++) {
			if (key.equals(array[index])) {
				return index;
			}
		}
		return -1;
	}

}
