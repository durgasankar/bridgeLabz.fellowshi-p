package com.bridgeLabz.dataStructurePrograms.nonGenerics;

/**
 * Binary Tree is a non linear data structure without having cycle where each
 * node can points to two different nodes. It has some functions like =>
 * insert() which insert the data to the tree, => delete() which deletes the
 * data provided by user for deletion operation, => inorderDisplay() which
 * prints the values of the list.
 * 
 * @author Durgasankar Mishra
 * @created 2019-11-29
 * @version 11.0.5
 */
public class Tree {
	private Node root;

	/**
	 * constructor to initialize the root.
	 */
	public Tree() {
		this.root = null;
	}

	/**
	 * Inner node class which bears the data and reference of two child class type.
	 * 
	 * @author Durgasankar Mishra
	 * @created 2019-11-29
	 */
	private class Node {
		private int data;
		private Node leftChild;
		private Node rightChild;

		/**
		 * constructor to initialize the class.
		 * 
		 * @param data as parameter which needed to be inserted.
		 */
		public Node(int data) {
			this.data = data;
			this.leftChild = null;
			this.rightChild = null;
		}
	}

	/**
	 * if root is empty then it add the data and ,mark as root. else it traverse to
	 * Particular position where the data is needs to be iinserted and then insert
	 * at that position.
	 * 
	 * @param data as input parameter where data needs to be inserted.
	 */
	public void insert(int data) {
		Node newNode = new Node(data);
		if (root == null) {
			root = newNode;
		} else {
			traverseToAdd(root, newNode);
		}
	}

	/**
	 * it compares top node data with the data which is needed to be inserted if
	 * input data is greater that root data then it is inserted as right side else
	 * it will inserted at left branch of tree. this method is recursively called
	 * Until null is found . then current points to the newly assigned node.
	 * 
	 * @param current as initial node from where traversing will start.
	 * @param newNode as parameter which will be inserted.
	 */
	private void traverseToAdd(Node current, Node newNode) {
		if (newNode.data < current.data) {
			if (current.leftChild == null) {
				current.leftChild = newNode;
			} else {
				traverseToAdd(current.leftChild, newNode);
			}
		} else if (newNode.data > current.data) {
			if (current.rightChild == null) {
				current.rightChild = newNode;
			} else {
				traverseToAdd(current.rightChild, newNode);
			}
		}
	}

	/**
	 * calls the function of deleteAtNode and after successful execution. data is
	 * deleted.
	 * 
	 * @param data to be deleted as input parameter.
	 */
	public void delete(int data) {
		root = deleteAtNode(root, data);
	}

	/**
	 * if the root is empty it prints the data else it recursively calls the
	 * function unless it reach null. if data is less than root data then it calls
	 * left child else it calls right child unless it read all data and find to the
	 * Particular data it want to delete.
	 * 
	 * @param root takes root node as input parameter
	 * @param data which is need to be deleted as input parameter
	 * @return Node class type data
	 */
	private Node deleteAtNode(Node root, int data) {
		if (root == null)
			return root;
		if (data < root.data)
			root.leftChild = deleteAtNode(root.leftChild, data);
		else if (data > root.data)
			root.rightChild = deleteAtNode(root.rightChild, data);
		else {
			if (root.leftChild == null)
				return root.rightChild;
			else if (root.rightChild == null)
				return root.leftChild;
			/**
			 * it calls minValue function and get the minValue of root then this root value
			 * is passed in the recursive function and node address of right child is
			 * fetched.
			 */
			root.data = minValue(root.rightChild);
			root.rightChild = deleteAtNode(root.rightChild, root.data);
		}
		return root;
	}

	/**
	 * it fetch the minimum value from left child and returns it.
	 * 
	 * @param root as class type reference as input parameter.
	 * @return Integer value
	 */
	private int minValue(Node root) {
		int min = root.data;
		while (root.leftChild != null) {
			min = root.leftChild.data;
			root = root.leftChild;
		}
		return min;
	}

	/**
	 * it calls the function inOrderRecurssion and prints the values.
	 */
	public void inorderDisplay() {
		inorderRecurssion(root);
	}

	/**
	 * takes root address as input parameter and recursively calls the function
	 * unless it find root as null. if it find root as null then it prints the data.
	 * 
	 * @param root address as input parameter.
	 */
	private void inorderRecurssion(Node root) {
		if (root != null) {
			inorderRecurssion(root.leftChild);
			System.out.print(root.data + " ");
			inorderRecurssion(root.rightChild);
		}
	}

}
