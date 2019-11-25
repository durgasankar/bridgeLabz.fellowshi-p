package com.bridgeLabz.dataStructurePrograms;

import com.bridgeLabz.dataStructurePrograms.generics.LinkedList;
import com.bridgeLabz.utility.Sorting;
import com.bridgeLabz.utility.Util;

/**
 * Read the data from the desktop and arrange then in ascending order. ask the
 * user to enter a number . If the input number is found in the list then delete
 * the number. if not found then insert the number to the list and display the
 * list.
 * 
 * @author Durgasankar Mishra
 * @created 2019-11-25
 * @version 11.0.5
 *
 */
public class OrderedList {
	private static LinkedList<Integer> list = new LinkedList<Integer>();

	/**
	 * it does the operation as per user instructions.
	 * 
	 * @param number as input by the user for operation
	 * @param list   Linked list for storing data.
	 */
	private static void addRemoveOperation(int number, LinkedList<Integer> list) {
		if (list.search(number)) {
			list.deleteData(number);
			System.out.println(number + " found! & " + " succesfully deleted...");
		} else {
			list.insert(number);
			System.out.println(number + " not found! & " + " succesfully added...");
		}
	}

	/**
	 * converts String array to integer array.
	 * 
	 * @param stringArray as input parameter
	 * @return integerArray
	 */
	private static int[] convertingStringToInteger(String[] stringArray) {
		int[] intArray = new int[stringArray.length];
		for (int i = 0; i < stringArray.length; i++) {
			intArray[i] = Integer.parseInt(stringArray[i]);
		}
		Sorting.insertionSort(intArray);
		return intArray;
	}

	/**
	 * it takes integer Array as input and convert to linked list.
	 * 
	 * @param intArray as input to be converted to linked List.
	 * @return linkedList
	 */
	private static LinkedList<Integer> convertingArrayToList(int[] intArray) {
		for (Integer data : intArray) {
			list.insert(data);
		}
		return list;
	}

	public static void main(String[] args) {

		// collected data stored in String array
		String[] stringArray = Util.readFile("C:\\Users\\durgasankar\\eclipse-workspace\\integerTest.txt").split(",");

		int[] intArray = convertingStringToInteger(stringArray);

		convertingArrayToList(intArray);

		System.out.println("List length : " + list.length() + "\nCurrent List\n-------------");
		list.print();

		System.out.println("Please Enter the data for operation :");
		int operationalData = Util.scanner.nextInt();
		addRemoveOperation(operationalData, list);

		list.print();

	}

}
