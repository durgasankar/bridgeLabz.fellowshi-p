package com.bridgeLabz.objectOrientedPrograms.inventoryManagement.service;

import java.util.ArrayList;

import com.bridgeLabz.objectOrientedPrograms.inventoryManagement.model.Inventory;

/**
 * Interface which has the implementation of methods like calculateTotalWeight()
 * , calculateTotalPrice() , displayInventory().
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-03
 * @version 11.0.5
 */
public interface ICalculation {
	/**
	 * UnImplemented method to calculate total weight of data present in the
	 * inventory.
	 * 
	 * @param inventoryList of ArrayList type input parameter
	 * @return Integer value
	 */
	public int calculateTotalWeight(ArrayList<Inventory> inventoryList);

	/**
	 * UnImplemented method to calculate total Price of data present in the
	 * inventory.
	 * 
	 * @param inventoryList of ArrayList type input parameter
	 * @return Double Value
	 */

	public double calculateTotalPrice(ArrayList<Inventory> inventoryList);

	/**
	 * UnImplemented method to display all data present in the inventory.
	 * 
	 * @param inventoryList
	 */
	public void displayInventory(ArrayList<Inventory> inventoryList);

}
