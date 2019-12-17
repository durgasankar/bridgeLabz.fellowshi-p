package com.bridgeLabz.dataStructurePrograms;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBalancedParenthesis {

	@Test
	public void test_balancedParenthesis_positiveInput() {
		assertTrue(SimpleBalancedParentheses.isBalanced("(5+6)∗(7+8)/(4+3)(5+6)∗(7+8)/(4+3)"));
	}

	@Test
	public void test_balancedParenthesis_negativeInput_removedLastBrackets() {
		assertFalse(SimpleBalancedParentheses.isBalanced("(5+6)∗(7+8)/(4+3)(5+6)∗(7+8)/(4+3"));
	}

	@Test
	public void test_balancedParenthesis_whenEmpty() {
		assertFalse(SimpleBalancedParentheses.isBalanced(""));
	}

	@Test
	public void test_balancedParenthesis_positiveInputs_withDifferentTypeBrackets() {
		assertTrue(SimpleBalancedParentheses.isBalanced("(5+6)∗(7+8)/(4+3)(5+6)∗(7+8)/{4+3}"));
	}

}
