package com.bridgeLabz.algorithmPrograms;

import java.util.ArrayList;
import java.util.List;

import com.bridgeLabz.utility.Sorting;

public class InsertionSortGenerics {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("ramesh");
		list.add("Suresh");
		list.add("json");
		list.add("Java");
		list.add("C");
		list.add("python");
		list.add("Selenium");
		list.add("ManualTesting");
		System.out.println(list.toString());
		Sorting.selectionSort(list);
		System.out.println(list.toString());

		List<Integer> list2 = new ArrayList<>();
		list2.add(10);
		list2.add(90);
		list2.add(1);
		list2.add(45);
		list2.add(92);
		list2.add(47);
		list2.add(9);
		list2.add(72);
		System.out.println(list2.toString());
		Sorting.selectionSort(list2);
		System.out.println(list2.toString());

	}

}
