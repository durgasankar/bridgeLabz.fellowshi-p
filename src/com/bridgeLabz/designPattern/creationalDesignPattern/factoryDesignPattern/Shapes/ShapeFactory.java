package com.bridgeLabz.designPattern.creationalDesignPattern.factoryDesignPattern.Shapes;

/**
 * ShapeFactory class has a function named getShape when it is called it returns
 * the new Instance of that class which is being called.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-09
 * @version 11.0.5
 */

public class ShapeFactory {
	/**
	 * Takes String as class name type input parameter returns new object of that
	 * particular class whose name is passed through it.
	 * 
	 * @param shapeType as String input parameter
	 * @return Object of the class called.
	 */
	public Shape getShape(String shapeType) {
		if (shapeType == null) {
			return null;
		} else if (shapeType.equalsIgnoreCase("circle")) {
			return new Circle();
		} else if (shapeType.equalsIgnoreCase("rectangle")) {
			return new Rectangle();
		} else if (shapeType.equalsIgnoreCase("square")) {
			return new Square();
		} else {
			return null;
		}
	}

}
