package com.bridgeLabz.objectOrientedPrograms.stockMarket.operarion;

import com.bridgeLabz.objectOrientedPrograms.stockMarket.company.CompanyOperation;
import com.bridgeLabz.objectOrientedPrograms.stockMarket.company.CompanyShare;
import com.bridgeLabz.objectOrientedPrograms.stockMarket.customer.CustomerOperation;
import com.bridgeLabz.objectOrientedPrograms.stockMarket.service.ICustomerServices;
import com.bridgeLabz.utility.Util;
import com.bridgeLabz.utility.UtilJson;

/**
 * This class has the implementation of the Stock market of both Company and
 * Customers. where company has the functionality of adding and removing a share
 * from the market. Customer has the functionality of buying a share or selling
 * a share from the market. And all instructions to run the share market.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-07
 * @modified 2019-12-12
 * @updated -> separated this class from Customer class.
 * @version 11.0.5
 */
public class Operation {
	/**
	 * Objects of CompanyShare and CustomerOperation class
	 */
	private static CompanyShare companyShare = new CompanyShare();
	private static ICustomerServices customerTrading = new CustomerOperation();
	private static final String CUSTOMER_PATH = "customer.json";
	private static final String COMPANY_PATH = "company.json";

	/**
	 * Instructions followed during execution of Company class
	 */
	private void displayCompanyInstructions() {
		System.out.println("Available actions :\npress :");
		System.out.println("\t1 -> Switch to main menu.\n" + "\t2 -> Add new share.\n" + "\t3 -> Print all shares\n"
				+ "\t4 -> Print instructions.\n" + "\t5 -> Quit the application completely.\n"
				+ "\t6 -> Remove share of the company.");
		System.out.println("choose your action :");

	}

	/**
	 * Instructions followed during execution of Customer class
	 */
	private void displayCustomerInstructions() {
		System.out.println("Available actions :\npress :");
		System.out.println("\t1 -> Switch to main menu.\n" + "\t2 -> Buy a share\n"
				+ "\t3 -> Print customers portfolio.\n" + "\t4 -> Print instructions.\n"
				+ "\t5 -> Print company shares.\n" + "\t6 -> Quit the application.\n" + "\t7 -> Sell shares.");
		System.out.println("choose your action :");

	}

	/**
	 * writes all data of Company to JSON file and returns the string
	 * 
	 * @return String values of JSON
	 */
	private static String writeCompanyDataToJson() {
		String companyBook = UtilJson.convertObjectToJson(CompanyOperation.companyShareList);
		return companyBook;
	}

	/**
	 * writes all data of customer to JSON file and returns the string
	 * 
	 * @return String values of JSON
	 */
	private static String writeCustomerDataToJson() {
		String companyBook = UtilJson.convertObjectToJson(CustomerOperation.customerShareList);
		return companyBook;
	}

	/**
	 * Allows user to a do a particular addition operation at a time . after each
	 * operation he will be reDicted to main menu option. Also he has one ability to
	 * close the Application at particular time when he want to stop it.
	 * 
	 * @param isQuitApplication Boolean type as input parameter.
	 */
	public void companyOperation(boolean isQuitApplication) {

		isQuitApplication = false;
		displayCompanyInstructions();

		boolean isSwitch = false;
		while (!isSwitch) {
			System.out.println("\nEnter action : (press : 4 -> show available actions 1 -> switch to customer side.)");
			int action = Util.scanner.nextInt();
			switch (action) {
			case 1:
				isSwitch = true;
				break;

			case 2:
				companyShare.addNewShare();
				Util.writeToFile(writeCompanyDataToJson(), COMPANY_PATH);
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
				Util.writeToFile(writeCompanyDataToJson(), COMPANY_PATH);
				break;

			default:
				System.out.println("Please read instructions!");
			}
		}
	}

	/**
	 * Allows user to a do a particular addition operation at a time . after each
	 * operation he will be reDicted to main menu option. Also he has one ability to
	 * close the Application at particular time when he want to stop it.
	 * 
	 * @param isQuitApplication Boolean type as input parameter.
	 */
	public void customerOperation(boolean isQuitApplication) {
		displayCustomerInstructions();
		isQuitApplication = false;
		boolean isSwitch = false;
		while (!isSwitch) {
			System.out.println("\nEnter action : (press : 4 -> show available actions 1 -> switch to Company side.)");
			int action = Util.scanner.nextInt();
			switch (action) {
			case 1:
				isSwitch = true;
				break;

			case 2:
				System.out.println("Available shares to buy :");
				companyShare.displayShortSharesList();
				customerTrading.buyShare();
				Util.writeToFile(writeCompanyDataToJson(), COMPANY_PATH);
				Util.writeToFile(writeCustomerDataToJson(), CUSTOMER_PATH);
				break;

			case 3:
				customerTrading.displayCustomerPortfolio();
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
				customerTrading.sellShare();
				Util.writeToFile(writeCompanyDataToJson(), COMPANY_PATH);
				Util.writeToFile(writeCustomerDataToJson(), CUSTOMER_PATH);
				break;

			default:
				System.out.println("Please read instructions!");
			}
		}

	}

}
