package com.bridgeLabz.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Util {

	public static Scanner scanner = new Scanner(System.in);

	/**
	 * check for leap year and returns boolean value if the year lies between 1000
	 * and 10000.
	 * 
	 * @param year as a parameter and checks whether it is prime or not.
	 * @return boolean value is it is leap year.
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
	 * if file not exist it will create a file . and write into it.
	 * 
	 * @param data     as a parameter which is need to be written
	 * @param fileName as the location of the file
	 * @throws Exception if any abnormal condition occurs
	 */
	public static void writeToFile(String data, String fileName) throws Exception {
		File file = new File(fileName);
		if (!file.exists()) {
			file.createNewFile();
		}
		FileWriter writer = new FileWriter(file);
		// Writes the content to the file
		writer.write(data);
		writer.flush();
		writer.close();
	}

	/**
	 * it takes the file address and splitting basis as a parameter and splits the
	 * written documents and returns String array on basis of splitting.
	 * 
	 * @param fileName      address as a parameter .
	 * @param splitingBasis as a parameter on the basis of which it splits.
	 * @return String array of words on the basis of splitting.
	 */
	public static String[] readFiles(String fileName) {
		File file = new File(fileName);
		FileReader fileReader = null;
		BufferedReader bufferReader;
		String readLine = "";
		String tempString;
		try {
			fileReader = new FileReader(file);
		} catch (FileNotFoundException e) {
			System.out.println("File Not found!");
		}
		bufferReader = new BufferedReader(fileReader);

		try {
			while ((tempString = bufferReader.readLine()) != null) {
				readLine += tempString;
			}
			bufferReader.close();
		} catch (IOException e) {
			System.out.println(e + " back trace exception");
		}
		String[] words = readLine.split(",");

		return words;
	}

}
