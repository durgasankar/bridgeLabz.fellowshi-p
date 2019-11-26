package com.bridgeLabz.dataStructurePrograms;

import com.bridgeLabz.dataStructurePrograms.generics.Queue;

/**
 * This class bears the functionality of bank to deposit the amount and withdraw
 * the amount from the bank by passing the parameter of account number in
 * constructor.
 * 
 * @author Durgasankar Mishra
 * @created 2019-11-26
 * @version 11.0.5
 */
public class BankAccount {
	private String AccountNumber;
	private double balance = 0.0;
	private Queue<Double> transactions;

	/**
	 * Ask the user to give the input account number of String type which will be
	 * passed through constructor during object creation.
	 * 
	 * @param accountNumber of String type.
	 */
	public BankAccount(String accountNumber) {
		this.AccountNumber = accountNumber;
		this.transactions = new Queue<Double>();
	}

	/**
	 * getter method to get account number.
	 * 
	 * @return Account number of String type.
	 */
	public String getAccountNumber() {
		return AccountNumber;
	}

	/**
	 * Ask the user to input the amount he want to deposit in bank the amount should
	 * be positive non zero value.
	 * 
	 * @param amount as double parameter.
	 */
	public void deposit(double amount) {
		if (amount < 0) {
			System.out.println("Can not deposit negative amount... current balance : " + this.balance);
		} else if (amount == 0) {
			System.out.println(" Can not add Zero amount to the account... current balance : " + this.balance);
		} else {
			transactions.enQueue(amount);
			this.balance += amount;
			System.out.println(amount + " Amount deposited Successfully... Current balance : " + this.balance);
			System.out.println("All transactions are :\n");
			transactions.print();
		}
	}

	/**
	 * Ask the user to input the amount which he want to withdraw. The withdrawal
	 * balance should be less than available balance in the bank and should be
	 * positive value.
	 * 
	 * @param amount as double parameter
	 */
	public void withdrawAmount(double amount) {
		if (amount > balance) {
			System.out.println("withdrawl not possible.. current balance :" + this.balance);
		} else {
			double withdrawlAmount = -amount;
			if (withdrawlAmount < 0) {
				transactions.enQueue(withdrawlAmount);
				this.balance += withdrawlAmount;
				System.out.println(amount + " Amount Withdrawn Successfully... Current balance : " + this.balance);
				System.out.println("All transactions are :\n");
				transactions.print();
			} else {
				System.out.println("Can not Withdraw negative amount... Current balance : " + this.balance);
			}
		}
	}

}
