package com.bridgeLabz.dataStructurePrograms.nonGenerics;

import java.util.NoSuchElementException;

/**
 * It is a linear data structure which is used to store data on the basis of
 * FIFO => First In First Out THis class has certain functions like length =>
 * length of the list isEmpty => which checks whether the list is empty or not.
 * enQueue => insert a data to the list. deQueue => used to remove the last
 * entered data from the list print => to get the list of data present. first =>
 * value of first element. last => value of last element present in the list.
 * 
 * @author Durgasankar Mishra
 * @version 11.0.5
 * @created 2019-11-18
 */

public class Queues extends CommonElements implements ICommon {

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
	 * Node class object is created and if the list is null then inserted node is
	 * first and last if list is not empty then last node's reference points to
	 * newNode. last points to the newNode as inserted from last. increment the
	 * length after successfully insertion.
	 * 
	 * @param data as a parameter and insert it at the end of the list
	 */
	public void enQueue(int data) {
		Node newNode = new Node(data);
		if (front == null) {
			front = newNode;
		} else {
			end.next = newNode;
		}
		end = newNode;
		length++;
	}

	/**
	 * if the list is empty then it throws exception. if not empty then front's
	 * reference is pointed to next element. the separated node is garbage
	 * collected. if only 1 node is present inside then after successfully removal
	 * front and end reference points to null. After successfully removal count is
	 * decremented.
	 * 
	 * @throws NoSuchElementException if the list is empty
	 * @return the data of the note which is removed from the list.
	 */
	public int deQueue() {
		int result;
		if (isEmpty()) {
			throw new NoSuchElementException("List is Empty");
		} else {
			result = front.data;
			front = front.next;
			if (front == null) {
				end = null;
			}
		}
		length--;
		return result;
	}

	/**
	 * @throws NoSuchElementException if the list is empty.
	 * @return the data of first element of the list
	 */
	public int first() {
		if (isEmpty()) {
			throw new NoSuchElementException("List is Empty");
		}
		return front.data;
	}

	/**
	 * @throws NoSuchElementException if the list is empty.
	 * @return the data of last element of the list
	 */
	public int last() {
		if (isEmpty()) {
			throw new NoSuchElementException("List is Empty");
		}
		return end.data;
	}

	/**
	 * if list is not empty then a temporary reference variable points to top of
	 * list. while loop iterate till the top points to null. while iterating it
	 * prints the data which is pointed by its reference variable. reference
	 * variable pointer is pointed to its next Node.
	 */
	@Override
	public void print() {
		if (front == null) {
			System.out.println("Stack is Empty!");
		} else {
			Node current = front;
			while (current != null) {
				System.out.print(current.data + " --> ");
				current = current.next;
			}
			System.out.println();
		}
	}

}
