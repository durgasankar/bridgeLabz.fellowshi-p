package com.bridgeLabz.dataStructurePrograms.generics;

import java.util.NoSuchElementException;

/**
 * It is a linear data structure of generic Type which is used to store
 * data.This class has certain functions like size() => length of the list
 * isEmpty() => which checks whether the list is empty or not. addFront() =>
 * insert a data in the front position of list. addLast() => insert a data in
 * the last position of list. print => to get the list of data present.
 * deleteFront() => delete a data in the front position of list. deleteLast() =>
 * delete data in the last position of list.
 * 
 * @author Durgasankar Mishra
 * @version 11.0.5
 * @created 2019-11-26
 * @param <G> generic type
 */
public class Deque<G> {
	/**
	 * private inner class which initialize a new Node with next pointer and
	 * previous pointer and data set by the user at the time of object creation.
	 * 
	 * @author Durgasankar Mishra
	 *
	 * @param <G> generic type
	 */
	private static class Node<G> {
		private G data;
		private Node<G> next;
		private Node<G> prev;

		/**
		 * constructor initialize the variables during object creation.
		 * 
		 * @param data as data given by the user of
		 */
		public Node(G data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	private Node<G> front;
	private Node<G> rear;
	private int size;

	/**
	 * constructor which initialize the variables.
	 */
	public Deque() {
		this.front = null;
		this.size = 0;
		this.rear = null;
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
	 * if the Dequeue is empty it add the node at front which is referenced by both
	 * front and rear, else it add the randomly created node at front of the list.
	 * 
	 * @param data takes generic type data as input given by user.
	 */
	public void addFront(G data) {
		Node<G> newNode = new Node<G>(data);
		if (isEmpty()) {
			rear = newNode;
		} else {
			front.prev = newNode;
		}
		newNode.next = front;
		front = newNode;
		size++;
	}

	/**
	 * if Dequeue is empty it added node at front which is referenced by both front
	 * and rear, else it add at last.
	 * 
	 * @param takes generic type data as input given by user.
	 */
	public void addLast(G data) {
		Node<G> newNode = new Node<G>(data);
		if (isEmpty()) {
			front = newNode;
		} else {
			/**
			 * @code last node's next reference is pointed to newNode created at random and
			 *       newNode's previous variable points to last and new node is referenced
			 *       and added at last and after successful addition side is incremented.
			 */
			rear.next = newNode;
			newNode.prev = rear;
		}
		rear = newNode;
		size++;
	}

	/**
	 * if Dequeue is empty it throws exception, if only one node is present it
	 * removes it else remove the first node.
	 * 
	 * @return <G> value of Class type.
	 * @throws NoSuchElementException if list is empty.
	 */
	public G deleteFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException("\nEmpty Deque...");
		}
		Node<G> tempNode = front;
		if (front == rear) {
			rear = null;
		} else {
			// front's next node previous reference is pointed to null
			front.next.prev = null;
		}
		/**
		 * @code front is pointed to its next node and temporary node reference is
		 *       dereferenced and points to null. after removal size is decremented.
		 */
		front = front.next;
		tempNode.next = null;
		size--;
		return tempNode.data;
	}

	/**
	 * if Dequeue is empty it throws exception, if only one node is present it
	 * removes it else remove the last node.
	 * 
	 * @return <G> value of Class type.
	 * @throws NoSuchElementException if list is empty.
	 */
	public G deleteLast() {
		if (isEmpty()) {
			throw new NoSuchElementException("\nEmpty Deque...");
		}
		Node<G> tempNode = rear;
		if (front == rear) {
			front = null;
		} else {
			// rear's next node previous reference is pointed to null
			rear.prev.next = null;
		}
		/**
		 * @code end points to previous node and temporary node previous is dereferenced
		 *       and points to null. After removal size is decremented.
		 */
		rear = rear.prev;
		tempNode.prev = null;
		size--;
		return tempNode.data;
	}

	/**
	 * prints the data present in the list starting from first element.
	 */
	public void display() {
		Node<G> current = front;
		while (current != null) {
			System.out.print(current.data + " --> ");
			current = current.next;
		}
		System.out.println("null");
	}

}
