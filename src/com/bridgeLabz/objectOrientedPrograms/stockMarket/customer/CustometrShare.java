package com.bridgeLabz.objectOrientedPrograms.stockMarket.customer;

import java.time.LocalDate;
import java.time.LocalTime;

import com.bridgeLabz.objectOrientedPrograms.stockMarket.company.CompanyOperation;
import com.bridgeLabz.objectOrientedPrograms.stockMarket.company.Share;
import com.bridgeLabz.utility.Util;

public class CustometrShare {
	
	private CompanyOperation companyOperation = new CompanyOperation();
	
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

}
