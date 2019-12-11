package com.bridgeLabz.designPattern.behaviouralDesignPattern.visitor;

/**
 * Interface which has undefined function accept.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-11
 * @version 11.0.5
 */
public interface ItemElement {

	public int accept(ShoppingCartVisitor visitor);
}
