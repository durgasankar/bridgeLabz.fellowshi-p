package com.bridgeLabz.dataStructurePrograms;

import com.bridgeLabz.dataStructurePrograms.nonGenerics.Tree;
import com.bridgeLabz.utility.Util;

/**
 * This class has a functionality of finding probability of binary tree by using
 * factorial function of Utility class. and all implementation methods of tree.
 * 
 * @author Durgasankar Mishra
 * @created 2019-11-29
 * @version 11.0.5
 */
public class BinarySearchTree {

	/**
	 * takes key as input parameter and finds the probability and returns integer
	 * value as probability
	 * 
	 * @param key as input parameter
	 * @return integer value
	 */
	public static int numberOfPossibilitiesOfbinaryTree(int key) {
		int possiblity = Util.factorial(2 * key) / (Util.factorial(key + 1) * Util.factorial(key));
		return possiblity;
	}

	public static void main(String[] args) {
		Tree binaryTree = new Tree();
		binaryTree.insert(50);
		binaryTree.insert(30);
		binaryTree.insert(20);
		binaryTree.insert(40);
		binaryTree.insert(70);
		binaryTree.insert(60);
		binaryTree.insert(80);

		System.out.println("Inorder traversal of the given tree");
		binaryTree.inorderDisplay();

		System.out.println("\nDelete 20");
		binaryTree.delete(20);
		System.out.println("Inorder traversal of the modified tree");
		binaryTree.inorderDisplay();

		System.out.println("\nDelete 30");
		binaryTree.delete(30);
		System.out.println("Inorder traversal of the modified tree");
		binaryTree.inorderDisplay();

		System.out.println("\nDelete 50");
		binaryTree.delete(50);
		System.out.println("Inorder traversal of the modified tree");
		binaryTree.inorderDisplay();

		System.out.println();
		System.out.println();
		System.out.print("Number of Possibilities : ");
		System.out.println(BinarySearchTree.numberOfPossibilitiesOfbinaryTree(3));

	}

}
