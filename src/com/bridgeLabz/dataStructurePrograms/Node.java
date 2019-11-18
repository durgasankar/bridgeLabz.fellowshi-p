package com.bridgeLabz.dataStructurePrograms;

/**
 * This class has a integer data type variable and a reference type variable.
 * 
 * @author Durgasankar Mishra
 * @created 2019-11-16
 * @version 1.0
 */
public class Node {
	int data;
	Node next;

	/**
	 * constructor to initialize the class variables during object creation.
	 * 
	 * @param data is passed as a parameter to the constructor.
	 */
	public Node(int data) {
		this.data = data;
		this.next = null;
	}

}
