package com.bridgeLabz.objectOrientedPrograms.inventoryManagement;

import java.util.ArrayList;

public class InventoryOperations implements IIneventryCalculation {
	private String inventoryName;
	private ArrayList<Inventory> inventory;

	public InventoryOperations(String name) {
		this.inventoryName = name;
		this.inventory = new ArrayList<Inventory>();
	}

	public String getInventoryName() {
		return inventoryName;
	}

	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}

	@Override
	public int calculateTotalWeight(ArrayList<Inventory> inventory) {
		int totalWeight = 0;
		for (int i = 0; i < inventory.size(); i++) {
			int individualWeight = inventory.get(i).getWeight();
			totalWeight += individualWeight;
		}
		return totalWeight;
	}

	@Override
	public double calculateTotalPrice(ArrayList<Inventory> inventory) {
		double totalPrice = 0.0;
		for (int i = 0; i < inventory.size(); i++) {
			double individualPrice = inventory.get(i).getPrice();
			totalPrice += individualPrice;
		}
		return totalPrice;
	}

	@Override
	public void displayInventory(ArrayList<Inventory> inventory) {
		for (int i = 0; i < inventory.size(); i++) {
			System.out.println((i + 1) + " . " + inventory.get(i).toString());
		}
	}

	public boolean addNewItem(Inventory newItem) {
		if (findInInventory(newItem.getName()) >= 0) {
			System.out.println("Item already exist in the list.");
			return false;
		}
		inventory.add(newItem);
		return true;
	}

	private int findInInventory(Inventory inventoryItem) {
		return this.inventory.indexOf(inventoryItem);
	}

	private int findInInventory(String name) {
		for (int i = 0; i < inventory.size(); i++) {
			Inventory fetchedItem = this.inventory.get(i);
			if (fetchedItem.getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}

	public boolean removeItem(Inventory itemName) {
		int foundPosition = findInInventory(itemName);
		if (foundPosition < 0) {
			System.out.println(itemName.getName() + " was not found.");
			return false;
		}
		this.inventory.remove(foundPosition);
		System.out.println(itemName.getName() + " was sucessfully removed.");
		return true;
	}

	public boolean updateInventory(Inventory oldItem, Inventory newItem) {
		int foundPosition = findInInventory(oldItem);
		if (foundPosition < 0) {
			System.out.println(oldItem.getName() + " was not found.");
			return false;
		}
		this.inventory.set(foundPosition, newItem);
		System.out.println(newItem.getName() + " updated successfully.");
		return true;
	}
	
	

}
