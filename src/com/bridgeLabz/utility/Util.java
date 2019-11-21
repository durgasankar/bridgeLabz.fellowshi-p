package com.bridgeLabz.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/**
 * It contains basic reusable methods like => isLeapYear, => isAnagram, =>
 * isPallindrome, => isPrime, => powerOfTwo, => writeToFile, => read file
 * 
 * @author Durgasankar Mishra
 * @created 2019-11-13
 * @version 11.0.5
 */
public class Util {

	public static Scanner scanner = new Scanner(System.in);

	/**
	 * find 2^power given by user
	 * 
	 * @param power as input
	 * @return integer value
	 * @created 2019-11-21
	 */
	public static int powerOfTwo(int power) {
		int result = (int) Math.pow(2, power);
		return result;
	}

	/**
	 * check for leap year and returns boolean value if the year lies between 1000
	 * and 10000.
	 * 
	 * @param year as a parameter and checks whether it is prime or not.
	 * @return boolean value is it is leap year.
	 * @created 2019-11-13
	 */
	public static boolean isLeapYear(int year) {
		if (year >= 1000 && year < 10000) {
			if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * After taking string as input => converts to lower case and removes space =>
	 * convert to character array and store it . if length of the character array
	 * matches => sort all the letters in the array => match each characters. if
	 * matches it returns boolean value.
	 * 
	 * @param firstString  as parameter from user.
	 * @param secondString as parameter from user.
	 * @return boolean value if it satisfies the conditions
	 * @created 2019-11-20
	 */
	public static boolean isAnagram(String firstString, String secondString) {
		char[] ch1 = firstString.toLowerCase().replaceAll(" ", "").toCharArray();
		char[] ch2 = secondString.toLowerCase().replaceAll(" ", "").toCharArray();

		if (ch1.length != ch2.length) {
			return false;
		} else {
			Arrays.sort(ch1);
			Arrays.sort(ch2);
			if (Arrays.equals(ch1, ch2)) {
//				System.out.println("Anagram");
				return true;
			}
		}
		return false;
	}

	/**
	 * Input String is transfered to temporary string => char array. Swapped char
	 * array is compared with not swapped char array if both equals => returns
	 * boolean value
	 * 
	 * @param inputString as a parameter form the user.
	 * @return boolean value if satisfies logic.
	 * @created 2019-11-20
	 */
	public static boolean isPallindrome(String inputString) {
		String tempString = inputString;
		char[] ch1 = inputString.toCharArray();
		char[] ch2 = tempString.toCharArray();
//		System.out.println("Before : " + inputString);
		int lastChar = ch1.length - 1;
		/**
		 * first character is swapped with last character . loop continues till mid
		 * character. if odd then mid char is not swapped.
		 */
		for (int i = 0; i < ch1.length / 2; i++) {
			char temp = ch1[i];
			ch1[i] = ch1[lastChar - i];
			ch1[lastChar - i] = temp;
		}
		if (Arrays.equals(ch1, ch2)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * checks the conditions and returns whether the input value is prime or not.
	 * {@code only works for if number is greater than 1}
	 * 
	 * @param number integer value to check whether prime or not.
	 * @return boolean value.
	 * @created 2019-11-20
	 */
	public static boolean isPrime(int number) {
		if (number <= 0) {
			return false;
		} else {
			if (number == 1) {
				return false;
			} else {
				/**
				 * continues till the middle of the number. checks whether number is divisible
				 * by divisor if divisible returns boolean value.
				 */
				for (int divisor = 2; divisor <= number / 2; divisor++) {
					if (number % divisor == 0) {
						return false;
					}
				}
			}
			return true;
		}
	}

	/**
	 * it takes the file address and splitting basis as a parameter and splits the
	 * written documents and returns String array on basis of splitting.
	 * 
	 * @param fileName      address as a parameter .
	 * @param splitingBasis as a parameter on the basis of which it splits.
	 * @return String array of words on the basis of splitting.
	 * @created 2019-11-19
	 */

	/**
	 * takes input parameter date in String and returns date in Date format.
	 * 
	 * @param date as String format.
	 * @return date in dd/mm/yyyy format
	 */
	public static Date printDate(String date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			return null;
		}

	}

	/**
	 * takes file location as parameter and read the file in string format.
	 * 
	 * @param fileName as parameter to locate the file
	 * @return String data of file after reading.
	 * @created 2019-11-21
	 */
	public static String readFile(String fileName) {
		File file = new File(fileName);
		Scanner sc = null;
		String data = "";
		try {
			sc = new Scanner(file);

			while (sc.hasNextLine()) {
				data += sc.nextLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} finally {
			sc.close();
		}
		return data;
	}

	/**
	 * Takes input data and file location as i/p and writes in the file if file not
	 * present it creates and write in it. if present it simply writes in it.
	 * 
	 * @param data     as input String to be written in document.
	 * @param fileName as address of the file.
	 * @returns nothing because after writing it closes the file
	 * @created 2019-11-21
	 */
	public static void writeToFile(String data, String fileName) {
		File file = new File(fileName);
		FileWriter writer = null;
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			// Writes the content to the file
			writer = new FileWriter(file);
			writer.write(data);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
