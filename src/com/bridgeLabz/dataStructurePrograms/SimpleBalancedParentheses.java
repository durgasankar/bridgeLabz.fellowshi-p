package com.bridgeLabz.dataStructurePrograms;

import com.bridgeLabz.dataStructurePrograms.generics.Stack;

/**
 * Stack Class to push open parenthesis “(“ and pop closed   parenthesis “)”. At
 * the End of the Expression if the Stack is Empty then the     Arithmetic
 * Expression is Balanced. Stack Class Methods are Stack(), push(),pop(),
 * peak(), isEmpty(), size()
 * 
 * @author Durgasankar Mishra
 * @created 2019-11-25
 * @version 11.0.5
 */
public class SimpleBalancedParentheses {
	/**
	 * checks the parenthesis and does required actions(push/pop).
	 * 
	 * @param inputString to check whether the input is balanced or not.
	 * @return boolean value
	 */
	public static boolean isBalanced(String inputString) {
		Stack<Character> stack = new Stack<Character>();
		if (inputString.isEmpty()) {
			System.out.println("String is Empty!");
			return false;
		}
		for (int i = 0; i < inputString.length(); i++) {
			/**
			 * push open parenthesis '(' and pop closed parenthesis ')'. At the End of the
			 * Expression if the Stack is Empty then the Arithmetic Expression is Balanced.
			 */
			char checkChar = inputString.charAt(i);
			if (checkChar == '(')
				stack.push(inputString.charAt(i));
			else if (checkChar == ')')
				stack.pop();
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {

		String inputData = "(5+6)∗(7+8)/(4+3)(5+6)∗(7+8)/(4+3)";
		String result = (isBalanced(inputData)) ? "Balanced" : "Not Balanced";
		System.out.println("Input String : " + inputData);
		System.out.println("Status of inputString : " + result);

	}

}
