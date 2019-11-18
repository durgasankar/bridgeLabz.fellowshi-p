package com.bridgeLabz.logicalPrograms;

import java.util.Scanner;

public class Gambling {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter the stack amount : ");
		int stack = sc.nextInt();
		System.out.println("Enter the goal : ");
		int goal = sc.nextInt();
		System.out.println("Enter the trial : ");
		int trial = sc.nextInt();

		gambling(stack, goal, trial);

	}

	private static void gambling(int stake, int goal, int trial) {
		int bet = 0;
		int win = 0;
		for (int i = 1; i <= trial; i++) {
			int amount = stake;
			while (amount >= 0 && amount <= goal) {
				bet++;
				if (Math.random() >= 0.5) {
					amount++;
				} else {
					amount--;
				}
				if (amount == goal) {
					win++;
				}
			}
		}
		System.out.println("Total win : " + win);
		System.out.println("Win percentage : " + (int) (100 * win / trial));
		System.out.println("Average Bet : " + bet / trial);
	}

}
