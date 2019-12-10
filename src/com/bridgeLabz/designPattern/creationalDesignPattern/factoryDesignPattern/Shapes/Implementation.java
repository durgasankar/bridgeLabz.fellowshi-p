package com.bridgeLabz.designPattern.creationalDesignPattern.factoryDesignPattern.Shapes;

/**
 * This class has the main implementation which calls the class and creates the
 * object which we want to create.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-09
 * @version 11.0.5
 */

public class Implementation {

	public static void main(String[] args) {
		ShapeFactory factory = new ShapeFactory();
		Shape circle = factory.getShape("circle");
		Shape rectangle = factory.getShape("rectangle");
		Shape square = factory.getShape("square");
		circle.print();
		rectangle.print();
		square.print();

	}

}
