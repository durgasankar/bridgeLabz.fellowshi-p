package com.bridgeLabz.objectOrientedPrograms.inventoryManagement;

/**
 * This class has the basic functionality of name weight and price along with
 * getter and setter methods and to string method to print the data.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-05
 * @version 11.0.5
 */
public class Inventory {

	private String name;
	private int weight;
	private double price;

	/***
	 * This constructor assign the values during object creation.
	 * 
	 * @param name   as String input parameter.
	 * @param weight as integer input parameter.
	 * @param price  as double input parameter.
	 */
	public Inventory(String name, int weight, double price) {
		this.name = name;
		this.weight = weight;
		this.price = price;
	}

	/**
	 * Getter method which returns String data.
	 * 
	 * @return String data.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter method which sets the name by taking name as input parameter.
	 * 
	 * @param name as String type input parameter.
	 */
	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	/**
	 * Setter method which sets the weight by taking weight as input parameter.
	 * 
	 * @param name as Integer type input parameter.
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	public double getPrice() {
		return price;
	}

	/**
	 * Setter method which sets the price by taking price as input parameter.
	 * 
	 * @param name as Double type input parameter.
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Override method of toString which prints all the data of the class.
	 */
	@Override
	public String toString() {
		return "name=" + this.name + "\nweight=" + this.weight + "\nprice=" + this.price;
	}

	/**
	 * Takes the input parameter given in the method and returns new Object whenever
	 * we need to create a object.
	 * 
	 * @param name   as String type input parameter
	 * @param weight as integer type input parameter
	 * @param price  as double type input parameter
	 * @return New class type new object.
	 */
	public static Inventory createInventory(String name, int weight, double price) {
		return new Inventory(name, weight, price);
	}

}
