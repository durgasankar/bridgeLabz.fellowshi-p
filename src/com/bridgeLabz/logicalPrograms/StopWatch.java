package com.bridgeLabz.logicalPrograms;

import java.util.InputMismatchException;

import com.bridgeLabz.utility.Util;

public class StopWatch {

	private long startTime = 0;
	private long stopTime = 0;
	private boolean running = false;

	// when using this method it is not working on start time. result => 0:0:0
//	private String timeFormat(long timeInMillis) {
//		long millis = stopTime % 1000;
//		long second = (stopTime / 1000) % 60;
//		long minute = (stopTime / (1000 * 60)) % 60;
//		long hour = (stopTime / (1000 * 60 * 60)) % 24;
//
//		String time = String.format("%02d h :%02d m :%02d.%d s ", hour, minute, second, millis);
//		return time;
//	}

	/**
	 * it captures the current System time in milliseconds.
	 * 
	 * @param boolean parameter running assigned with true
	 */
	public void start() {
		this.startTime = System.currentTimeMillis();

		long millis = startTime % 1000;
		long second = (startTime / 1000) % 60;
		long minute = (startTime / (1000 * 60)) % 60;
		long hour = (startTime / (1000 * 60 * 60)) % 24;

		String time = String.format("%02d h :%02d m :%02d.%d s ", hour, minute, second, millis);

		System.out.println("Start time is : " + time);
		running = true;
	}

	/**
	 * it captures the current System time in milliseconds.
	 * 
	 * @param boolean parameter running assigned with true
	 */
	public void stop() {
		this.stopTime = System.currentTimeMillis();
		long millis = stopTime % 1000;
		long second = (stopTime / 1000) % 60;
		long minute = (stopTime / (1000 * 60)) % 60;
		long hour = (stopTime / (1000 * 60 * 60)) % 24;

		String time = String.format("%02d h :%02d m :%02d.%d s ", hour, minute, second, millis);

		System.out.println("Stop time is : " + time);

		running = false;
	}

	/**
	 * it calculate the difference between start time and end time. if not stopped
	 * it captures the System generated time and calculate the difference.
	 * 
	 * @return the time difference between startTime and endTime in milliSecond.
	 */
	public long timeEllapsedInMilliSecond() {
		long timeEllapsed;
		if (running) {
			timeEllapsed = System.currentTimeMillis() - startTime;
		} else {
			timeEllapsed = stopTime - startTime;
		}
		return timeEllapsed;
	}

	/**
	 * it calculate the difference between start time and end time. if not stopped
	 * it captures the System generated time and calculate the difference.
	 * 
	 * @return the time difference between startTime and endTime in Second.
	 */
	public long timeEllapsedInSecond() {
		long timeEllapsed;
		if (running) {
			timeEllapsed = (System.currentTimeMillis() - startTime) / 1000;
		} else {
			timeEllapsed = (stopTime - startTime) / 1000;
		}
		return timeEllapsed;
	}

	public void printInstructions() {
		System.out.println("press 1 to Start Time\n" + "press 2 to Stop Time\n"
				+ "press 3 to calculate time ellapsed in millisecond\n"
				+ "press 4 to calculate time ellapsed in seconds\n" + "press 5 to see instructions\n"
				+ "press 6 to quit the application");
	}

	/**
	 * object of StopWatch class created and watch started. waited for some time
	 * Interval and watch stopped. time difference is calculated in milliSeconds and
	 * Seconds.
	 * 
	 * @param args
	 * @throws InputMismatchException if entered value is not numeric
	 */
	public static void main(String[] args) {

		StopWatch myWatch = new StopWatch();

		System.out.println("Press '1' to Start Time: ");
		try {
			if (Util.scanner.nextInt() == 1) {
				myWatch.start();
			} else {
				System.out.println("please Enter a valid input");
			}
			System.out.println();
			System.out.println("Press '2' to Stop Time: ");
			if (Util.scanner.nextInt() == 2) {
				myWatch.stop();
			} else {
				System.out.println("please Enter a valid input");
			}
		} catch (InputMismatchException e) {
			System.out.println(e + "\nplease enter a Numeric Integer value\n");
		} finally {
			Util.scanner.close();
		}
		long tMilliSec = myWatch.timeEllapsedInMilliSecond();
		System.out.println("Time in MilliSec : " + tMilliSec + " ms");
		long tSec = myWatch.timeEllapsedInSecond();
		System.out.println("Time in Sec : " + tSec + " sec");

	}

}
