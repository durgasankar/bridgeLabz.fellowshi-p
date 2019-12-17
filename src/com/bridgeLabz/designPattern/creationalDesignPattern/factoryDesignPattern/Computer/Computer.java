package com.bridgeLabz.designPattern.creationalDesignPattern.factoryDesignPattern.Computer;

/**
 * This is the abstract class which has the 3 abstract functions and a to String
 * method.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-09
 * @version 11.0.5
 */
public abstract class Computer {

	public abstract String getRAM();

	public abstract String getHDD();

	public abstract String getCPU();

	@Override
	public String toString() {
		return "\t\tRAM = " + this.getRAM() + "\n\t\tHDD = " + this.getHDD() + "\n\t\tCPU = " + this.getCPU();
	}

}
