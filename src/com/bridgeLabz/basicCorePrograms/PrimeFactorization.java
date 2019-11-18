package com.bridgeLabz.basicCorePrograms;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorization {
	public static void main(String[] args) {

		primeFactors(12);

	}

	public static void primeFactors(int number) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				if (number / i == i) {
					list.add(i);
				} else {
					list.add(i);
					list.add(number / i);
				}
			}
		}
		for (int i = 0; i < list.size(); i++) {
			if (isPrime(list.get(i))) {
				System.out.println(list.get(i));
			}
		}

	}

	private static boolean isPrime(int number) {
		if (number == 1) {
			return false;
		} else {
			for (int i = 2; i <= number / 2; i++) {
				if (number % i == 0) {
					return false;
				}
			}
		}
		return true;
	}

}
