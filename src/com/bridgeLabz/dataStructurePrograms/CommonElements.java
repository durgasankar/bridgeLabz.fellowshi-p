package com.bridgeLabz.dataStructurePrograms;
/**
 * It has some common methods which is exetended in order to other classes.
 * @author Durgasankar Mishra
 * @created 2019-11-18
 * @version 11.05.0
 */
public class CommonElements {

	protected int length;

	/**
	 * it check the length of the stacks.
	 * 
	 * @return integer value.
	 */
	public int length() {
		return length;
	}

	/**
	 * it checks whether the stack is empty or not .
	 * 
	 * @return boolean value.
	 */
	public boolean isEmpty() {
		if (length() == 0) {
			return true;
		}
		return false;
	}

}
