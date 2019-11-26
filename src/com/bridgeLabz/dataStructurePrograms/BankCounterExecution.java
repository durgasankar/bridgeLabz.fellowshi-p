package com.bridgeLabz.dataStructurePrograms;

import com.bridgeLabz.dataStructurePrograms.generics.Queue;
import com.bridgeLabz.utility.Util;

/**
 * Enter number of customers in the queue and ask them to fill their details.
 * After filling their details first user on the line will enter his account
 * number to start his banking process. Banking process allows the user to
 * deposit , withdraw money from the bank . after completing transaction the
 * user move from the queue and then next user continue his process . this steps
 * continue unless and until all user complete their transactions. Bank has the
 * power in his hand to quit the transaction any time he wants .
 * 
 * @author Durgasankar Mishra
 * @created 2019-11-26
 * @version 11.0.5
 */
public class BankCounterExecution {

	private static Queue<String> line = new Queue<String>();
	private static boolean isQuitApp = false;

	public static void instructions() {
		System.out.println("press 1: Deposit to your account\n" + "press 2: withdraw amount from your account\n"
				+ "press 3: move to the next customer.\n" + "press 4: print instructions.\n"
				+ "press 5: Quit the application completely");
	}

	/**
	 * Takes input parameter as account number to do sequential transactions of each
	 * individuals. which includes the functionality of depositing amount,
	 * withdrawal, move to the next customer with out doing any transactions.quiting
	 * the application completely from bank side. and printing instructions.
	 * 
	 * @param accountNumber of String type as parameter.
	 */
	private static void bankOperations(String accountNumber) {
		BankAccount myAccount = new BankAccount(accountNumber);
		boolean isTransactionComplete = false;
		while (!isTransactionComplete) {
			instructions();
			System.out.println("\nPlease Enter Your choice :");
			int choices = Util.scanner.nextInt();
			switch (choices) {
			case 1:
				System.out.println("Please Enter deposit amount : ");
				myAccount.deposit(Util.scanner.nextDouble());
				break;

			case 2:
				System.out.println("Please enter withdraw amount : ");
				myAccount.withdrawAmount(Util.scanner.nextDouble());
				break;

			case 3:
				System.out.println("move to the next customer :");
				line.deQueue();
				isTransactionComplete = true;
				System.out.println("Thank You . visit Again.\n" + "Remaining people in the list :");

			case 4:
				instructions();
				break;

			case 5:
				isTransactionComplete = true;
				isQuitApp = true;
				System.out.println("Bank Closed !");
				break;

			default:
				System.out.println("Opps! Invalid Input...");
				instructions();
				break;
			}

		}

	}

	public static void main(String[] args) {

		System.out.println("Please add Number of people in queue :");
		int length = Util.scanner.nextInt();
		System.out.println("please enter customer Name :");
		for (int i = 0; i < length; i++) {
			String customerName = Util.scanner.next();
			line.enQueue(customerName);
		}
		System.out.println("Number of people in the Queue :");
		line.print();
		int queueLength = line.size();
		while (queueLength > 0 && !isQuitApp) {
			System.out.println("Please enter your account number to start application :");
			System.out.println();
			String accountNumber = Util.scanner.next();
			bankOperations(accountNumber);
			System.out.println("Remaining people in the queue : ");
			line.print();
		}
	}

}
