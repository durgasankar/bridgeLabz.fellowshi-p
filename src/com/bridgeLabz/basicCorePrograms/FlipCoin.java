package com.bridgeLabz.basicCorePrograms;

import java.util.Scanner;

public class FlipCoin {
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter Number of Times coin to be flipped");
		int times = sc.nextInt();
		flipPercentage(times);
	}
	
	private static void flipPercentage(int times) {
		double heads = 0;
		for (int i = 0; i <= times; i++) {
			if (Math.random() > 0.5) {
				heads++;
			}
		}
		System.out.println("heads percentage = " + (float) (heads / times) * 100);
	}

}
