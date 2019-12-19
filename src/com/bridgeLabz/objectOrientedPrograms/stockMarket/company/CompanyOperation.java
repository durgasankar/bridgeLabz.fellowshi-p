package com.bridgeLabz.objectOrientedPrograms.stockMarket.company;

import java.util.ArrayList;

import com.bridgeLabz.objectOrientedPrograms.stockMarket.model.Share;
import com.bridgeLabz.objectOrientedPrograms.stockMarket.recordDetails.Transaction;
import com.bridgeLabz.objectOrientedPrograms.stockMarket.service.ICompanyServices;

/**
 * This class has the functionality of add a new share, remove a share, find a
 * share from the list, print short hand representation of the list, print
 * inDetail data present in the list.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-06
 * @modified 2019-12-12
 * @updated -> addition of interface. addition of findShare
 * @version 11.0.5
 */
public class CompanyOperation extends Transaction implements ICompanyServices {
	public static ArrayList<Share> companyShareList;

	/**
	 * Constructor to initialize generic type ArrayList.
	 */
	public CompanyOperation() {
		companyShareList = new ArrayList<Share>();
	}

	/**
	 * Getter method to get arrayList
	 * 
	 */
	@Override
	public ArrayList<Share> getCompanyShareList() {
		return companyShareList;
	}

	/**
	 * takes Share class type input as input parameter and checks whether it is
	 * present or not. if not present then add the share to the Company's list.
	 */
	@Override
	public boolean AddShare(Share newShare) {
		if (findShare(newShare.getSymbol()) >= 0) {
			System.out.println("Share already exist.");
			return false;
		}
		companyShareList.add(newShare);
		// queue operation
		transactionDateTime.enQueue(newShare.getDateTime());
		// linkedList operation
		linkedListOperation.insert(newShare);
		return true;
	}

	/**
	 * Overloaded method of findShare takes symbol as input parameter it matches
	 * with all the Share present in the list. if matches it returns the index value
	 * of the contact which is greater than equals to zero.
	 * 
	 * @param symbol as input parameter to check.
	 * @return integer value
	 */
	private int findShare(String symbol) {
		for (int i = 0; i < companyShareList.size(); i++) {
			Share fetchedShare = companyShareList.get(i);
			if (fetchedShare.getSymbol().equals(symbol)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * This function takes Share as input parameter and checks whether it is Present
	 * or not, if found then successfully delete the Share else reply with a message
	 * that Share not exist.
	 * 
	 */
	@Override
	public boolean removeShare(Share share) {
		int foundPosition = findShare(share.getSymbol());
		if (foundPosition < 0) {
			System.out.println(share.getSymbol() + " not found.");
			return false;
		}
		companyShareList.remove(foundPosition);
		// queue operation
		transactionDateTime.enQueue(findShare(foundPosition));
		// linkedList operation
		linkedListOperation.delete(foundPosition);
		System.out.println("Share of comapany " + share.getName() + " successfully removed.");
		return true;
	}

	/**
	 * takes index position as input parameter and returns share time of that
	 * position
	 * 
	 * @param indexPosition as Integer input parameter
	 * @return Share Class type data.
	 */
	private String findShare(int indexPosition) {
		return companyShareList.get(indexPosition).getDateTime();
	}

	/**
	 * Takes symbol as input parameter and matches with all index of list. If found
	 * then return the particular class.
	 * 
	 */
	@Override
	public Share SearchShare(String symbol) {
		int position = findShare(symbol);
		if (position >= 0) {
			return companyShareList.get(position);
		}
		return null;
	}

	/**
	 * Display only the Symbol and Quantity of all the stocks present in the list by
	 * iterating through the loop.
	 */
	@Override
	public void displayShortList() {
		System.out.println("Symbol\t  \tQuantity");
		for (int i = 0; i < companyShareList.size(); i++) {
			Share getShareIndex = companyShareList.get(i);
			System.out.println(getShareIndex.getSymbol() + "\t->\t" + getShareIndex.getQuantity());
		}
	}

	/**
	 * Prints in detail list giving all informations of the stock iterating through
	 * the loop.
	 */
	@Override
	public void displayFullList() {
		System.out.println("Symbol\t  \tQuantity");
		for (int i = 0; i < companyShareList.size(); i++) {
			Share getShareIndex = companyShareList.get(i);
			System.out.println("Name : " + getShareIndex.getName() + ", Symbol : " + getShareIndex.getSymbol()
					+ ", price :" + getShareIndex.getPrice() + ", quantity : " + getShareIndex.getQuantity());

		}
	}

}
