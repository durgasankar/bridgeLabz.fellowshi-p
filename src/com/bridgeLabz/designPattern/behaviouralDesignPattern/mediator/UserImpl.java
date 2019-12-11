package com.bridgeLabz.designPattern.behaviouralDesignPattern.mediator;

/**
 * This class has overridden functionality of sending message and receiving
 * message.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-11
 * @version 11.0.5
 */
public class UserImpl extends User {

	public UserImpl(IChatMediator med, String name) {
		super(med, name);
	}

	@Override
	public void send(String msg) {
		System.out.println(this.name + ": Sending Message : " + msg);
		mediator.sendMessage(msg, this);
	}

	@Override
	public void receive(String msg) {
		System.out.println(this.name + ": Received Message : " + msg);
	}

}
