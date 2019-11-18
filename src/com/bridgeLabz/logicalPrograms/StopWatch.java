package com.bridgeLabz.logicalPrograms;

public class StopWatch {

	private long startTime = 0;
	private long stopTime = 0;
	private boolean running = false;

	/**
	 * it captures the current System time in milliseconds.
	 * 
	 * @param boolean parameter running assigned with true
	 */
	public void start() {
		this.startTime = System.currentTimeMillis();
		System.out.println("Start time is : " + startTime);
		running = true;
	}

	/**
	 * it captures the current System time in milliseconds.
	 * 
	 * @param boolean parameter running assigned with true
	 */
	public void stop() {
		this.stopTime = System.currentTimeMillis();
		System.out.println("Stop time is : " + stopTime);
		this.running = false;
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
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		StopWatch myWatch = new StopWatch();

		myWatch.start();
		Thread.sleep(8000);
		myWatch.stop();

		long tMilliSec = myWatch.timeEllapsedInMilliSecond();
		System.out.println("Time in MilliSec : " + tMilliSec + " ms");
		long tSec = myWatch.timeEllapsedInSecond();
		System.out.println("Time in Sec : " + tSec + " sec");

	}

}
