package com.bridgeLabz.objectOrientedPrograms.inventoryManagement;

import java.util.ArrayList;

/**
 * Interface which has the implementation of methods like calculateTotalWeight()
 * , calculateTotalPrice() , displayInventory().
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-03
 * @version 11.0.5
 */
public interface IIneventryCalculation {

	public int calculateTotalWeight(ArrayList<Inventory> inventory);

	public double calculateTotalPrice(ArrayList<Inventory> inventory);

	public void displayInventory(ArrayList<Inventory> inventory);

}
