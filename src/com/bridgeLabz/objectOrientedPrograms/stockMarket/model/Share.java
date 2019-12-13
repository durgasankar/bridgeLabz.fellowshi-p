package com.bridgeLabz.objectOrientedPrograms.stockMarket.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This class has the all functionality of a stock Share like name, symbol,
 * price, quantity, Time, Date.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-07
 * @modified 2019-12-12
 * @updated -> new constructor added and share time and date formatter added.
 * @version 11.0.5
 */

public class Share {
	private String name;
	private String symbol;
	private double price;
	private int quantity;
	private String dateTime;

	/**
	 * Constructor to initialize the following parameter.
	 * 
	 * @param name     as String input parameter of the Stock.
	 * @param symbol   as String input representation of the Stock.
	 * @param price    as double input parameter
	 * @param quantity as Integer input parameter.
	 * @param dateTime as Local System date and time
	 */
	public Share(String name, String symbol, double price, int quantity, String dateTime) {
		this.name = name;
		this.symbol = symbol;
		this.price = price;
		this.quantity = quantity;
		this.dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	}

	/**
	 * Constructor to initialize the following parameter.
	 * 
	 * @param name     as String input parameter of the Stock.
	 * @param symbol   as String input representation of the Stock.
	 * @param price    as double input parameter
	 * @param quantity as Integer input parameter.
	 */
	public Share(String name, String symbol, double price, int quantity) {
		this.name = name;
		this.symbol = symbol;
		this.price = price;
		this.quantity = quantity;
		this.dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	}

	/**
	 * getter method to getName of the Share.
	 * 
	 * @return String value.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter method to set the name of the Stock
	 * 
	 * @param name as String input parameter
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getter method to getSymbol of the Share.
	 * 
	 * @return String value.
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * Setter method to set Symbol of the Stock
	 * 
	 * @param symbol as String input parameter
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * getter method to getPrice of the Share.
	 * 
	 * @return String value.
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Setter method to set Price of the Stock
	 * 
	 * @param price as Double input parameter
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * getter method to getQuantity of the Share.
	 * 
	 * @return Integer value
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Setter method to set the quantity of the Stock.
	 * 
	 * @param quantity as integer type input parameter.
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * getter method to getDate of the Share.
	 * 
	 * @return String value
	 */
	public String getDateTime() {
		return dateTime;
	}

	/**
	 * This function takes name, symbol, price, quantity, date, time as input
	 * parameter and returns new Class type new Object.
	 * 
	 * @param name     as String input parameter of the Stock.
	 * @param symbol   as String input representation of the Stock.
	 * @param price    as double input parameter
	 * @param quantity as Integer input parameter.
	 * @param date     as Local System date
	 * @param time     as local System time.
	 * @return Class type new Share
	 */
	public static Share createShare(String name, String symbol, double price, int quantity, String dateTime) {
		return new Share(name, symbol, price, quantity, dateTime);
	}

	/**
	 * This function takes name, symbol, price, quantity as input parameter and
	 * returns new Class type new Object.
	 * 
	 * @param name     as String input parameter of the Stock.
	 * @param symbol   as String input representation of the Stock.
	 * @param price    as double input parameter
	 * @param quantity as Integer input parameter.
	 * @return Class type new Share
	 */
	public static Share createShare(String name, String symbol, double price, int quantity) {
		return new Share(name, symbol, price, quantity);
	}

}
