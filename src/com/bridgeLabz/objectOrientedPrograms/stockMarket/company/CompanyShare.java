package com.bridgeLabz.objectOrientedPrograms.stockMarket.company;

import java.time.LocalDate;
import java.time.LocalTime;

import com.bridgeLabz.utility.Util;

public class CompanyShare {

	private static CompanyOperation companyOperation = new CompanyOperation();

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
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();

		Share newShare = Share.createShare(companyName, companySymbol, sharePrice, shareQuantity, date, time);
		if (companyOperation.AddShare(newShare)) {
			System.out.println("Share of " + newShare.getSymbol() + " company added sucessfully.");
		} else {
			System.out.println("Cannot add " + newShare.getName() + "'s company's share");
		}
	}
	
	public void removeShare() {
		System.out.println("Enter share symbol :");
		String symbol = Util.scanner.next();
		Share existingShare = companyOperation.SearchShare(symbol);
		if(existingShare == null) {
			System.out.println("Share not found.");
			return;
		}
		if(companyOperation.removeShare(existingShare)) {
			System.out.println("Share of " + existingShare.getSymbol() + " deleted successfully.");
		}else {
			System.out.println("Error deleting record.");
		}
			
	}

	public void displayShortSharesList() {
		System.out.println("All shares of the companies :");
		companyOperation.displayShortList();
	}

	public void displayIndetailShareList() {
		System.out.println("All shares of the companies :");
		companyOperation.displayFullList();
	}

}
