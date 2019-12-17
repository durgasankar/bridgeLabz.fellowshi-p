package com.bridgeLabz.designPattern.behaviouralDesignPattern.mediator;

/**
 * This is the user class which takes MediatoR and name of the object during
 * object creation
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-11
 * @version 11.0.5
 */
public abstract class User {
	protected IChatMediator mediator;
	protected String name;

	public User(IChatMediator mediator, String name) {
		this.mediator = mediator;
		this.name = name;
	}

	public abstract void send(String msg);

	public abstract void receive(String msg);
}
