package com.bridgeLabz.designPattern.behaviouralDesignPattern.visitor;

/**
 * This class implements ItemElement interface and gets override method of
 * accept.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-11
 * @version 11.0.5
 */
public class Book implements ItemElement {

	private int price;
	private String isbnNumber;

	public Book(int price, String isbnNumber) {
		this.price = price;
		this.isbnNumber = isbnNumber;
	}

	public int getPrice() {
		return price;
	}

	public String getIsbnNumber() {
		return isbnNumber;
	}

	/**
	 * Override method takes Class type value as input parameter returns current
	 * object value of Class referred.
	 */
	@Override
	public int accept(ShoppingCartVisitor visitor) {
		return visitor.visit(this);
	}

}
