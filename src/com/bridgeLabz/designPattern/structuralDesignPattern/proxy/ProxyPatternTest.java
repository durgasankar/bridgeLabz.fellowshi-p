package com.bridgeLabz.designPattern.structuralDesignPattern.proxy;

/**
 * Execution of the program.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-11
 * @version 11.0.5
 */
public class ProxyPatternTest {

	public static void main(String[] args) {
		ICommandExecutor executor = new CommandExecutorProxy("durga", "r20jc134");
		try {
			executor.runCommand("du -ltr");
			executor.runCommand(" du customer.json");
		} catch (Exception e) {
			System.out.println("Exception Message::" + e.getMessage());
		}
	}

}
