package com.bridgeLabz.designPattern.creationalDesignPattern.factoryDesignPattern.Computer;

/**
 * ComputerFactory class has a function named getComputer when it is called it
 * returns the new Instance of that class which is being called.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-09
 * @version 11.0.5
 */
public class ComputerFactory {
	/**
	 * * Takes String as class name type input parameter returns new object of that
	 * particular class whose name is passed through it.
	 * 
	 * @param type as Class name String input parameter
	 * @param ram  as String input parameter
	 * @param hdd  as String input parameter
	 * @param cpu  as String input parameter
	 * @return new Object of reference type
	 */
	public static Computer getComputer(String type, String ram, String hdd, String cpu) {
		if (type.equalsIgnoreCase("PC")) {
			return new PC(ram, hdd, cpu);
		} else if (type.equalsIgnoreCase("SERVER")) {
			return new Server(ram, hdd, cpu);
		} else {
			return null;
		}
	}

}
