package com.bridgeLabz.objectOrientedPrograms.inventoryManagement;

import java.util.ArrayList;

/**
 * This class implements IInventoryCalculation Interface and performs basic
 * operation like adding to the inventory updating the inventory , removing from
 * inventory , searching data from inventory. Implemented methods like
 * calculating total price , total weight in the inventory and also prints all
 * the data present in the inventory.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-03
 * @version 11.0.5
 */
public class InventoryOperations implements IIneventryCalculation {
	private String inventoryName;
	protected ArrayList<Inventory> inventoryList;

	/**
	 * Constructor to initialize ArrayList and sets the inventory name which is
	 * passed through this.
	 * 
	 * @param name as input parameter
	 */
	public InventoryOperations(String name) {
		this.inventoryName = name;
		this.inventoryList = new ArrayList<Inventory>();
	}

	/**
	 * Getter method to get inventory name.
	 * 
	 * @return String value
	 */
	public String getInventoryName() {
		return inventoryName;
	}

	/**
	 * Setter method to set inventory name.
	 * 
	 * @param inventoryName as String input.
	 */
	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}

	/**
	 * Override method of IInventoryClaculation interface which display the total
	 * weight of the object present in Inventory.
	 * 
	 * @return Integer Value
	 */
	@Override
	public int calculateTotalWeight(ArrayList<Inventory> inventory) {
		int totalWeight = 0;
		for (int i = 0; i < inventory.size(); i++) {
			int individualWeight = inventory.get(i).getWeight();
			totalWeight += individualWeight;
		}
		return totalWeight;
	}

	/**
	 * Override method of IInventoryClaculation interface which display the total
	 * price of the object present in Inventory.
	 * 
	 * @return Double Value
	 */
	@Override
	public double calculateTotalPrice(ArrayList<Inventory> inventory) {
		double totalPrice = 0.0;
		for (int i = 0; i < inventory.size(); i++) {
			double individualPrice = inventory.get(i).getPrice();
			totalPrice += individualPrice;
		}
		return totalPrice;
	}

	/**
	 * Override method of IInventoryClaculation interface which display all the data
	 * present in Inventory in string format.
	 * 
	 * @return toString Value
	 */
	@Override
	public void displayInventory(ArrayList<Inventory> inventory) {
		for (int i = 0; i < inventory.size(); i++) {
			System.out.println(inventory.get(i).toString());
			System.out.println("------------------");
		}
	}

	/**
	 * Takes newItem of class type as input parameter and checks whether it is
	 * present or not in the inventory ArrayList. if not present then add it in the
	 * inventory else display with the proper message and finally returns boolean
	 * value.
	 * 
	 * @param newItem of Class type as input parameter
	 * @return Boolean value
	 */
	public boolean addNewItem(Inventory newItem) {
		if (findInInventory(newItem.getName()) >= 0) {
			System.out.println("Item already exist in the list.");
			return false;
		}
		inventoryList.add(newItem);
		return true;
	}

	/**
	 * Takes inventory whole class type item as input parameter and returns index
	 * position of inventory.
	 * 
	 * @param inventoryItem of Class type as input parameter
	 * @return Integer value
	 */
	private int findInInventory(Inventory inventoryItem) {
		return this.inventoryList.indexOf(inventoryItem);
	}

	/**
	 * if name matches with the Inventory object's name then returns index position
	 * of the object
	 * 
	 * @param name of String type as input parameter.
	 * @return Integer value
	 */
	private int findInInventory(String name) {
		for (int i = 0; i < inventoryList.size(); i++) {
			Inventory fetchedItem = this.inventoryList.get(i);
			if (fetchedItem.getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Takes product name as input parameter and from there it search for the index
	 * position by calling FinInInventory(), if index position is positive number it
	 * returns complete class from that position. else return null.
	 * 
	 * @param productName as input parameter of STring type
	 * @return Inventory Class type
	 */
	public Inventory searchInInventory(String productName) {
		int position = findInInventory(productName);
		if (position >= 0) {
			return this.inventoryList.get(position);
		}
		return null;
	}

	/**
	 * Takes newItem of class type as input parameter and checks whether it is
	 * present or not in the inventory ArrayList. if present then remove from the
	 * inventory else display with the proper message and finally returns boolean
	 * value.
	 * 
	 * @param itemName of class type as input parameter
	 * @return Boolean value.
	 */
	public boolean removeItem(Inventory itemName) {
		int foundPosition = findInInventory(itemName);
		if (foundPosition < 0) {
			System.out.println(itemName.getName() + " was not found.");
			return false;
		}
		this.inventoryList.remove(foundPosition);
		return true;
	}

	/**
	 * Takes newItem of class type as input parameter and checks whether it is
	 * present or not in the inventory ArrayList. If found then it set the newItem
	 * at that position else display with the proper error message and finally
	 * returns boolean value.
	 * 
	 * @param oldItem of class type as input parameter
	 * @param newItem of class type as input parameter
	 * @return Boolean value.
	 */
	public boolean updateInventory(Inventory oldItem, Inventory newItem) {
		int foundPosition = findInInventory(oldItem);
		if (foundPosition < 0) {
			System.out.println(oldItem.getName() + " was not found.");
			return false;
		}
		this.inventoryList.set(foundPosition, newItem);
		return true;
	}

	/**
	 * If the list is not empty then it iterate through complete list of items and
	 * finally display all elements present in the list in the form of toString
	 * method defined in Inventory class.
	 */
	public void printInventory() {
		if (inventoryList.isEmpty()) {
			System.out.println("Inventory is empty");
		}
		for (int i = 0; i < inventoryList.size(); i++) {
			System.out.println((i + 1) + inventoryList.get(i).toString());
		}
	}

}
