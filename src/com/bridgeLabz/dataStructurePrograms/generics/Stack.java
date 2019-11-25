package com.bridgeLabz.dataStructurePrograms.generics;

import java.util.EmptyStackException;

/**
 * It is a linear data structure which is used to store data on the basis of
 * LIFO => Last In First Out THis class has certain functions like length =>
 * length of the list isEmpty => which checks whether the list is empty or not.
 * push => insert a data to the list. pop => used to remove the last entered
 * data from the list. peek => check the data entered at last. print => to get
 * the list of all the data present in the list.
 * 
 * @author Durgasankar Mishra
 * @version 11.0.5
 * @created 2019-11-25
 */
public class Stack<G> {
	private Node<G> top;
	private int size;

	/**
	 * constructor for the stack class which initialize top and size.
	 * 
	 * @variable length it will fetch the length of the Stack
	 * @variable top it is the reference type variable which points to top.
	 */
	public Stack() {
		this.top = null;
		this.size = 0;
	}

	/**
	 * checks whether the list is empty.
	 * 
	 * @return boolean value
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * return the list size.
	 * 
	 * @return integer value.
	 */
	public int size() {
		return size;
	}

	/**
	 * Node class object is created and allocated memory with data given by user and
	 * its next points to null. objects reference variable points to top of the
	 * list. reference variable top points to the object reference. after successful
	 * insertion of the data to the list its length is incremented.
	 * 
	 * @param of generic type as input data
	 */
	public void push(G data) {
		Node<G> newNode = new Node<G>(data);
		newNode.next = top;
		top = newNode;
		size++;
	}

	/**
	 * if the list is empty then it throws exception. if the list is not empty then
	 * list's top data is shifted to a variable . list top reference points to its
	 * next variable
	 * 
	 * @throws if the stack list is empty it throws EmptyStackException.
	 * @return data of generic type.
	 */
	public G pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		} else {
			G removed = top.data;
			top = top.next;
			size--;
			return removed;
		}
	}

	/**
	 * if the list is not empty it will return the value which is pointed by top.
	 * 
	 * @return the data of generic type
	 */
	public G peak(G data) {
		if (!isEmpty()) {
			return top.data;
		} else {
			throw new EmptyStackException();
		}
	}

	/**
	 * if stack is not empty then a temporary reference variable points to top of
	 * list. while loop iterate till the top points to null. while iterating it
	 * prints the data which is pointed by its reference variable. reference
	 * variable pointer is pointed to its next Node.
	 */
	public void print() {
		if (isEmpty()) {
			System.out.println("Empty Stack!");
		} else {
			Node<G> current = top;
			while (current != null) {
				System.out.print(current.data + " --> ");
				current = current.next;
			}
			System.out.println("null");
		}
	}

}
