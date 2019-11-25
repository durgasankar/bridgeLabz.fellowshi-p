package com.bridgeLabz.dataStructurePrograms.generics;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestLinkedList {

	LinkedList<Integer> list = new LinkedList<Integer>();

	@Test
	public void test_linkedList_isEmpty_whenEmpty() {
		assertTrue(list.isEmpty());
	}

	@Test
	public void test_linkedList_isEmpty_whenNotEmpty() {
		list.insertAtStart(10);
		assertFalse(list.isEmpty());
	}
	
	@Test
	public void test_linkedList_length_whenEmpty() {
		assertEquals(0, list.length());
	}
	
	@Test
	public void test_linkedList_length_whenNotEmpty() {
		list.insertAtStart(10);
		assertEquals(1, list.length());
	}

}
