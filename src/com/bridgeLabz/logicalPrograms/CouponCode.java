package com.bridgeLabz.logicalPrograms;

import java.util.Random;
import java.util.Scanner;

public class CouponCode {
	/**
	 * User gives the input by using Scanner Class of length of Coupon code
	 * required. Randomly the coupon code is generated from Upper case, Lower case
	 * and numeric values.
	 * 
	 * @author durgasankar Mishra
	 * @created 2019-11-13
	 * @version 1.0
	 */
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter the Length of coupon :");
		int length = scanner.nextInt();
		coupon(length);

	}

	/**
	 * A String is converted to character Array. Randomly the index Number of the
	 * character Array is chosen. That value of the index Number is picked up. By
	 * using String Builder all the characters are being combined to make a String
	 * and displayed
	 * 
	 * @param length gives the input of length of coupon code he requires.
	 */
	private static void coupon(int length) {
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		char[] ch = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 1; i <= length; i++) {
			char c = ch[random.nextInt(ch.length)];
			sb.append(c);
		}
		String coupon = sb.toString();
		System.out.println(coupon);

	}

}
