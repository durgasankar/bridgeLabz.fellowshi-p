package com.bridgeLabz.objectOrientedPrograms.inventoryManagement;

import com.bridgeLabz.utility.Util;
import com.bridgeLabz.utility.UtilJson;

public class InventoryManagementSystem {
	private String inventoryName;
	protected static InventoryOperations inventory = new InventoryOperations("admin");
	private static Instructions instruction = new Instructions();

	public InventoryManagementSystem(String inventoryName) {
		this.inventoryName = inventoryName;
	}

	public String getInventoryName() {
		return inventoryName;
	}

	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
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

	private static void updateBothPriceAndWeightInExistingProductOfInventory() {
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

	private static void updatePriceInExistingProductOfInventory() {
		System.out.println("Enter the name of the product you want to modify :");
		String oldProductName = Util.scanner.next();
		Inventory existingProductInInventory = inventory.searchInInventory(oldProductName);
		if (existingProductInInventory == null) {
			System.out.println(oldProductName + " not found in inventory.");
			return;
		}
		int oldWeight = existingProductInInventory.getWeight();
		System.out.println("Enter price :");
		double newPrice = Util.scanner.nextDouble();
		Inventory updatedProductInInventory = Inventory.createInventory(oldProductName, oldWeight, newPrice);
		if (inventory.updateInventory(existingProductInInventory, updatedProductInInventory)) {
			System.out.println("price updated successfully.");
		} else {
			System.out.println("Error updating record.");
		}
	}

	private static void updateWeightInExistingProductOfInventory() {
		System.out.println("Enter the name of the product you want to modify :");
		String oldProductName = Util.scanner.next();
		Inventory existingProductInInventory = inventory.searchInInventory(oldProductName);
		if (existingProductInInventory == null) {
			System.out.println(oldProductName + " not found in inventory.");
			return;
		}
		double oldPrice = existingProductInInventory.getWeight();
		System.out.println("Enter price :");
		int newWeight = Util.scanner.nextInt();
		Inventory updatedProductInInventory = Inventory.createInventory(oldProductName, newWeight, oldPrice);
		if (inventory.updateInventory(existingProductInInventory, updatedProductInInventory)) {
			System.out.println("price updated successfully.");
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

	public static void updateImplimentation(boolean isQuit) {
		isQuit = false;
		instruction.printUpdateActions();
		boolean isCompleteUpdated = false;
		while (!isCompleteUpdated && !isQuit) {
			System.out.println("\nEnter action : (press : 6 -> show available update actions)\n"
					+ "\t\t(press : 4 -> cancel update.)");
			int updateActions = Util.scanner.nextInt();
			switch (updateActions) {
			case 1:
				// update price
				updatePriceInExistingProductOfInventory();
				isCompleteUpdated = true;
				break;
			case 2:
				// update weight
				updateWeightInExistingProductOfInventory();
				isCompleteUpdated = true;
				break;
			case 3:
				// update both price and quantity
				updateBothPriceAndWeightInExistingProductOfInventory();
				isCompleteUpdated = true;
				break;
			case 4:
				// cancel update
				isCompleteUpdated = true;
				break;
			case 5:
				// quit application
				isCompleteUpdated = true;
				isQuit = true;
				break;
			case 6:
				// print update actions
				instruction.printUpdateActions();
				break;
			default:
				System.out.println("Please read instructions!");
				break;
			}
		}

	}

	public static void deleteImplimentation(boolean isQuit) {
		isQuit = false;
		instruction.printDeleteActions();
		boolean isDeleteComplete = false;
		while (!isDeleteComplete && !isQuit) {
			System.out.println("\nEnter action : press : 1 -> cancel delete operation.\n"
					+ "\t\tpress : 2 -> quit application" + "\t\tpress 3 : delete operation");
			int deleteAction = Util.scanner.nextInt();
			switch (deleteAction) {

			case 1:
				isDeleteComplete = true;
				break;
			case 2:
				isDeleteComplete = true;
				isQuit = true;
				break;
			case 3:
				deleteRecordFromInventory();
				isDeleteComplete = true;
				break;
			default:
				System.out.println("Please read instructions!");
				break;
			}
		}

	}

	public static void addImplimentation(boolean isQuit) {
		isQuit = false;
		boolean isAddComplete = false;
		while (!isAddComplete && !isQuit) {
			System.out.println("\nEnter action : press : 1 -> cancel addition operation.\n"
					+ "\t\tpress : 2 -> quit application\n" + "\t\tpress : 3 -> addition operation");
			int deleteAction = Util.scanner.nextInt();
			switch (deleteAction) {

			case 1:
				isAddComplete = true;
				break;
			case 2:
				isAddComplete = true;
				isQuit = true;
				break;
			case 3:
				addNewProductToInventory();
				isAddComplete = true;
				break;
			default:
				System.out.println("Please read instructions!");
				break;
			}
		}

	}

	public static void statistics(boolean isQuit) {
		isQuit = false;
		boolean isCheckStatistics = false;
		while (!isCheckStatistics || !isQuit) {
			System.out.println("\nEnter action : press : 4 -> print instructions\n");
			int deleteAction = Util.scanner.nextInt();
			switch (deleteAction) {

			case 1:
				System.out.println("Total weight in inventory : "
						+ inventory.calculateTotalWeight(inventory.inventoryList) + " kg.");
				isCheckStatistics = true;
				break;
			case 2:
				isCheckStatistics = true;
				isQuit = true;
				break;
			case 3:
				System.out.println("Total price of stocks in inventory : "
						+ inventory.calculateTotalPrice(inventory.inventoryList) + " rs.");
				isCheckStatistics = true;
				break;
			case 4:
				instruction.printStatistics();
				isCheckStatistics = true;
				break;
			default:
				System.out.println("Please read instructions!");
				break;
			}
		}

	}

	public static void main(String[] args) {
		System.out.println("please Enter your inventory name :");
		String inventoryName = Util.scanner.nextLine();
		inventory.setInventoryName(inventoryName);
		System.out.println("Welcome to " + inventory.getInventoryName() + "'s inventory.\n--------------------------");
		instruction.printMainInstructions();
		boolean isQuit = false;

		while (!isQuit) {
			System.out.println("\nEnter action : (press : 7 -> show available actions)");
			int action = Util.scanner.nextInt();

			switch (action) {
			case 1:
				isQuit = true;
				System.out.println("Thank you for using " + inventory.getInventoryName() + " inventory");
				break;

			case 2:
				addImplimentation(isQuit);
				Util.writeToFile(writeDataToJson(), "jsonInventory.json");
				break;

			case 3:
				updateImplimentation(isQuit);
				Util.writeToFile(writeDataToJson(), "jsonInventory.json");
				break;

			case 4:
				deleteImplimentation(isQuit);
				Util.writeToFile(writeDataToJson(), "jsonInventory.json");
				break;

			case 5:
				searchProductFromInventory();
				break;

			case 6:
				printInventory();
				break;

			case 7:
				instruction.printMainInstructions();
				break;

			case 8:
				statistics(isQuit);
				break;

			default:
				System.out.println("Please read instructions!");
				break;
			}
		}
	}
}
