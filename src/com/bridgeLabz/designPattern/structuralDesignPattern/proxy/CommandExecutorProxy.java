package com.bridgeLabz.designPattern.structuralDesignPattern.proxy;

/**
 * Implementation of ProxyDesign pattern
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-11
 * @version 11.0.5
 */
public class CommandExecutorProxy implements ICommandExecutor {
	private boolean isAdmin;
	private ICommandExecutor executor;

	/**
	 * if condition satisfies assign value of admit to true.
	 * 
	 * @param user String type input
	 * @param pwd  String type input
	 */
	public CommandExecutorProxy(String user, String pwd) {
		if ("durga".equals(user) && "r20jc134".equals(pwd))
			isAdmin = true;
		executor = new CommandExecutorImpl();
	}

	/**
	 * takes command as String type input and checks for conditions.
	 */
	@Override
	public void runCommand(String cmd) throws Exception {
		if (isAdmin) {
			executor.runCommand(cmd);
		} else {
			if (cmd.trim().startsWith("du")) {
				throw new Exception("du command is not allowed for non-admin users.");
			} else {
				executor.runCommand(cmd);
			}
		}
	}

}
