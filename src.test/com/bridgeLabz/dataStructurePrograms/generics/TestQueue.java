package com.bridgeLabz.dataStructurePrograms.generics;

import static org.junit.Assert.*;
import java.util.NoSuchElementException;
import org.junit.Test;

public class TestQueue {
	Queue<Integer> queue = new Queue<Integer>();

	@Test
	public void test_Queue_emptyStatus() {
		assertTrue(queue.isEmpty());
	}

	@Test
	public void test_Queue_lengthWhenEmpty() {
		assertEquals(0, queue.size());
	}

	@Test
	public void test_Queue_lengthIsNotEmpty() {
		queue.enQueue(10);
		assertEquals(1, queue.size());
		assertFalse(queue.isEmpty());
	}

	@Test(expected = NoSuchElementException.class)
	public void tes_Queue_deQueue_whenEmpty() {
		assertEquals("Queue is empty...", queue.deQueue());
	}

	@Test
	public void test_Queue_deQueue_whenNotEmpty() {
		queue.enQueue(10);
		queue.enQueue(20);
		queue.enQueue(30);
		assertEquals(Integer.valueOf(10), queue.deQueue());
		assertEquals(Integer.valueOf(20), queue.deQueue());
		assertEquals(Integer.valueOf(30), queue.deQueue());
	}

	@Test
	public void test_Queue_first_whenNotEmpty() {
		queue.enQueue(10);
		queue.enQueue(20);
		queue.enQueue(30);
		assertEquals(Integer.valueOf(10), queue.first());

	}

	@Test
	public void test_Queue_last_whenNotEmpty() {
		queue.enQueue(10);
		queue.enQueue(20);
		queue.enQueue(30);
		assertEquals(Integer.valueOf(30), queue.last());
	}

}
