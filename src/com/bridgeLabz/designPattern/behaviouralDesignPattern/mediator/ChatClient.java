package com.bridgeLabz.designPattern.behaviouralDesignPattern.mediator;

/**
 * This class has the implementation of Chat.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-11
 * @version 11.0.5
 */
public class ChatClient {

	public static void main(String[] args) {
		IChatMediator mediator = new ChatMediatorImpl();
		User user1 = new UserImpl(mediator, "Ramesh");
		User user2 = new UserImpl(mediator, "Suresh");
		User user3 = new UserImpl(mediator, "Amresh");
		User user4 = new UserImpl(mediator, "Danesh");
		mediator.addUser(user1);
		mediator.addUser(user2);
		mediator.addUser(user3);
		mediator.addUser(user4);

		user1.send("Hi All");
		user2.send("Don't come today");

	}

}
