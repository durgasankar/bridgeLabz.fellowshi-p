package com.bridgeLabz.objectOrientedPrograms.inventoryManagement.operation;

import java.util.ArrayList;

import com.bridgeLabz.objectOrientedPrograms.inventoryManagement.model.Inventory;
import com.bridgeLabz.objectOrientedPrograms.inventoryManagement.service.IOperation;
import com.bridgeLabz.utility.UtilJson;

/**
 * This class implements IInventoryCalculation Interface and performs basic
 * operation like adding to the inventory updating the inventory , removing from
 * inventory , searching data from inventory. Implemented methods like
 * calculating total price , total weight in the inventory and also prints all
 * the data present in the inventory.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-03
 * @modified 2019-12-13
 * @updated -> addition of Interface and making arrayList private.
 * @version 11.0.5
 */
public class InventoryOperations implements IOperation {
	private static ArrayList<Inventory> inventoryList;

	/**
	 * Constructor to initialize ArrayList and sets the inventory name which is
	 * passed through this.
	 */
	public InventoryOperations() {
		inventoryList = new ArrayList<Inventory>();
	}

	/**
	 * Getter method which returns arrayList.
	 * 
	 * @return ArrayList
	 */
	public static ArrayList<Inventory> getInventoryList() {
		return inventoryList;
	}

	/**
	 * Takes newItem of class type as input parameter and checks whether it is
	 * present or not in the inventory ArrayList. if not present then add it in the
	 * inventory else display with the proper message and finally returns boolean
	 * value.
	 */
	@Override
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
		return inventoryList.indexOf(inventoryItem);
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
			Inventory fetchedItem = inventoryList.get(i);
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
	 */
	@Override
	public Inventory searchInInventory(String productName) {
		int position = findInInventory(productName);
		if (position >= 0) {
			return inventoryList.get(position);
		}
		return null;
	}

	/**
	 * Takes newItem of class type as input parameter and checks whether it is
	 * present or not in the inventory ArrayList. if present then remove from the
	 * inventory else display with the proper message and finally returns boolean
	 * value.
	 */
	@Override
	public boolean removeItem(Inventory itemName) {
		int foundPosition = findInInventory(itemName);
		if (foundPosition < 0) {
			System.out.println(itemName.getName() + " was not found.");
			return false;
		}
		inventoryList.remove(foundPosition);
		return true;
	}

	/**
	 * Takes newItem of class type as input parameter and checks whether it is
	 * present or not in the inventory ArrayList. If found then it set the newItem
	 * at that position else display with the proper error message and finally
	 * returns boolean value.
	 */
	@Override
	public boolean updateInventory(Inventory oldItem, Inventory newItem) {
		int foundPosition = findInInventory(oldItem);
		if (foundPosition < 0) {
			System.out.println(oldItem.getName() + " was not found.");
			return false;
		}
		inventoryList.set(foundPosition, newItem);
		return true;
	}

	/**
	 * If the list is not empty then it iterate through complete list of items and
	 * finally display all elements present in the list in the form of toString
	 * method defined in Inventory class.
	 */
	@Override
	public void printInventory() {
		if (inventoryList.isEmpty()) {
			System.out.println("Inventory is empty");
		}
		for (int i = 0; i < inventoryList.size(); i++) {
			System.out.println((i + 1) + inventoryList.get(i).toString());
		}
	}

	/**
	 * writes all data of address book to JSON file and returns the string
	 */
	@Override
	public String writeDataToJson() {
		String inventoryManagement = UtilJson.convertObjectToJson(inventoryList);
		return inventoryManagement;
	}

}
