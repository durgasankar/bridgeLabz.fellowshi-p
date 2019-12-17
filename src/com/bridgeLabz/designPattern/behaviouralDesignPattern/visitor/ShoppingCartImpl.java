package com.bridgeLabz.designPattern.behaviouralDesignPattern.visitor;

/**
 * This has main implementation of the Class.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-11
 * @version 11.0.5
 */
public class ShoppingCartImpl {

	public static void main(String[] args) {
		ItemElement[] items = new ItemElement[] { new Book(20, "1024"), new Book(100, "2468"),
				new Fruit(10, 2, "Banana"), new Fruit(5, 5, "Apple") };

		int total = calculatePrice(items);
		System.out.println("Total Cost = " + total);
	}

	/**
	 * 
	 * @param items as String input parameter from array
	 * @return Integer value.
	 */
	private static int calculatePrice(ItemElement[] items) {
		ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
		int sum = 0;
		for (ItemElement item : items) {
			sum += item.accept(visitor);
		}
		return sum;
	}

}
