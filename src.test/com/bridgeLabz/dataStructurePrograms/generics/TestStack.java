package com.bridgeLabz.dataStructurePrograms.generics;

import static org.junit.Assert.*;
import java.util.EmptyStackException;
import org.junit.Test;

public class TestStack {

	Stack<Integer> stack = new Stack<Integer>();

	@Test
	public void test_Stack_emptyStatus() {
		assertTrue(stack.isEmpty());
	}

	@Test
	public void test_Stack_lengthWhenEmpty() {
		assertEquals(0, stack.size());
	}

	@Test
	public void test_Stack_lengthIsNotEmpty() {
		stack.push(10);
		assertEquals(1, stack.size());
		assertFalse(stack.isEmpty());
	}

	@Test
	public void tes_stack_pop_whenNotEmpty() {
		stack.push(10);
		stack.push(20);
		stack.push(30);
		assertEquals(Integer.valueOf(30), stack.pop());
		assertEquals(Integer.valueOf(20), stack.pop());
		assertEquals(Integer.valueOf(10), stack.pop());
	}

	@Test
	public void tes_stack_peak_whenNotEmpty() {
		stack.push(10);
		stack.push(20);
		stack.push(30);
		assertEquals(Integer.valueOf(30), stack.peak());

	}

	@Test(expected = EmptyStackException.class)
	public void tes_stack_pop_whenEmpty() {
		assertEquals("Stack is empty...", stack.pop());
	}

}
