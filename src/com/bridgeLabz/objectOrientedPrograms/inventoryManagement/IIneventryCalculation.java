package com.bridgeLabz.objectOrientedPrograms.inventoryManagement;

import java.util.ArrayList;

public interface IIneventryCalculation {

	public abstract int calculateTotalWeight(ArrayList<Inventory> inventory);

	public abstract double calculateTotalPrice(ArrayList<Inventory> inventory);

	public abstract void displayInventory(ArrayList<Inventory> inventory);

}
