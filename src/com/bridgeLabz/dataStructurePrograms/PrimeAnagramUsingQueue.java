package com.bridgeLabz.dataStructurePrograms;

import com.bridgeLabz.dataStructurePrograms.generics.Queue;
import com.bridgeLabz.utility.Util;

/**
 * checks for prime for given range of inputs. if number is prime then checked
 * for anagram if both conditions satisfies then added to the queue and printed
 * the list.
 * 
 * @author Durgasankar Mishra
 * @created 2019-11-27
 * @version 11.0.5
 */
public class PrimeAnagramUsingQueue {
	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<Integer>();

		/**
		 * @code checking prime and adding them to queue list
		 */
		for (int i = 0; i <= 1000; i++) {
			if (Util.isPrime(i)) {
				queue.enQueue(i);
			}
		}

		/**
		 * @code store prime numbers from queue to array.
		 */
		int size = queue.size();
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = queue.deQueue();
		}
//		System.out.println(queue.size());
		/**
		 * @code prime Numbers that are anagram or not
		 */
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				if (Util.isAnagram(array[i], array[j]) && array[i] != 0 && array[j] != 0) {

					queue.enQueue(array[i]);
					queue.enQueue(array[j]);
				}
			}
		}
		System.out.println("All Numbers those are prime and anagram are :");
		queue.print();

	}

}
