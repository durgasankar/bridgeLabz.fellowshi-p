package com.bridgeLabz.objectOrientedPrograms.inventoryManagement;

import java.util.ArrayList;

public interface IIneventryCalculation {

	public  int calculateTotalWeight(ArrayList<Inventory> inventory);

	public double calculateTotalPrice(ArrayList<Inventory> inventory);

	public void displayInventory(ArrayList<Inventory> inventory);

}
