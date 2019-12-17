package com.bridgeLabz.dataStructurePrograms.generics;

import static org.junit.Assert.*;
import java.util.NoSuchElementException;
import org.junit.Test;

public class TestDeque {
	Deque<Integer> deque = new Deque<Integer>();

	@Test
	public void test_deque_emptyStatus() {
		assertTrue(deque.isEmpty());
	}

	@Test
	public void test_deque_lengthWhenEmpty() {
		assertEquals(0, deque.size());
	}

	@Test
	public void test_deque_lengthIsNotEmpty() {
		deque.addFront(10);
		assertEquals(1, deque.size());
		assertFalse(deque.isEmpty());
	}

	@Test
	public void test_deque_addFront_deleteFront_whenNotEmpty() {
		deque.addFront(10);
		deque.addFront(20);
		deque.addFront(30);
		assertEquals(Integer.valueOf(30), deque.deleteFirst());
		assertEquals(Integer.valueOf(20), deque.deleteFirst());
		assertEquals(Integer.valueOf(10), deque.deleteFirst());
	}
	
	@Test
	public void test_deque_addFront_deleteLast_whenNotEmpty() {
		deque.addFront(10);
		deque.addFront(20);
		deque.addFront(30);
		assertEquals(Integer.valueOf(10), deque.deleteLast());
		assertEquals(Integer.valueOf(20), deque.deleteLast());
		assertEquals(Integer.valueOf(30), deque.deleteLast());
	}
	
	@Test
	public void test_deque_addLast_deleteFirst_whenNotEmpty() {
		deque.addLast(10);
		deque.addLast(20);
		deque.addLast(30);
		assertEquals(Integer.valueOf(10), deque.deleteFirst());
		assertEquals(Integer.valueOf(20), deque.deleteFirst());
		assertEquals(Integer.valueOf(30), deque.deleteFirst());
	}
	
	@Test
	public void test_deque_addLast_deleteLast_whenNotEmpty() {
		deque.addLast(10);
		deque.addLast(20);
		deque.addLast(30);
		assertEquals(Integer.valueOf(30), deque.deleteLast());
		assertEquals(Integer.valueOf(20), deque.deleteLast());
		assertEquals(Integer.valueOf(10), deque.deleteLast());
		assertEquals(0, deque.size());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void tes_queue_deleteLast_whenEmpty_expectedException() {
		assertEquals("Empty Deque", deque.deleteLast());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void tes_queue_deleteFirst_whenEmpty_expectedException() {
		assertEquals("Empty Deque", deque.deleteFirst());
	}

}
