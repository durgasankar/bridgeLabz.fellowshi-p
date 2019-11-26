package com.bridgeLabz.dataStructurePrograms;

import com.bridgeLabz.dataStructurePrograms.generics.Queue;

public class BankAccount {
	private String AccountNumber;
	private double balance = 0.0;
	private Queue<Double> transactions;

	public BankAccount(String accountNumber) {
		this.AccountNumber = accountNumber;
		this.transactions = new Queue<Double>();
	}

	public String getAccountNumber() {
		return AccountNumber;
	}

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
