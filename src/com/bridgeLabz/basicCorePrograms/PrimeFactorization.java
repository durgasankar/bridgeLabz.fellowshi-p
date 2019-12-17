package com.bridgeLabz.basicCorePrograms;

import com.bridgeLabz.dataStructurePrograms.generics.LinkedList;
import com.bridgeLabz.utility.Util;

public class PrimeFactorization {
	public static void main(String[] args) {

		primeFactors(12);

	}

	public static void primeFactors(int number) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 1; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				if (number / i == i) {
					list.insert(i);
				} else {
					list.insert(i);
					list.insert(number / i);
				}
			}
		}
		for (int i = 0; i < list.length(); i++) {
			if (Util.isPrime(list.getDataFromIndex(i)))
				System.out.println(list.getDataFromIndex(i));
		}
	}

}
