package com.bridgeLabz.dataStructurePrograms.generics;

import java.util.NoSuchElementException;
import com.bridgeLabz.utility.Util;

/**
 * This class has some methods like print => to print the data. insertAtStart =>
 * to insert element at start. insert => to insert the element at last.
 * overloaded method insert => to insert the element at particular position.
 * deleteAtStart => to delete element at start. delete => to delete the element
 * at last. overloaded method delete => to delete the element at particular
 * position. search => to find whether the searching data is present or not in
 * the list getData => to get the data of the list printString => print the data
 * in string format. getIndex => to get the index of the searching data.
 * setDataFrom => set data at particular index. getDataFrom => get data from
 * particular index.
 * 
 * @author Durgasankar Mishra
 * @created 2019-11-23
 * @version 11.0.5
 * @param <G> generic type
 */
public class LinkedList<G> {
	private Node<G> head;
	private int length;

	public LinkedList() {
		this.length = 0;
		this.head = null;
	}

	/**
	 * it check the length of the List.
	 * 
	 * @return integer value.
	 */
	public int length() {
		return length;
	}

	/**
	 * it checks whether the List is empty or not .
	 * 
	 * @return boolean value.
	 */
	public boolean isEmpty() {
		return length == 0;
	}

	/**
	 * Fetch the data of the node.
	 * 
	 * @return <G> type data of list index.
	 */
	public G getData() {
		Node<G> current = head;
		return current.getData();
	}

	/**
	 * keeps on concatenating String value and at the end of the loop it returns the
	 * value in String format.
	 * 
	 * @return String value separated with comma.
	 */
	public String printString() {
		Node<G> current = head;
		String data = "";
		while (current != null) {
			data = data + current.data + ",";
			current = current.next;
		}
		return data;
	}

	/**
	 * if list is not empty then a temporary reference variable points to top of
	 * list. while loop iterate till temporary variable points to null. while
	 * iterating it prints the data which is pointed by its reference variable and
	 * pointer is shifted to next node.
	 */
	public void print() {
		Node<G> current = head;
		while (current != null) {
			System.out.print(current.data + " --> ");
			current = current.next;
		}
		System.out.println("null");
	}

	/**
	 * This method will print the data in particular file location .
	 * 
	 * @param storingLocation as input
	 */
	public void print(String storingLocation) {
		Node<G> current = head;
		while (current != null) {
			Util.writeToFile((String) current.data, storingLocation);
			current = current.next;
		}
		System.out.println("File updated successfully...");
	}

	/**
	 * It takes the generic data as input and creates a new Node and checks if list
	 * is empty or not, if not empty then newNode's reference is pointed by head and
	 * head points to newNode. After Successfully insertion length is incremented.
	 * 
	 * @param data of generic Class type as input.
	 * @returns boolean value.
	 */
	public boolean insertAtStart(G data) {
		Node<G> newNode = new Node<G>(data);
		if (isEmpty()) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		length++;
		return true;
	}

