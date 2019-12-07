package com.bridgeLabz.objectOrientedPrograms.stockMarket;

import com.bridgeLabz.objectOrientedPrograms.stockMarket.company.CompanyShare;
import com.bridgeLabz.objectOrientedPrograms.stockMarket.customer.TradingOperation;
import com.bridgeLabz.utility.Util;

public class Implementation {

	private static CompanyShare companyShare = new CompanyShare();
	private static TradingOperation trading = new TradingOperation();

	public void displayCompanyInstructions() {
		System.out.println("Available actions :\npress :");
		System.out.println("\t1 -> Switch to main menu.\n" + "\t2 -> Add new share.\n" + "\t3 -> Print all shares\n"
				+ "\t4 -> Print instructions.\n" + "\t5 -> Quit the application completely.\n"
				+ "\t6 -> Remove share of the company.");
		System.out.println("choose your action :");

	}

	public void displayCustomerInstructions() {
		System.out.println("Available actions :\npress :");
		System.out.println(
				"\t1 -> Switch to main menu.\n" + "\t2 -> Buy a share\n" + "\t3 -> Print customers portfolio.\n"
						+ "\t4 -> Print instructions.\n" + "\t5 -> Print company shares.\n"
						+ "\t6 -> Quit the application.\n" + "\t7 -> Sell shares.");
		System.out.println("choose your action :");

	}

	public void companyOperation(boolean isQuitApplication) {

		isQuitApplication = false;
		displayCompanyInstructions();

		boolean isSwitch = false;
		while (!isSwitch) {
			System.out.println("\nEnter action : (press : 4 -> show available actions)");
			int action = Util.scanner.nextInt();
			switch (action) {
			case 1:
				isSwitch = true;
				break;

			case 2:
				companyShare.addNewShare();
				break;

			case 3:
				companyShare.displayShortSharesList();
				break;

			case 4:
				displayCompanyInstructions();
				break;

			case 5:
				isSwitch = true;
				isQuitApplication = true;
				break;

			case 6:
				companyShare.removeShare();
				break;

			default:
				System.out.println("Please read instructions!");
			}
		}
	}

	public void customerOperation(boolean isQuitApplication) {
		displayCustomerInstructions();
		isQuitApplication = false;
		boolean isSwitch = false;
		while (!isSwitch) {
			System.out.println("\nEnter action : (press : 4 -> show available actions)");
			int action = Util.scanner.nextInt();
			switch (action) {
			case 1:
				isSwitch = true;
				break;

			case 2:
				trading.buyShare();
				break;

			case 3:
				trading.displayCustomerPortfolio();
				break;

			case 4:
				displayCustomerInstructions();
				break;

			case 5:
				companyShare.displayIndetailShareList();
				break;

			case 6:
				isSwitch = true;
				isQuitApplication = true;
				break;

			case 7:
				trading.sellShare();
				break;

			default:
				System.out.println("Please read instructions!");
			}
		}

	}

	public static void main(String[] args) {

		Implementation implimentation = new Implementation();

		boolean isQuitApplication = false;
		while (!isQuitApplication) {
			System.out.println("\nEnter action : 1. login as company 2. login as customer. 3. Quit application");
			int action = Util.scanner.nextInt();
			switch (action) {
			case 1:
				implimentation.companyOperation(isQuitApplication);
				break;

			case 2:
				implimentation.customerOperation(isQuitApplication);
				break;

			case 3:
				isQuitApplication = true;
				break;

			default:
				System.out.println("Please read instructions!");
			}
		}
	}

}
