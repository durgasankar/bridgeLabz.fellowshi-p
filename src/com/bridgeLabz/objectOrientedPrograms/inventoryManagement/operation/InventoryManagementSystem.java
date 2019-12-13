package com.bridgeLabz.objectOrientedPrograms.inventoryManagement.operation;

import com.bridgeLabz.objectOrientedPrograms.inventoryManagement.model.Inventory;
import com.bridgeLabz.objectOrientedPrograms.inventoryManagement.recordDetails.InventoryStatistics;
import com.bridgeLabz.objectOrientedPrograms.inventoryManagement.service.ICalculation;
import com.bridgeLabz.objectOrientedPrograms.inventoryManagement.service.IOperation;
import com.bridgeLabz.utility.Util;

/**
 * This class has the implementation of addition operation , deletion operation,
 * update operation on basis of price , on basis of weight, both price and
 * weight to the inventory, check in detail price and weight of stocks in the
 * inventory. User has the ability to check statistics of the data present in
 * the inventory. Along with all implementation methods it has main method where
 * every data is implemented.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-04
 * @modified 2019-12-13
 * @updated -> modified update method removed extra codes for update.
 * @version 11.0.5
 */
public class InventoryManagementSystem {
	private static IOperation inventory = new InventoryOperations();
	private static ICalculation StatisticsCalculation = new InventoryStatistics();
	static final String INVENTORY_PATH = "inventory.json";

	/**
	 * Ask the customer to give inputs of name of product, weight and price and
	 * create a class type object by using details given by user and it calls the
	 * addNewItem method by using object reference. addition operation success
	 * message is displayed with proper message.
	 */
	public void addNewProductToInventory() {
		System.out.println("Enter the name :");
		String name = Util.scanner.next();
		System.out.println("Enter the weight :");
		int weight = Util.scanner.nextInt();
		System.out.println("Enter the price :");
		double price = Util.scanner.nextDouble();

		Inventory newItem = Inventory.createInventory(name, weight, price);
		if (inventory.addNewItem(newItem)) {
			System.out.println("Item " + newItem.getName() + " added successfully.");
		} else {
			System.out.println("Item " + newItem.getName() + " already exist in file.");
		}
		Util.writeToFile(inventory.writeDataToJson(), INVENTORY_PATH);

	}

	public void deleteRecordFromInventory() {
		System.out.println("Enter the name of item which you want to delete :");
		String deletingProductName = Util.scanner.next();
		Inventory existingProductInInventory = inventory.searchInInventory(deletingProductName);
		if (existingProductInInventory == null) {
			System.out.println(deletingProductName + " not found in inventory.");
			return;
		}
		if (inventory.removeItem(existingProductInInventory)) {
			System.out.println(existingProductInInventory.getName() + " deleted successfully.");
		} else {
			System.out.println("Error deleting record");
		}
		Util.writeToFile(inventory.writeDataToJson(), INVENTORY_PATH);
	}

	/**
	 * Ask the customer to give the name of the product which he wants to search
	 * for. On the basis of name it use object reference and search for existence of
	 * product if found then it print inDetail information of the product.
	 */
	public void searchProductFromInventory() {
		System.out.println("Enter the product name you want to search :");
		String productName = Util.scanner.next();
		Inventory existingProduct = inventory.searchInInventory(productName);
		if (existingProduct == null) {
			System.out.println(productName + " not found in inventory.");
			return;
		}
		System.out.println("name = " + existingProduct.getName() + "\nweight = " + existingProduct.getWeight()
				+ "\nprice = " + existingProduct.getPrice());
	}

	/**
	 * Prints the all data present in the inventory in string format.
	 */
	public void printInventory() {
		inventory.printInventory();
	}

	public void statistics(boolean isCheckStatistics) {
		isCheckStatistics = false;
		while (!isCheckStatistics) {
			System.out.println("\nEnter action to check : press :\n1-> total weight. 2-> total price. 3-> main menu.");
			int deleteAction = Util.scanner.nextInt();
			switch (deleteAction) {

			case 1:
				System.out.println("Total weight in inventory : "
						+ StatisticsCalculation.calculateTotalWeight(InventoryOperations.getInventoryList()) + " kg.");
				break;
			// total weight
			case 2:
				System.out.println("Total price of stocks in inventory : "
						+ StatisticsCalculation.calculateTotalPrice(InventoryOperations.getInventoryList()) + " rs.");
				break;
			// total price
			case 3:
				isCheckStatistics = true;
				break;
			// main menu
			default:
				System.out.println("Please follow instructions!");
				break;
			}
		}

	}

	public void updateProductFromInventory() {
		System.out.println("Enter the name of the product you want to modify :");
		String oldProductName = Util.scanner.next();
		Inventory existingProductInInventory = inventory.searchInInventory(oldProductName);
		if (existingProductInInventory == null) {
			System.out.println(oldProductName + " not found in inventory.");
			return;
		}
		int weight = existingProductInInventory.getWeight();
		double price = existingProductInInventory.getPrice();
		System.out.println("Enter update action : 1-> weight, 2-> price, 3-> price and weight");
		int action = Util.scanner.nextInt();
		switch (action) {
		case 1:
			System.out.println("Enter new Weight :");
			weight = Util.scanner.nextInt();
			// update weight
			break;
		case 2:
			System.out.println("Enter new Price :");
			price = Util.scanner.nextDouble();
			// update price
			break;
		case 3:
			System.out.println("Enter new Weight :");
			weight = Util.scanner.nextInt();
			System.out.println("Enter new Price :");
			price = Util.scanner.nextDouble();
			// update price and weight
			break;
		}
		Inventory updatedProductInInventory = Inventory.createInventory(oldProductName, weight, price);
		if (inventory.updateInventory(existingProductInInventory, updatedProductInInventory)) {
			System.out.println("Record updated successfully.");
		} else {
			System.out.println("Error updating record.");
		}
		Util.writeToFile(inventory.writeDataToJson(), INVENTORY_PATH);

	}

	public void printMainInstructions() {
		System.out.println("Available actions :\npress :");
		System.out.println("\t1 -> add \n" + "\t2 -> update\n" + "\t3 -> delete\n" + "\t4 -> print statistics.\n"
				+ "\t5 -> print Inventory data.\n" + "\t6 -> Quit application.\n" + "\t7 -> Search from inventory\n");
		System.out.println("choose your action :");
	}

}
