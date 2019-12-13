package com.bridgeLabz.objectOrientedPrograms.stockMarket.recordDetails;

import com.bridgeLabz.dataStructurePrograms.generics.Queue;

/**
 * This class keeps all the transaction records of share holder company
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-13
 * @version 11.0.5
 */
public class Transaction {

	public static Queue<String> transaction = new Queue<String>();

	/**
	 * prints the transaction details of the company and customer.
	 */
	public static void display() {
		transaction.print();
	}
}
