package com.bridgeLabz.objectOrientedPrograms.inventoryManagement.service;

import com.bridgeLabz.objectOrientedPrograms.inventoryManagement.model.Inventory;

/**
 * Interface has the unImplemented methods which need to be implemented.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-13
 * @version 11.0.5
 */
public interface IOperation {

	/**
	 * UnImplemented method to search method.
	 * 
	 * @param productName as input parameter of STring type
	 * @return Inventory Class type
	 */
	Inventory searchInInventory(String productName);

	/**
	 * UnImplemented method to remove from inventory.
	 * 
	 * @param itemName of class type as input parameter
	 * @return Boolean value.
	 */
	boolean removeItem(Inventory itemName);

	/**
	 * UnImplemented method to update in inventory.
	 * 
	 * @param oldItem of class type as input parameter
	 * @param newItem of class type as input parameter
	 * @return Boolean value.
	 */
	boolean updateInventory(Inventory oldItem, Inventory newItem);

	/**
	 * UnImplemented method to print inventory data.
	 */
	void printInventory();

	/**
	 * UnImplemented method to add data to inventory.
	 * 
	 * @param newItem of Class type as input parameter
	 * @return Boolean value
	 */
	boolean addNewItem(Inventory newItem);

	/**
	 * UnImplemented method to writes all data of address book to JSON file and
	 * returns the string
	 * 
	 * @return String values of JSON
	 */
	String writeDataToJson();

}