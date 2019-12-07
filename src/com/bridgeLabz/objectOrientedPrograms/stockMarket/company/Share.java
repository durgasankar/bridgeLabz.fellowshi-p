package com.bridgeLabz.objectOrientedPrograms.stockMarket.company;

import java.time.LocalDate;
import java.time.LocalTime;

public class Share {

	private String name;
	private String symbol;
	private double price;
	private int quantity;
	public Share(String name, String symbol, double price, int numberOfShare, LocalDate date, LocalTime time) {
		this.name = name;
		this.symbol = symbol;
		this.price = price;
		this.quantity = numberOfShare;
		getCurrentDate();
		getCurrentTime();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getCurrentDate() {
		return java.time.LocalDate.now();
	}

	public LocalTime getCurrentTime() {
		return java.time.LocalTime.now();
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public static Share createShare(String name, String symbol, double price, int quantity, LocalDate date,
			LocalTime time) {
		return new Share(name, symbol, price, quantity, date, time);
	}

}
