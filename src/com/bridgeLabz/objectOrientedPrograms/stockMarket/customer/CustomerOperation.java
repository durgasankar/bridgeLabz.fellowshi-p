package com.bridgeLabz.objectOrientedPrograms.stockMarket.customer;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import com.bridgeLabz.objectOrientedPrograms.stockMarket.company.CompanyOperation;
import com.bridgeLabz.objectOrientedPrograms.stockMarket.company.Share;
import com.bridgeLabz.utility.Util;

public class CustomerOperation {

	public static ArrayList<Share> customerShareList;

	public CustomerOperation() {
		customerShareList = new ArrayList<Share>();
	}

	private CompanyOperation companyOperation = new CompanyOperation();

	public void buyShare() {
		System.out.println("Enter Share symbol :");
		String inputSymbol = Util.scanner.next();
		Share foundShare = findShare(CompanyOperation.companyShareList, inputSymbol);
		if (foundShare == null) {
			System.out.println(inputSymbol + " share not found in found.");
		}

		int foundPosition = findShare(companyOperation.getCompanyShareList(), foundShare);
		if (foundPosition < 0) {
			System.out.println("company Share " + foundShare.getSymbol() + " was not found.");
			return;
		}
		System.out.println("Enter Quantity you want to buy :");
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

	private int findShare(ArrayList<Share> list, Share share) {
		for (int i = 0; i < list.size(); i++) {
			String shareSymbol = list.get(i).getSymbol();
			if (share.getSymbol().equals(shareSymbol)) {
				return i;
			}
		}
		return -1;
	}

	private Share findShare(ArrayList<Share> list, String symbol) {
		for (int i = 0; i < list.size(); i++) {

			if (symbol.equals(list.get(i).getSymbol())) {
				return list.get(i);
			}
		}
		return null;
	}

	public void displayCustomerPortfolio() {
		System.out.println("Symbol\t  \tQuantity");
		for (int i = 0; i < customerShareList.size(); i++) {
			Share getShareIndex = customerShareList.get(i);
			System.out.println(getShareIndex.getSymbol() + "\t->\t" + getShareIndex.getQuantity());
		}
	}

	public void sellShare() {
		System.out.println("Enter Share sysmbol :");
		String inputSymbol = Util.scanner.next();
		Share foundShareInCompany = findShare(CompanyOperation.companyShareList, inputSymbol);
		if (foundShareInCompany == null) {
			System.out.println(inputSymbol + " share not found in company.");
		}
		int foundCompanyPosition = findShare(companyOperation.getCompanyShareList(), foundShareInCompany);
		if (foundCompanyPosition < 0) {
			System.out.println("company Share " + foundShareInCompany.getSymbol() + " was not found.");
			return;
		}

		Share foundShareInCustomer = findShare(customerShareList, inputSymbol);
		if (foundShareInCustomer == null) {
			System.out.println(inputSymbol + " share not found in found");
		}
		int foundCustomerPosition = findShare(customerShareList, foundShareInCustomer);
		if (foundCustomerPosition < 0) {
			System.out.println("customer Share " + foundShareInCustomer.getSymbol() + " was not found.");
			return;
		}

		System.out.println("Enter Quantity you want to sell :");
		int quantity = Util.scanner.nextInt();
		int updatedCompanyQuantity = foundShareInCompany.getQuantity() + quantity;
		int updatedCustomerQuantity = foundShareInCustomer.getQuantity() - quantity;
		String name = foundShareInCompany.getName();
		String symbol = foundShareInCompany.getSymbol();
		double price = foundShareInCompany.getPrice();
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		Share UpdatedCustomerShare = Share.createShare(name, symbol, price, updatedCustomerQuantity, date, time);
		Share UpdatedCompanyShare = Share.createShare(name, symbol, price, updatedCompanyQuantity, date, time);

		if (foundShareInCustomer.getQuantity() < quantity) {
			System.out.println("Opps! availabe quantity : " + foundShareInCustomer.getQuantity());
		} else if (foundShareInCustomer.getQuantity() == quantity) {
			CompanyOperation.companyShareList.set(foundCompanyPosition, UpdatedCompanyShare);
			customerShareList.remove(foundCustomerPosition);
			System.out.println("all quantity of share " + foundShareInCompany.getSymbol() + " sold.");
		} else {
			CompanyOperation.companyShareList.set(foundCompanyPosition, UpdatedCompanyShare);
			customerShareList.set(foundCustomerPosition, UpdatedCustomerShare);
			System.out
					.println("Sold quantity " + quantity + " remaining quantity " + UpdatedCustomerShare.getQuantity());
		}

	}

}
