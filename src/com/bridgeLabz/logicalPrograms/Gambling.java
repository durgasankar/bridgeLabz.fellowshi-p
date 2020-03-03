package com.bridgeLabz.logicalPrograms;

import com.bridgeLabz.utility.Util;

/**
 * This class has the functionality of gambling.
 * 
 * @author Durgasankar Mishra
 * @created 2019-11-13
 * @version 1.0
 */
public class Gambling {
	public static void main(String[] args) {
		System.out.println("Enter the stack amount : ");
		int stack = Util.scanner.nextInt();
		System.out.println("Enter the goal : ");
		int goal = Util.scanner.nextInt();
		System.out.println("Enter the trial : ");
		int trial = Util.scanner.nextInt();

		gambling(stack, goal, trial);

	}

	/**
	 * 
	 * @param stake as integer
	 * @param goal  as integer
	 * @param trial as integer
	 */
	private static void gambling(int stake, int goal, int trial) {
		int bet = 0;
		int win = 0;
		/**
		 * Transfer amount to stake and loop continues till trials equalize with initial
		 * value.
		 */
		for (int i = 1; i <= trial; i++) {
			int amount = stake;
			/**
			 * This loop continues till amount reaches goal with positive amount value.Every
			 * time it generate random number and checks if it is greater than 0.5 then win
			 * increases.
			 */
			while (amount >= 0 && amount <= goal) {
				bet++;
				if (Math.random() >= 0.5) {
					amount++;
				}
				amount--;
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
