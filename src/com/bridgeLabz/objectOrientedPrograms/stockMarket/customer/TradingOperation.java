package com.bridgeLabz.objectOrientedPrograms.stockMarket.customer;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import com.bridgeLabz.objectOrientedPrograms.stockMarket.company.CompanyOperation;
import com.bridgeLabz.objectOrientedPrograms.stockMarket.company.Share;
import com.bridgeLabz.utility.Util;

public class TradingOperation {

	protected static ArrayList<Share> customerShareList;

	public TradingOperation() {
		customerShareList = new ArrayList<Share>();
	}

	private CompanyOperation companyOperation = new CompanyOperation();

//	public void purchaseShare() {
//		System.out.println("Enter Share sysmbol :");
//		String inputSymbol = Util.scanner.next();
//		Share foundShare = findShare(inputSymbol);
//		if (foundShare == null) {
//			System.out.println(inputSymbol + " share not found in found.");
//		}
//		System.out.println("Enter Quantity you want ti buy :");
//		int quantity = Util.scanner.nextInt();
//		String name = foundShare.getName();
//		String symbol = foundShare.getSymbol();
//		double price = foundShare.getPrice();
//		LocalDate date = LocalDate.now();
//		LocalTime time = LocalTime.now();
//		Share.createShare(name, symbol, price, quantity, date, time);
//
////		if ( < 0) {
////			System.out.println("share not present.");
////		}
////		Share getShare = findShare(foundPosition);
////		int availableQuantity = getShare.getQuantity();
////		customerShareList.add(getShare);
////		companyOperation.getCompanyShareList().rem
////		System.out.println("Share of comapany " + getShare.getSymbol() + " purchased sucessFully");
////		return true;
//	}

	public void purchase() {
		System.out.println("Enter Share sysmbol :");
		String inputSymbol = Util.scanner.next();
		Share foundShare = findShare(inputSymbol);
		if (foundShare == null) {
			System.out.println(inputSymbol + " share not found in found.");
		}

		int foundPosition = findShare(foundShare);
		if (foundPosition < 0) {
			System.out.println("company Share " + foundShare.getSymbol() + " was not found.");
			return;
		}
		System.out.println("Enter Quantity you want ti buy :");
		int quantity = Util.scanner.nextInt();

		if (foundShare.getQuantity() < quantity) {
			System.out.println("Opps! availabe quantity : " + foundShare.getQuantity());
			return;
		}
		int updatedQuantity = foundShare.getQuantity() - quantity;
		String name = foundShare.getName();
		String symbol = foundShare.getSymbol();
		double price = foundShare.getPrice();
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		Share UpdatedShare = Share.createShare(name, symbol, price, updatedQuantity, date, time);
		CompanyOperation.companyShareList.set(foundPosition, UpdatedShare);
		Share customerPurchase = Share.createShare(name, symbol, price, quantity, date, time);
		if (customerShareList.add(customerPurchase)) {
			System.out.println("Thank you for purchasing " + customerPurchase.getSymbol() + " Share.");
		} else {
			System.out.println("Error purchasing share.");

		}

	}

	private int findShare(Share share) {
		for (int i = 0; i < companyOperation.getCompanyShareList().size(); i++) {
			String companyShareSymbol = companyOperation.getCompanyShareList().get(i).getSymbol();
			if (share.getSymbol().equalsIgnoreCase(companyShareSymbol)) {
				return i;
			}
		}
		return -1;
	}

//	private Share findShare(int position) {
//		return this.companyOperation.getCompanyShareList().get(position);
//
//	}

	private Share findShare(String symbol) {
		for (int i = 0; i < CompanyOperation.companyShareList.size(); i++) {

			if (symbol.equals(CompanyOperation.companyShareList.get(i).getSymbol())) {
				return CompanyOperation.companyShareList.get(i);
			}
		}
		return null;
	}

	public void displayCustomerShortList() {
		System.out.println("Symbol\t  \tQuantity");
		for (int i = 0; i < customerShareList.size(); i++) {
			Share getShareIndex = customerShareList.get(i);
			System.out.println(getShareIndex.getSymbol() + "\t->\t" + getShareIndex.getQuantity());
		}
	}

}
