package com.bridgeLabz.objectOrientedPrograms.inventoryManagement;

import com.bridgeLabz.utility.Util;
import com.bridgeLabz.utility.UtilJson;

public class InventoryManagementSystem {
	private String inventoryName;
	protected static InventoryOperations inventory = new InventoryOperations("admin");

	public InventoryManagementSystem(String inventoryName) {
		this.inventoryName = inventoryName;
	}

	public String getInventoryName() {
		return inventoryName;
	}

	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}

	private static void printInstructions() {
		System.out.println("Available actions :\npress :");
		System.out.println("\t1 -> switch from inventory.\n" + "\t2 -> add a new product.\n"
				+ "\t3 -> update an existing product.\n" + "\t4 -> remove an existing product.\n"
				+ "\t5 -> search a product from inventory.\n" + "\t6 -> print indetail product.\n"
				+ "\t7 -> print instructions." + "\t8 -> quit application");
		System.out.println("choose your action :");
	}

	private static void addNewProductToInventory() {
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

	}

	private static void updateExistingProductInInventory() {
		System.out.println("Enter the name of the product you want to modify :");
		String oldProductName = Util.scanner.next();
		Inventory existingProductInInventory = inventory.searchInInventory(oldProductName);
		if (existingProductInInventory == null) {
			System.out.println(oldProductName + " not found in inventory.");
			return;
		}
		System.out.println("Enter weight :");
		int weight = Util.scanner.nextInt();
		System.out.println("Enter price :");
		double price = Util.scanner.nextDouble();
		Inventory updatedProductInInventory = Inventory.createInventory(oldProductName, weight, price);
		if (inventory.updateInventory(existingProductInInventory, updatedProductInInventory)) {
			System.out.println("Record updated successfully.");
		} else {
			System.out.println("Error updating record.");
		}

	}

	private static void deleteRecordFromInventory() {
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

	}

	public static void searchProductFromInventory() {
		System.out.println("Enter the product name you want to search :");
		String productName = Util.scanner.next();
		Inventory existingProduct = inventory.searchInInventory(productName);
		if (existingProduct == null) {
			System.out.println(productName + " not found in inventory.");
			return;
		}
		System.out.println("name=" + existingProduct.getName() + "\nweight=" + existingProduct.getWeight() + "\nprice="
				+ existingProduct.getPrice());
	}

	private static String writeDataToJson() {
		String inventoryManagement = UtilJson.convertObjectToJson(inventory.inventoryList);
		return inventoryManagement;
	}
	
	private static void printInventory() {
		inventory.printInventory();
	}

	public static boolean inventoryActions(boolean isQuit) {
		printInstructions();
		boolean switchFromInventory = false;

		while (!switchFromInventory || isQuit) {
			System.out.println("\nEnter action : (press : 7 -> show available actions)");
			int action = Util.scanner.nextInt();

			switch (action) {
			case 1:
				switchFromInventory = true;
				isQuit = false;
				System.out.println("Thank you for using " + inventory.getInventoryName() + " inventory");
				break;

			case 2:
				addNewProductToInventory();
				Util.writeToFile(writeDataToJson(), "jsonInventory.json");
				break;

			case 3:
				updateExistingProductInInventory();
//				Util.writeToFile(writeDataToJson(), "jsonInventory.json");
				break;

			case 4:
				deleteRecordFromInventory();
//				Util.writeToFile(writeDataToJson(), "jsonInventory.json");
				break;

			case 5:
				searchProductFromInventory();
				break;

			case 6:
				//printInstructions();
				printInventory();
				break;

			case 7:
				printInstructions();
				break;
			case 8:
				switchFromInventory = true;
				isQuit = true;

			default:
				System.out.println("Please read instructions!");
			}
		}
		return true;

	}

//	public static void main(String[] args) {
//		System.out.println("please Enter your inventory name :");
//		String inventoryName = Util.scanner.nextLine();
//		inventory.setInventoryName(inventoryName);
//		System.out.println("Welcome to " + inventory.getInventoryName() + "'s inventory.\n--------------------------");
//		printInstructions();
//
//	}
}
