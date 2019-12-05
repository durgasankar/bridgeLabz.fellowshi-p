package com.bridgeLabz.objectOrientedPrograms.inventoryManagement;

import com.bridgeLabz.utility.Util;
import com.bridgeLabz.utility.UtilJson;

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
 * @version 11.0.5
 */
public class InventoryManagementSystem {
	private String inventoryName;
	protected static InventoryOperations inventory = new InventoryOperations("admin");
	private static Instructions instruction = new Instructions();

	/**
	 * Constructor to initialize the class takes parameter inventory name as input
	 * parameter.
	 * 
	 * @param inventoryName as input parameter
	 */
	public InventoryManagementSystem(String inventoryName) {
		this.inventoryName = inventoryName;
	}

	/**
	 * Getter method to getInventory name.
	 * 
	 * @return String data.
	 */
	public String getInventoryName() {
		return inventoryName;
	}

	/**
	 * Setter method to set inventory name.
	 * 
	 * @param inventoryName of String type as input parameter
	 */
	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}

	/**
	 * Ask the customer to give inputs of name of product, weight and price and
	 * create a class type object by using details given by user and it calls the
	 * addNewItem method by using object reference. addition operation success
	 * message is displayed with proper message.
	 */
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

	/**
	 * Ask the customer to give inputs of name of product. It search for existing
	 * product by using object reference. If found then it ask the customer to give
	 * input of price and weight and use the name from oldProductOfInventory and
	 * create a new class type object and uses updateInventory method from reference
	 * type and after successful update it display with proper message. update is
	 * done only on the basis of price and weight.
	 */
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

	/**
	 * Ask the customer to give inputs of name of product. It search for existing
	 * product by using object reference. If found then it ask the customer to give
	 * input of price use the name and weight from oldProductOfInventory and create
	 * a new class type object and uses updateInventory method from reference type
	 * and after successful update it display with proper message. update is done
	 * only on the basis of price.
	 */
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

	/**
	 * Ask the customer to give inputs of name of product. It search for existing
	 * product by using object reference. If found then it ask the customer to give
	 * input of weight and use the name from oldProductOfInventory and create a new
	 * class type object and uses updateInventory method from reference type and
	 * after successful update it display with proper message. update is done only
	 * on the basis of weight.
	 */
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

	/**
	 * This function ask the customer to give the input of name of the product. From
	 * the name it search for the Existing product by using object reference. If
	 * found it successfully delete it from the inventory by using object reference.
	 * After successfully deletion it display with proper deletion message.
	 */
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

	/**
	 * Ask the customer to give the name of the product which he wants to search
	 * for. On the basis of name it use object reference and search for existence of
	 * product if found then it print inDetail information of the product.
	 */
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

	/**
	 * writes all data of address book to JSON file and returns the string
	 * 
	 * @return String values of JSON
	 */
	private static String writeDataToJson() {
		String inventoryManagement = UtilJson.convertObjectToJson(inventory.inventoryList);
		return inventoryManagement;
	}

	/**
	 * Prints the all data present in the inventory in string format.
	 */
	private static void printInventory() {
		inventory.printInventory();
	}

	/**
	 * Allows user to a do a particular update at a time . after each update he will
	 * be reDicted to main menu option. Also he has one ability to close the
	 * Application at particular time when he want to stop it.
	 * 
	 * @param isQuit Boolean type as input parameter.
	 */
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

	/**
	 * Allows user to a do a particular delete operation at a time . after each
	 * operation he will be reDicted to main menu option. Also he has one ability to
	 * close the Application at particular time when he want to stop it.
	 * 
	 * @param isQuit Boolean type as input parameter.
	 */
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

	/**
	 * Allows user to a do a particular addition operation at a time . after each
	 * operation he will be reDicted to main menu option. Also he has one ability to
	 * close the Application at particular time when he want to stop it.
	 * 
	 * @param isQuit Boolean type as input parameter.
	 */
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

	/**
	 * This function allows the customer to check the statistics of the inventory.
	 * he has the ability to do each operation at a time. This operation continues
	 * till he want go back to main menu.
	 * 
	 * @param isQuit Boolean type as input parameter.
	 */
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
