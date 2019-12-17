package com.bridgeLabz.dataStructurePrograms.generics;

import static org.junit.Assert.*;
import java.util.NoSuchElementException;
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

	@Test
	public void test_linkedList_insertAtStart_whenEmpty() {

		assertTrue(list.insertAtStart(10));
	}

	@Test
	public void test_linkedList_insertAtStart_whenNotEmpty() {
		list.insert(20);
		assertTrue(list.insertAtStart(10));
	}

	@Test
	public void test_linkedList_insertAtLast_whenEmpty() {

		assertTrue(list.insert(10));
	}

	@Test
	public void test_linkedList_insertAtLast_whenNotEmpty() {
		list.insert(20);
		assertTrue(list.insert(10));
	}

	@Test
	public void test_linkedList_insertAtValidPos_whenEmpty() {

		assertTrue(list.insert(10, 0));
	}

	@Test
	public void test_linkedList_insertAtValidPos_whenNotEmpty() {
		list.insert(20, 0);
		assertTrue(list.insert(10, 1));
	}

	@Test
	public void test_linkedList_insertAtInValidPos_whenEmpty() {
		assertEquals(0, list.length());
		assertTrue(list.insert(10, 1));
	}

	@Test
	public void test_linkedList_insertAtInValidPos_whenNotEmpty() {
		list.insert(20, 0);
		assertFalse(list.insert(10, 3));
	}

	@Test
	public void test_linkedList_insertAtInValidPos_negative_whenNotEmpty() {
		list.insert(20, 0);
		assertFalse(list.insert(10, -3));
	}

	@Test(expected = NoSuchElementException.class)
	public void test_linkedList_deleteFirst_whenEmpty() {
		assertEquals("Empty List! Deletion not possible...", list.deleteFirst());
	}

	@Test
	public void test_linkedList_deleteFirst_whenNotEmpty() {
		list.insert(10);
		list.insert(20);
		list.insert(30);
		assertEquals(Integer.valueOf(10), list.deleteFirst());
		assertEquals(Integer.valueOf(20), list.deleteFirst());
		assertEquals(Integer.valueOf(30), list.deleteFirst());
	}

	@Test
	public void test_linkedList_deleteLast_whenNotEmpty() {
		list.insert(10);
		list.insert(20);
		list.insert(30);
		assertEquals(Integer.valueOf(30), list.delete());
	}

	@Test
	public void test_linkedList_deleteFromStartPosition_whenNotEmpty() {
		list.insert(10);
		list.insert(20);
		list.insert(30);
		assertEquals(Integer.valueOf(10), list.delete(0));
	}

	@Test
	public void test_linkedList_deleteFromLastPosition_whenNotEmpty() {
		list.insert(10);
		list.insert(20);
		list.insert(30);
		assertEquals(Integer.valueOf(30), list.delete(2));
	}

	@Test
	public void test_linkedList_deleteFromAnyPosition_whenNotEmpty() {
		list.insert(10);
		list.insert(20);
		list.insert(30);
		list.insert(40);
		assertEquals(Integer.valueOf(30), list.delete(2));
	}

	@Test(expected = NoSuchElementException.class)
	public void test_linkedList_deletefromPos__whenEmpty() {
		assertEquals("Empty List! Deletion not possible...", list.delete(0));
	}

	@Test(expected = NoSuchElementException.class)
	public void test_linkedList_deletefromPos_invalid_whenEmpty() {
		assertEquals("Empty List! Deletion not possible...", list.delete(-3));
	}

	@Test
	public void test_linkedList_search_whenNotEmpty() {
		list.insert(10);
		list.insert(20);
		list.insert(30);
		list.insert(40);
		assertTrue(list.search(30));
	}

	@Test
	public void test_linkedList_search_dataNotPresesntInList_whenNotEmpty() {
		list.insert(10);
		list.insert(20);
		list.insert(30);
		list.insert(40);
		assertFalse(list.search(50));
	}

	@Test
	public void test_linkedList_search_whenEmpty() {
		assertFalse(list.search(50));
	}

	@Test
	public void test_linkedList_getIndex_dataNotPresentInList_whenNotEmpty() {
		list.insert(10);
		list.insert(20);
		list.insert(30);
		list.insert(40);
		assertEquals(-1, list.getIndex(50));
	}

	@Test
	public void test_linkedList_getIndex_dataPresntInList_whenNotEmpty() {
		list.insert(10);
		list.insert(20);
		list.insert(30);
		list.insert(40);
		assertEquals(2, list.getIndex(30));
	}

}
