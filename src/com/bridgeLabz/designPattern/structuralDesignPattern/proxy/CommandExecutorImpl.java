package com.bridgeLabz.designPattern.structuralDesignPattern.proxy;

import java.io.IOException;

/**
 * Implementation of class which implements Common executor interface.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-11
 * @version 11.0.5
 */
public class CommandExecutorImpl implements ICommandExecutor {

	@Override
	public void runCommand(String cmd) throws IOException {
		// some heavy implementation
		Runtime.getRuntime().exec(cmd);
		System.out.println("'" + cmd + "' command executed.");
	}

}
