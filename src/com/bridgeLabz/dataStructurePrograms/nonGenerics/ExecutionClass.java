package com.bridgeLabz.dataStructurePrograms.nonGenerics;

public class ExecutionClass {
	public static void main(String[] args) {

		Stack stack = new Stack();

		System.out.println("Stack Started...\n-------------\n");
		stack.push(50);
		stack.push(60);
		stack.push(70);
		stack.push(80);
		stack.push(90);
		stack.push(100);
		System.out.println("Stack Length : " + stack.length());
		stack.print();
		stack.pop();
		System.out.println("Length : " + stack.length());
		stack.print();
		System.out.println("Top points to => " + stack.peak());

		Queues queue = new Queues();

		System.out.println("\nQueues Started...\n--------------\n");
		queue.enQueue(10);
		queue.enQueue(20);
		queue.enQueue(30);
		queue.enQueue(40);
		queue.enQueue(50);
		queue.enQueue(60);
		System.out.println("Queue Length : " + queue.length());
		queue.print();
		queue.deQueue();
		System.out.println("Queue Length : " + queue.length());
		queue.print();
		System.out.println("First points to => " + queue.first());
		System.out.println("Last points to => " + queue.last());

		SinglyLinkedList linkedList = new SinglyLinkedList();

		System.out.println("\nLinkedList Started...\n--------------\nPlease Follow Zero Index\n");
		linkedList.insertAtStart(10);
		linkedList.insertAtStart(20);
		linkedList.insertAtStart(30);
		linkedList.print();
		System.out.println("LinkedList Length : " + linkedList.length());
		linkedList.insertAtLast(40);
		linkedList.insertAtLast(50);
		linkedList.insertAtLast(60);
		linkedList.print();
		linkedList.insertAtPosition(100, 0);
		System.out.println("LinkedList Length : " + linkedList.length());
		linkedList.insertAtPosition(200, 3);
		linkedList.print();
		System.out.println("LinkedList Length : " + linkedList.length());
		linkedList.deleteFirst();
		linkedList.deleteLast();
		linkedList.print();
		System.out.println("LinkedList Length : " + linkedList.length());
		linkedList.deleteFromPosition(6);
		linkedList.print();
		System.out.println("LinkedList Length : " + linkedList.length());
		System.out.println(linkedList.search(50));

	}

}
