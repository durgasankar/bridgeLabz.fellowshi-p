package com.bridgeLabz.dataStructurePrograms;

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
 * @created 2019-11-16
 */
public class Stack extends CommonElements implements Common {
	private Node top;

	/**
	 * constructor for the stack class which initialize two variables.
	 * 
	 * @variable length it will fetch the length of the Stack
	 * @variable top it is the reference type variable which points to top.
	 */
	public Stack() {
		this.length = 0;
		this.top = null;
	}

	/**
	 * Node class object is created and allocated memory with data given by user and
	 * its next points to null. objects reference variable points to top of the
	 * list. reference variable top points to the object reference. after successful
	 * insertion of the data to the list its length is incremented.
	 * 
	 * @param data as input given by the user.
	 */
	public void push(int data) {
		Node newNode = new Node(data);
		newNode.next = top;
		top = newNode;
		length++;
	}

	/**
	 * if the list is empty then it throws exception. if the list is not empty then
	 * list's top data is shifted to a variable . list top reference points to its
	 * next variable
	 * 
	 * @param removed is the integer type variable which holds the value of top.
	 * @throws if the stack list is empty it throws EmptyStackException.
	 * @return
	 */
	public int pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		int removed = top.data;
		top = top.next;
		length--;
		return removed;
	}

	/**
	 * if the list is not empty it will return the value which is pointed by top.
	 * 
	 * @return the data which is pointed by top
	 */
	public int peek() {
		if (!isEmpty()) {
			return top.data;
		} else {
			System.out.println("Stack is Empty!");
			return -1;
		}
	}

	/**
	 * if list is not empty then a temporary reference variable points to top of
	 * list. while loop iterate till the top points to null. while iterating it
	 * prints the data which is pointed by its reference variable. reference
	 * variable pointer is pointed to its next Node.
	 */
	@Override
	public void print() {
		if (top == null) {
			System.out.println("Stack is Empty!");
		} else {
			Node current = top;
			while (current != null) {
				System.out.print(current.data + " --> ");
				current = current.next;
			}
			System.out.println("null");
		}

	}

}
