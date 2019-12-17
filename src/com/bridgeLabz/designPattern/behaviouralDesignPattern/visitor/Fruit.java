package com.bridgeLabz.designPattern.behaviouralDesignPattern.visitor;

/**
 * This class implements ItemElement interface and gets override method of
 * accept.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-11
 * @version 11.0.5
 */
public class Fruit implements ItemElement {

	private int pricePerKg;
	private int weight;
	private String name;

	public Fruit(int priceKg, int wt, String nm) {
		this.pricePerKg = priceKg;
		this.weight = wt;
		this.name = nm;
	}

	public int getPricePerKg() {
		return pricePerKg;
	}

	public int getWeight() {
		return weight;
	}

	public String getName() {
		return this.name;
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
