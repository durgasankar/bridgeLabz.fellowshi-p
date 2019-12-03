package com.bridgeLabz.objectOrientedPrograms.inventoryManagement;

import java.util.ArrayList;

import com.bridgeLabz.utility.Util;
import com.bridgeLabz.utility.UtilJson;

public class AllInventory {
	private String managerName;
	private static ArrayList<InventoryManagementSystem> invManSys = new ArrayList<InventoryManagementSystem>();
//	private static InventoryManagementSystem ims = new InventoryManagementSystem("manager");

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	private static void printInstructions() {
		System.out.println("Available actions :\npress :");
		System.out.println("\t1 -> operate rice inventory\n" + "\t2 -> operate wheat inventory\n"
				+ "\t3 -> operate pulses inventory.\n" + "\t4 -> switch the inventory\n"
				+ "\t5 -> quit the application.\n" + "\t6 -> print instructions.");
		System.out.println("choose your action :");
	}
	
	private static void riceInventory() {
//		invManSys.add(e)
	}

	private static String writeDataToJson() {
		String inventoryManagement = UtilJson.convertObjectToJson(InventoryManagementSystem.inventory.inventoryList);
		return inventoryManagement;
	}

	public static void main(String[] args) {
		System.out.println("please Enter manager name :");
		String managerName = Util.scanner.nextLine();
		System.out.println("Welcome " + managerName + " to inventory.\n--------------------------");
		printInstructions();

		boolean isQuit = false;

		while (!isQuit) {
			System.out.println("\nEnter action : (press : 6 -> show available actions)");
			int action = Util.scanner.nextInt();
			switch (action) {

			case 1:
				System.out.println("Welcome to rice inventory");
				InventoryManagementSystem.inventoryActions(isQuit);
				Util.writeToFile(writeDataToJson(), "jsonInventory.json");
				// operate rice inventory
				break;

			case 2:
				System.out.println("Welcome to rice inventory");
				InventoryManagementSystem.inventoryActions(isQuit);
				// operate wheat inventory
				break;

			case 3:
				System.out.println("Welcome to rice inventory");
				InventoryManagementSystem.inventoryActions(isQuit);
				// operate pulses inventory
				break;

			case 4:
				
				// switch the inventory
				break;

			case 5:
				isQuit = true;
				// quit application
				break;

			case 6:
				printInstructions();
				break;

			default:
				System.out.println("Please read instructions!");

			}
		}

	}

}
