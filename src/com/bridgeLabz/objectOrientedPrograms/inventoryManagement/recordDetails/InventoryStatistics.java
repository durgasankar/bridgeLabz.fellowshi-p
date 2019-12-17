package com.bridgeLabz.objectOrientedPrograms.inventoryManagement.recordDetails;

import java.util.ArrayList;

import com.bridgeLabz.objectOrientedPrograms.inventoryManagement.model.Inventory;
import com.bridgeLabz.objectOrientedPrograms.inventoryManagement.service.ICalculation;

/**
 * This class Implements CAlclation Interface which implements functionality of
 * calculating total weight, total price and print inDetail data present in the
 * inventory.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-13
 * @version 11.0.5
 */
public class InventoryStatistics implements ICalculation {

	/**
	 * Override method of IInventoryClaculation interface which display the total
	 * weight of the object present in Inventory.
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
	 */
	@Override
	public void displayInventory(ArrayList<Inventory> inventory) {
		for (int i = 0; i < inventory.size(); i++) {
			System.out.println(inventory.get(i).toString());
			System.out.println("------------------");
		}
	}

}
