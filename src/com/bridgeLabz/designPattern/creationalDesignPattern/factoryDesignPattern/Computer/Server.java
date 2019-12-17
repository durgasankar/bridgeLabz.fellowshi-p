package com.bridgeLabz.designPattern.creationalDesignPattern.factoryDesignPattern.Computer;

/**
 * This class implements Computer abstract class which has the unAbstracted
 * functionality
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-09
 * @version 11.0.5
 */

public class Server extends Computer {

	private String ram;
	private String hdd;
	private String cpu;

	/**
	 * Constructor to initialize the class during object creation
	 * 
	 * @param ram as String type input
	 * @param hdd as String type input
	 * @param cpu as String type input
	 */
	public Server(String ram, String hdd, String cpu) {
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
	}

	@Override
	public String getRAM() {
		return this.ram;
	}

	@Override
	public String getHDD() {
		return this.hdd;
	}

	@Override
	public String getCPU() {
		return this.cpu;
	}

}
