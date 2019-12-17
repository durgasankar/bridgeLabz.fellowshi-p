package com.bridgeLabz.designPattern.behaviouralDesignPattern.mediator;

/**
 * This interface has the undefined functionality of sendMessage and addUser.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-11
 * @version 11.0.5
 */
public interface IChatMediator {

	public void sendMessage(String msg, User user);

	void addUser(User user);
}
