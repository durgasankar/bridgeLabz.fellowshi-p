package com.bridgeLabz.designPattern.behaviouralDesignPattern.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements Interface and defines the functionality of that
 * interface.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-11
 * @version 11.0.5
 */
public class ChatMediatorImpl implements IChatMediator {

	private List<User> users;

	public ChatMediatorImpl() {
		this.users = new ArrayList<>();
	}

	/**
	 * adding user to the list .
	 */
	@Override
	public void addUser(User user) {
		this.users.add(user);
	}

	/**
	 * Sending message -> except sender user all will receive message
	 */
	@Override
	public void sendMessage(String msg, User user) {
		for (User usr : users) {
			// message should not be received by the user sending it
			if (usr != user) {
				usr.receive(msg);
			}
		}
	}

}
