package com.bridgeLabz.objectOrientedPrograms.inventoryManagement;

public class Instructions {

	protected void printMainInstructions() {
		System.out.println("Available actions :\npress :");
		System.out.println(
				"\t1 -> quit application.\n" + "\t2 -> add a new product.\n" + "\t3 -> update an existing product.\n"
						+ "\t4 -> remove an existing product.\n" + "\t5 -> search a product from inventory.\n"
						+ "\t6 -> print indetail product.\n" + "\t7 -> print instructions.\n" + "\t8 -> statistics\n");
		System.out.println("choose your action :");
	}

	protected void printUpdateActions() {
		System.out.println("Available actions :\npress :");
		System.out.println(
				"\t1 -> update price only.\n" + "\t2 -> update quantity.\n" + "\t3 -> update both price and quantity\n"
						+ "\t4 -> cancel update.\n" + "\t5 -> Quit application." + "\t6 -> print instructions.");
		System.out.println("choose your action :");
	}

	protected void printDeleteActions() {
		System.out.println("Available actions :\npress :");
		System.out.println("\t1 -> cancel delete operation\n" + "\t2 -> Quit application.\n"
				+ "\t3 -> Enter to deletion directory.");
		System.out.println("choose your action :");
	}

	protected void printAdditionActions() {
		System.out.println("Available actions :\npress :");
		System.out.println("\t1 -> cancel addition operation\n" + "\t2 -> Quit application.\n"
				+ "\t3 -> Enter to addition directory.");
		System.out.println("choose your action :");
	}

	protected void printStatistics() {
		System.out.println("Available actions :\npress :");
		System.out.println("\t1 -> calculate total weight in inventory.\n" + "\t2 -> Quit the application.\n"
				+ "\t3 -> calculate total price in inventory.\n" + "\t4 -> print instructions");
		System.out.println("choose your action :");
	}

}
