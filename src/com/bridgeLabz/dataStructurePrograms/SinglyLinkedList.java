package com.bridgeLabz.dataStructurePrograms;

/**
 * This class extends common elements class to override print method and
 * implements interface to get print method and this class has some method's
 * like insertAtStart => to insert element at start. insertAtLast => to insert
 * the element at last. insertAtPosition => to insert the element at particular
 * position. deleteAtStart => to delete element at start. deleteAtLast => to
 * delete the element at last. deleteAtPosition => to delete the element at
 * particular position. search => to find whether the searching data is present
 * or not in the list
 * 
 * @author Durgasankar Mishra
 * @created 2019-11-18
 * @version 11.05.0
 *
 */

public class SinglyLinkedList extends CommonElements implements Common {

	private Node head;

	/**
	 * if list is not empty then a temporary reference variable points to top of
	 * list. while loop iterate till the top points to null. while iterating it
	 * prints the data which is pointed by its reference variable. reference
	 * variable pointer is pointed to its next Node.
	 */
	@Override
	public void print() {
		if (head == null) {
			System.out.println("List is Empty!");
		} else {
			Node current = head;
			while (current != null) {
				System.out.print(current.data + " --> ");
				current = current.next;
			}
			System.out.println("null");
		}

	}

	/**
	 * It takes the data inputed by user and creates a new Node and checks if list
	 * is empty or not, if not empty then newNode's reference is pointed by head and
	 * head points to newNode. After Successfully insertion length is incremented.
	 * 
	 * @param data as parameter to be inserted.
	 */
	public void insertAtStart(int data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		length++;
	}

	/**
	 * It takes the data inputed by user and creates a new Node and checks if list
	 * is empty or not, if not empty then newNode's reference is pointed by lastNode
	 * and after Successfully insertion length is incremented.
	 * 
	 * @param data as parameter to be inserted.
	 */

	public void insertAtLast(int data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			head = newNode;
		} else {
			Node current = head;
			/**
			 * this loop iterate till last and fetch the last node address
			 */
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
			length++;
		}
	}

	/**
	 * New node object is created and traversed to get insertion position's next
	 * node address. Randomly created node's address points to position's next node
	 * address. previous points to the random node. After successfully insertion
	 * length is incremented.
	 * 
	 * @param data     as a parameter given by the user to be inserted
	 * @param position as a parameter where the data is to be inserted.
	 */
	public void insertAtPosition(int data, int position) {
		Node newNode = new Node(data);
		if (position == 0) {
			// as this condition satisfies the insertion at beginning.
			insertAtStart(data);
		} else if (position >= length()) {
			// inserting at the position greater than length of the list.
			System.out.println("Insertion at position " + position + " is not possible...");
		} else if (position < 0) {
			// inserting at negative index of the list.
			System.out.println("Invalid position!");
		} else if (position == length() - 1) {
			// inserting at the position equals with the list length
			insertAtLast(data);
		} else {
			Node current = head;
			/**
			 * This loop iterate till the position given by user and it follows zero index.
			 * it fetch the address of next position's next node.
			 */
			for (int i = 0; i < position - 1; i++) {
				current = current.next;
			}
			newNode.next = current.next;
			current.next = newNode;
			length++;
		}
	}

	/**
	 * simply the head's next pointer is pointed to its next element and first node
	 * is garbage collected. After successfully deletion length is decremented.
	 */
	public void deleteFirst() {
		if (isEmpty()) {
			System.out.println("Deletion not possible...");
		} else {
			head = head.next;
			length--;
		}
	}

	/**
	 * second last node is pointed to null by detaching from list and marked as last
	 * node. Last node is garbage collected. After successfully deletion length is
	 * decremented
	 */
	public void deleteLast() {
		if (isEmpty()) {
			// checks if the list is empty.
			System.out.println("Deletion not possible...");
		} else if (length() == 1) {
			// checks if the list has only one node
			head = null;
			length--;
		} else {
			Node current = head;
			/**
			 * loop is traversed till the end of the list and second last node address is
			 * collected and pointed by current.
			 */
			while (current.next.next != null) {
				current = current.next;
			}
			current.next = null;
			length--;
		}
	}

	/**
	 * Traversed to get deletion position's next node address and previous node
	 * address. Previous node's address is pointed to next node address and current
	 * node is garbage collected. After successfully deletion length is decremented.
	 * 
	 * @param position as a parameter where the data is to be deleted.
	 */

	public void deleteFromPosition(int position) {
		if (position < 0) {
			// deleting at negative index of the list.
			System.out.println("Invalid position...");
		} else if (position == 0) {
			// as this condition satisfies the deletion at beginning.
			deleteFirst();
		} else if (position == length() - 1) {
			// inserting at the position equals with the list length
			deleteLast();
		} else if (position >= length()) {
			// inserting at the position greater than length of the list.
			System.out.println("Deletion at position " + position + " is not possible...");
		} else {
			Node current = head;
			Node previous = head;
			/**
			 * This loop iterate till the position given by user and it follows zero index.
			 * it fetch the address of position's next node and previous node.
			 */
			for (int i = 0; i < position; i++) {
				previous = current;
				current = current.next;
			}
			previous.next = current.next;
			length--;
		}
	}

	/**
	 * checks whether the data is present in the list.
	 * 
	 * @param inputData as parameter to be searched in the list
	 * @return boolean value if present in the list.
	 */
	public boolean search(int inputData) {
		Node current = head;
		/**
		 * loop is traversed till the end of the list.if searching data matches with the
		 * list data it returns boolean value
		 */
		while (current != null) {
			if (current.data == inputData) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

}
