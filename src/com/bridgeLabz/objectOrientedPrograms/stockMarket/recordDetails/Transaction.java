package com.bridgeLabz.objectOrientedPrograms.stockMarket.recordDetails;

import com.bridgeLabz.dataStructurePrograms.generics.LinkedList;
import com.bridgeLabz.dataStructurePrograms.generics.Queue;
import com.bridgeLabz.dataStructurePrograms.generics.Stack;
import com.bridgeLabz.objectOrientedPrograms.stockMarket.model.Share;

/**
 * This class keeps all the transaction records of share holder company and
 * share symbol transaction record.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-13
 * @version 11.0.5
 */
public class Transaction {

	public static Queue<String> transactionDateTime = new Queue<String>();

	public static Stack<String> transactionSymbol = new Stack<String>();
	
	public static LinkedList<Share> linkedListOperation = new LinkedList<Share>();

	/**
	 * prints the transaction details of the company and customer.
	 */
	public static void displayTimeRecord() {
		transactionDateTime.print();
	}
	/**
	 * print the transaction symbol of the company of on going transaction.
	 */
	public static void displaySymbolRecord() {
		transactionSymbol.print();
	}
	/**
	 * print the symbol of company listed with the stock market.
	 */
	public static void displayCompanyNames() {
		for(int i = 0; i < linkedListOperation.length(); i++) {
			Share getIndex = linkedListOperation.getDataFromIndex(i);
			System.out.println(i+1 +". Name : " + getIndex.getName() + ", Symbol : " + getIndex.getSymbol());
		}
	}
}
