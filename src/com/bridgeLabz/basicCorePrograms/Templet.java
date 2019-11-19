package com.bridgeLabz.basicCorePrograms;

import java.util.Scanner;

public class Templet {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter the userName.");
		String userName = sc.nextLine();
		printStatements(userName);

	}

	public static void printStatements(String userName) {
		if (userName.length() < 3) {
			System.out.println("Invalid UserName");
		} else {
			System.out.println("Hallo " + userName + ", How are You.");
		}
	}

}
