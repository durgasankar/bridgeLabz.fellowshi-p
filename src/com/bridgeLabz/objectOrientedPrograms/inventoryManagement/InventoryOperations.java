package com.bridgeLabz.objectOrientedPrograms.inventoryManagement;

import java.util.ArrayList;

public class InventoryOperations implements IIneventryCalculation {
	private String inventoryName;
	protected ArrayList<Inventory> inventoryList;

	public InventoryOperations(String name) {
		this.inventoryName = name;
		this.inventoryList = new ArrayList<Inventory>();
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
		inventoryList.add(newItem);
		return true;
	}

	private int findInInventory(Inventory inventoryItem) {
		return this.inventoryList.indexOf(inventoryItem);
	}

	private int findInInventory(String name) {
		for (int i = 0; i < inventoryList.size(); i++) {
			Inventory fetchedItem = this.inventoryList.get(i);
			if (fetchedItem.getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}

	public Inventory searchInInventory(String productName) {
		int position = findInInventory(productName);
		if (position >= 0) {
			return this.inventoryList.get(position);
		}
		return null;
	}

	public boolean removeItem(Inventory itemName) {
		int foundPosition = findInInventory(itemName);
		if (foundPosition < 0) {
			System.out.println(itemName.getName() + " was not found.");
			return false;
		}
		this.inventoryList.remove(foundPosition);
		return true;
	}

	public boolean updateInventory(Inventory oldItem, Inventory newItem) {
		int foundPosition = findInInventory(oldItem);
		if (foundPosition < 0) {
			System.out.println(oldItem.getName() + " was not found.");
			return false;
		}
		this.inventoryList.set(foundPosition, newItem);
		return true;
	}

	public void printInventory() {
		if (inventoryList.isEmpty()) {
			System.out.println("Inventory is empty");
		}
		for (int i = 0; i < inventoryList.size(); i++) {
			System.out.println((i + 1) + inventoryList.get(i).toString());
		}
	}

}
