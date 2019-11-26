package com.bridgeLabz.dataStructurePrograms;

import com.bridgeLabz.dataStructurePrograms.generics.Deque;
import com.bridgeLabz.dataStructurePrograms.generics.LinkedList;

public class Execution {

	public static void main(String[] args) {
		System.out.println("Please Follow Zero index\n-------------------------");
		System.out.println("Integer\n" + "--------");
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.insertAtStart(10);
		list.insert(30);
		list.insert(40);
		list.insert(20, 1);
		list.insert(50, 3);
		list.insert(60);
		list.insert(70);
		list.insert(80);
		System.out.println("Index : " + list.getIndex(50));
		list.print();
		list.deleteData(50);

		list.print();
		System.out.println("Searching Element present : " + list.search(60));
		System.out.println("length = " + list.length());

		list.delete();
		list.delete(1);
		list.deleteFirst();

		list.print();
		System.out.println("length = " + list.length());

		System.out.println("\nString\n" + "-------");
		LinkedList<String> list2 = new LinkedList<String>();
		list2.insertAtStart("raja");
		list2.insert("ramesh");
		list2.insert("rakesh");
		list2.insert("suresh", 1);
		list2.insert("rama");
		list2.insert("sita");
		list2.insert("bharath", 4);
		list2.insertAtStart("durga");
		System.out.println("Searching Element present : " + list2.search("durga"));

		list2.print();
		list2.deleteData("rama");
		System.out.println("length = " + list2.length());

		list2.print();

		list2.delete();
		list2.delete(1);
		list2.deleteFirst();

		list2.print();
		System.out.println("length = " + list2.length());
		System.out.println("Searching Element present : " + list2.search("rama"));
		list2.deleteData("bharath");
		list2.print();

		Deque<Integer> deque = new Deque<Integer>();
		deque.addFront(20);
		deque.addFront(10);
		deque.addLast(30);
		deque.addLast(40);
		deque.display();
		
		deque.deleteFirst();
		deque.deleteLast();
		
		deque.display();

	}

}
