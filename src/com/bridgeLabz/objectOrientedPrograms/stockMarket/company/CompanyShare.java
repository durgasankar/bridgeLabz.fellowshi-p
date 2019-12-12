package com.bridgeLabz.objectOrientedPrograms.stockMarket.company;

import com.bridgeLabz.objectOrientedPrograms.stockMarket.model.Share;
import com.bridgeLabz.objectOrientedPrograms.stockMarket.service.ICompanyServices;
import com.bridgeLabz.utility.Util;

/**
 * This class has the functionality of add a newShare , remove a share if the
 * company don't want to keep in the market. also some functionality like
 * display short hand representation of the share, Complete information of the
 * share.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-07
 * @version 11.0.5
 */
public class CompanyShare {

	private static ICompanyServices companyOperation = new CompanyOperation();

	/**
	 * Allows the user to give input of Company name, Company Symbol, Price and
	 * Quantity then it creates new Object of share and checks the necessary
	 * conditions create a new Share for company. After successful creation of new
	 * Share message is displayed to the customers.
	 */
	public void addNewShare() {
		System.out.println("Enter the company Name :");
		String companyName = Util.scanner.next();
		Util.scanner.nextLine();
		System.out.println("Enter the company Symbol :");
		String companySymbol = Util.scanner.next();
		System.out.println("Enter the share price :");
		double sharePrice = Util.scanner.nextDouble();
		System.out.println("Enter the share Quantity :");
		int shareQuantity = Util.scanner.nextInt();
		Share newShare = Share.createShare(companyName, companySymbol, sharePrice, shareQuantity);
		if (companyOperation.AddShare(newShare)) {
			System.out.println("Share of " + newShare.getSymbol() + " company added sucessfully.");
		} else {
			System.out.println("Cannot add " + newShare.getName() + "'s company's share");
		}
	}

	/**
	 * Allows the user to give input of Company Symbol on the basis of symbol it
	 * search whether the share is present or not. if present then delete it from
	 * the list. After successful removal of share a perfect message is displayed to
	 * the customer.
	 */
	public void removeShare() {
		System.out.println("Enter share symbol :");
		String symbol = Util.scanner.next();
		Share existingShare = companyOperation.SearchShare(symbol);
		if (existingShare == null) {
			System.out.println("Share not found.");
			return;
		}
		if (companyOperation.removeShare(existingShare)) {
			System.out.println("Share of " + existingShare.getSymbol() + " deleted successfully.");
		} else {
			System.out.println("Error deleting record.");
		}

	}

	/**
	 * It prints only the short hand representation of the list.
	 */
	public void displayShortSharesList() {
		System.out.println("All shares of the companies :");
		companyOperation.displayShortList();
	}

	/**
	 * prints inDetail List of the data present in the list.
	 */
	public void displayIndetailShareList() {
		System.out.println("All shares of the companies :");
		companyOperation.displayFullList();
	}

}
