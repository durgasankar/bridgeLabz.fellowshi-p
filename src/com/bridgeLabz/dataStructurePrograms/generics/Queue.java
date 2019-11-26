package com.bridgeLabz.dataStructurePrograms.generics;

import java.util.NoSuchElementException;

/**
 * It is a linear data structure of generic Type which is used to store data on
 * the basis of FIFO => First In First Out THis class has certain functions like
 * size => length of the list isEmpty => which checks whether the list is empty
 * or not. enQueue => insert a data to the list. deQueue => used to remove the
 * last entered data from the list print => to get the list of data present.
 * first => value of first element. last => value of last element present in the
 * list.
 * 
 * @author Durgasankar Mishra
 * @version 11.0.5
 * @created 2019-11-26
 * @param <G> generic type
 */
public class Queue<G> {
	private Node<G> front;
	private Node<G> end;
	private int size;

	/**
	 * constructor for the Queue class which initialize front, end and size.
	 * 
	 * @variable size -> length of the Stack
	 * @variable front it is the reference type variable which points to front.
	 * @variable end it is the reference type variable which points to end.
	 */
	public Queue() {
		this.front = null;
		this.end = null;
		this.size = 0;
	}

	/**
	 * when size of list is 0 it returns boolean value.
	 * 
	 * @return Boolean value
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * It returns the size of the Queue.
	 * 
	 * @return Integer value
	 */
	public int size() {
		return size;
	}

	/**
	 * Node class object is created and if the list is null then inserted node is
	 * first and last if list is not empty then last node's reference points to
	 * newNode. last points to the newNode as inserted from last. increment the
	 * length after successfully insertion.
	 * 
	 * @param data of <G> type as input
	 */
	public void enQueue(G data) {
		Node<G> newNode = new Node<G>(data);
		if (front == null) {
			front = newNode;
		} else {
			end.next = newNode;
		}
		end = newNode;
		size++;
	}

	/**
	 * if the list is empty then it throws exception. if not empty then front's
	 * reference is pointed to next element. the separated node is garbage
	 * collected. if only 1 node is present inside then after successfully removal
	 * front and end reference -> null and count is decremented.
	 * 
	 * @return generic Class type value.
	 */
	public G deQueue() {
		G deQueueData;
		if (isEmpty()) {
			throw new NoSuchElementException("\nQueue is empty...");
		} else {
			deQueueData = front.data;
			front = front.next;
			if (front == null) {
				end = null;
			}
			size--;
			return deQueueData;
		}
	}

	/**
	 * it returns first inserted data of the list.
	 * 
	 * @throws NoSuchElementException if the list is empty.
	 * @return data of <G> type as input
	 */
	public G first() {
		if (isEmpty()) {
			throw new NoSuchElementException("\nQueue is empty...");
		}
		return front.data;
	}

	/**
	 * it returns last inserted data of the list.
	 * 
	 * @throws NoSuchElementException if the list is empty.
	 * @return data of <G> type as input
	 */
	public G last() {
		if (isEmpty()) {
			throw new NoSuchElementException("\nQueue is empty...");
		}
		return end.data;
	}

	public void print() {
		if (isEmpty()) {
			System.out.println("Empty List...");
		} else {
			Node<G> current = front;
			while (current != null) {
				System.out.print(current.data + " --> ");
				current = current.next;
			}
			System.out.println();
		}
	}

	/**
	 * if the list is not empty it will return the value which is pointed by top.
	 * 
	 * @return the data of generic type
	 */
	public G peak() {
		if (!isEmpty()) {
			return front.data;
		} else {
			throw new NoSuchElementException();
		}
	}

}
