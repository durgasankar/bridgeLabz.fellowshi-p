package com.bridgeLabz.dataStructurePrograms;

import com.bridgeLabz.dataStructurePrograms.generics.Stack;
import com.bridgeLabz.utility.Util;

/**
 * checks for prime for given range of inputs. if number is prime then checked
 * for anagram if both conditions satisfies then added to the stack and printed
 * the list.
 * 
 * @author Durgasankar Mishra
 * @created 2019-11-27
 * @version 11.0.5
 */
public class PrimeAnagramUsingStack {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i <= 1000; i++) {
			if (Util.isPrime(i)) {
				stack.push(i);
			}
		}
		/**
		 * @code store prime numbers from stack to array.
		 */
		int size = stack.size();
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = stack.pop();
		}
//		System.out.println(stack.size());
		/**
		 * @code prime Numbers that are anagram or not
		 */
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				if (Util.isAnagram(array[i], array[j]) && array[i] != 0 && array[j] != 0) {

					stack.push(array[i]);
					stack.push(array[j]);
				}
			}
		}
		System.out.println("All Numbers those are prime and anagram are :");
		stack.print();

	}

}