	/**
	 * It takes the generic data inputed by user and creates a new Node and checks
	 * if list is empty or not, if not empty then newNode's reference is pointed by
	 * lastNode and after Successfully insertion length is incremented.
	 * 
	 * @param data of generic Class type as input.
	 * @return boolean value.
	 */
	public boolean insert(G data) {
		Node<G> newNode = new Node<G>(data);
		if (isEmpty()) {
			head = newNode;
		} else {
			Node<G> current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
		length++;
		return true;
	}

	/**
	 * Accepts generic data type. NewNode object is created and traversed to get
	 * insertion position's next node address. Randomly created node's address
	 * points to position's next node address. previous points to the random node.
	 * After successfully insertion length is incremented.
	 * 
	 * @param data     data of generic Class type as input.
	 * @param position as position of insertion as Zero index Integer type.
	 * @return boolean value.
	 */
	public boolean insert(G data, int position) {
		Node<G> newNode = new Node<G>(data);
		// as this condition satisfies the insertion at beginning and zero position
		if (isEmpty() || position == 0) {
			insertAtStart(data);
			return true;
			// inserting at the position greater than length of the list and negative index
		} else if (position > length || position < 0) {
			System.out.println(
					"Insertion at position " + position + " is not possible..." + "\nlist length : " + length());
			return false;
			// inserting at the index position.
		} else {
			Node<G> current = head;
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
			return true;
		}
	}

	/**
	 * simply the head's next pointer is pointed to its next element and first node
	 * is garbage collected. After successfully deletion length is decremented.
	 * 
	 * @return <G> data
	 */
	public G deleteFirst() {
		Node<G> current = head;
		if (isEmpty()) {
			throw new NoSuchElementException("\nEmpty List! Deletion not possible...");
		} else {
			head = head.next;
			length--;
			return current.data;
		}

	}

	/**
	 * second last node is pointed to null by detaching from list and marked as last
	 * node. Last node is garbage collected. After successfully deletion length is
	 * decremented
	 * 
	 * @return <G> data.
	 */
	public G delete() {
		Node<G> current = head;
		if (isEmpty()) {
			throw new NoSuchElementException("\nEmpty List! Deletion not possible...");
		} else if (length == 1) {
			head = null;
			length--;
			return current.data;
		} else {

			while (current.next.next != null) {
				current = current.next;
			}
			G removedData = current.next.data;
			current.next = null;
			length--;
			return removedData;
		}

	}

	/**
	 * Traversed to get deletion position's next node address and previous node
	 * address. Previous node's address is pointed to next node address and current
	 * node is garbage collected. After successfully deletion length is decremented.
	 * 
	 * @param as position of deletion as Zero index Integer type.
	 * @return <G> data.
	 */
	public G delete(int position) {
		Node<G> current = head;
		// if deletion position is negative number and greater than list length.
		if (position < 0 || position >= length()) {
			throw new NoSuchElementException(
					"Deletion at position " + position + " is not possible..." + "\nlist length : " + length());
			// if position is last index.
		} else if (position == length - 1) {
			return delete();
			// if position is first index.
		} else if (position == 0) {
			return deleteFirst();
			// position is in required range.
		} else {
			Node<G> previous = null;
			for (int i = 0; i < position; i++) {
				previous = current;
				current = current.next;
			}
			G removedData = current.data;
			previous.next = current.next;
			length--;
			return removedData;
		}
	}

	/**
	 * Takes data of generic type as input and search the valid index position if
	 * found then delete the data based on index position.
	 * 
	 * @param data of generic Class type as input.
	 */
	public void deleteData(G data) {
		if (getIndex(data) < 0) {
			System.out.println("Opps! Data not found...");
		} else {
			delete(getIndex(data));
		}
	}

	/**
	 * Takes data of generic type and iterate in the loop checks all data if found
	 * it returns boolean value.
	 * 
	 * @param data of generic Class type as input.
	 * @return boolean value
	 */
	public boolean search(G data) {
		if (isEmpty()) {
			return false;
		} else {
			Node<G> current = head;
			while (current != null) {
				if (current.data.equals(data)) {
					return true;
				}
				current = current.next;
			}
		}
		return false;
	}

	/**
	 * It takes the generic data type as input and checks for index position if
	 * index position is found then it returns a positive index value else returns
	 * negative value.
	 * 
	 * @param data of generic Class type as input.
	 * @return index Number as integer value.
	 */
	public int getIndex(G data) {
		if (isEmpty()) {
			return -1;
		} else {
			int dataIndexPosition = 0;
			Node<G> current = head;
			while (current != null) {
				if (current.data.equals(data)) {
					return dataIndexPosition;
				}
				dataIndexPosition++;
				current = current.next;
			}
		}
		return -1;
	}

	/**
	 * takes index position as input and returns generic type data of that index.
	 * 
	 * @param index position as input parameter
	 * @return <G> type data
	 */
	public G getDataFromIndex(int index) {
		int counter = 0;
		G getData = null;
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			Node<G> current = head;
			while (current != null) {
				if (index == counter) {
					getData = current.data;
				}
				counter++;
				current = current.next;
			}
		}
		return getData;
	}

	/**
	 * takes data and index number as input parameter and set data at that index
	 * position.
	 * 
	 * @param data  as generic type input
	 * @param index position as input parameter
	 */
	public void setDataFrom(G data, int index) {
		G dataFromIndex = getDataFromIndex(index);
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			Node<G> current = head;
			while (current.next != null) {
				if (dataFromIndex == current.data) {
					current.data = data;
				}
				current = current.next;
			}
		}
	}

//	private <G extends Comparable<G>> void swap(LinkedList<G> list, int firstPos, int secondPos) {
//		G temp = list.getDataFromIndex(firstPos);
//		list.setDataFrom(list.getDataFromIndex(secondPos), firstPos);
//		list.setDataFrom(temp, secondPos);
//	}
//
//	public <G extends Comparable<G>> LinkedList<G> sortNumbers(LinkedList<G> list) {
//		for (int i = 0; i < list.length; i++) {
//			int minPos = -1;
//			G minValue = list.getDataFromIndex(i);
//			for (int j = i + 1; j < list.length() - 1; j++) {
//				G secondPosition = list.getDataFromIndex(j);
//				/**
//				 * works by returning an integer value that is either positive, negative, or
//				 * zero. It compares the object by making the call to the object that is the
//				 * argument. A negative number means that the object making the call is “less”
//				 * than the argument.
//				 */
//				if (minValue.compareTo(secondPosition) > 0) {
//					minPos = j;
//					minValue = list.getDataFromIndex(j);
//				}
//			}
//			/**
//			 * if minimum value returned is greater than 0 it swap the searching element
//			 * with minimum position.
//			 */
//			if (minPos >= 0) {
//				swap(list, i, minPos);
//			}
//		}
//		return list;
//
//	}
//

}
