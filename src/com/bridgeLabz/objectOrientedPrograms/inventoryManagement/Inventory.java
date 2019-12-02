package com.bridgeLabz.objectOrientedPrograms.inventoryManagement;

public class Inventory {

	private String name;
	private int weight;
	private double price;

	public Inventory(String name, int weight, double price) {
		this.name = name;
		this.weight = weight;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "name=" + this.name + "\nweight=" + this.weight + "\nprice=" + this.price;
	}

	public static Inventory createInventory(String name, int weight, double price) {
		return new Inventory(name, weight, price);
	}

}
