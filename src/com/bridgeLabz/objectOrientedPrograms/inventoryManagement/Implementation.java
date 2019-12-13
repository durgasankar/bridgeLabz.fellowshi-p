package com.bridgeLabz.objectOrientedPrograms.inventoryManagement;

import com.bridgeLabz.objectOrientedPrograms.inventoryManagement.operation.InventoryManagementSystem;
import com.bridgeLabz.utility.Util;

/**
 * Implementation class which of Inventory management system.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-13
 * @version 11.0.5
 */
public class Implementation {
	public static void main(String[] args) {
		InventoryManagementSystem management = new InventoryManagementSystem();
		System.out.println("Welcome to inventory\n---------------------");
		management.printMainInstructions();
		boolean isQuit = false;

		while (!isQuit) {
			System.out.println("\nEnter action : (press : 8 -> show available actions)");
			int action = Util.scanner.nextInt();

			switch (action) {

			case 1:
				// add
				management.addNewProductToInventory();
				break;
			case 2:
				// update
				management.updateProductFromInventory();
				break;
			case 3:
				// delete
				management.deleteRecordFromInventory();
				break;
			case 4:
				// statistics
				management.statistics(isQuit);
				break;
			case 5:
				// print
				management.printInventory();
			case 6:
				// quit
				isQuit = true;
				System.out.println("Thank you ! visit again...");
				break;
			case 7:
				// search
				management.searchProductFromInventory();
				break;
			case 8:
				// print instruction
				management.printMainInstructions();
			default:
				System.out.println("Please read instructions!");
				break;

			}
		}

	}

}
