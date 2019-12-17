package com.bridgeLabz.objectOrientedPrograms.stockMarket.service;

import java.util.ArrayList;

import com.bridgeLabz.objectOrientedPrograms.stockMarket.model.Share;

/**
 * This Interface has the unimplemented methods of Company Service
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-12
 * @version 11.0.5
 */
public interface ICompanyServices {

	/**
	 * Getter method to get arrayList
	 * 
	 * @return ArrayList of <Share> type
	 */
	ArrayList<Share> getCompanyShareList();

	/**
	 * add a new Share.
	 * 
	 * @param newShare of class type as input parameter.
	 * @return Boolean value
	 */
	boolean AddShare(Share newShare);

	/**
	 * remove a Share.
	 * 
	 * @param share as class type input parameter
	 * @return boolean value
	 */
	boolean removeShare(Share share);

	/**
	 * Search a share.
	 * 
	 * @param symbol as String input parameter.
	 * @return <Share> Class type input parameter.
	 */
	Share SearchShare(String symbol);

	/**
	 * Display only the Symbol and Quantity of all the stocks present in the list by
	 * iterating through the loop.
	 */
	void displayShortList();

	/**
	 * Prints in detail list giving all informations of the stock iterating through
	 * the loop.
	 */
	void displayFullList();

}