package com.bridgeLabz.dataStructurePrograms;

public class Queues {

	private int length;
	private Node front;
	private Node end;

	/**
	 * constructor for the Queues class which initialize two variables.
	 * 
	 * @variable length it will fetch the length of the Stack
	 * @variable front it is the reference type variable which points to front.
	 * @variable end it is the reference type variable which points to end.
	 */
	public Queues() {
		this.length = 0;
		this.front = null;
		this.end = null;
	}

	/**
	 * it check the length of the Queues.
	 * 
	 * @return integer value.
	 */
	public int length() {
		return length;
	}

	/**
	 * it checks whether the Queues is empty or not .
	 * 
	 * @return boolean value.
	 */
	public boolean isEmpty() {
		if (length() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * if list is not empty then a temporary reference variable points to top of
	 * list. while loop iterate till the top points to null. while iterating it
	 * prints the data which is pointed by its reference variable. reference
	 * variable pointer is pointed to its next Node.
	 */
	public void print() {
		if (front == null) {
			System.out.println("Queues is Empty!");
		} else {
			Node current = front;
			while (current != null) {
				System.out.println(current.data);
				current = current.next;
			}
		}
	}

	public void enQueue(int data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			front = newNode;
		} else {
			end.next = newNode;
		}
		end = newNode;
		length++;
	}

}
