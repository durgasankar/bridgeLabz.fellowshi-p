package com.bridgeLabz.dataStructurePrograms.nonGenerics;

/**
 * This class has a integer data type variable and a reference type variable.
 * 
 * @author Durgasankar Mishra
 * @created 2019-11-16
 * @version 11.05.0
 */
public class Node {
	protected int data;
	protected Node next;

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
