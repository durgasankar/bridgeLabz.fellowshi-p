package com.bridgeLabz.designPattern.behaviouralDesignPattern.visitor;

/**
 * Interface which has the unimplemented method visit of different parameter.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-11
 * @version 11.0.5
 */
public interface ShoppingCartVisitor {

	int visit(Book book);

	int visit(Fruit fruit);
}
