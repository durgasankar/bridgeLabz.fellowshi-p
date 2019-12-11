
package com.bridgeLabz.designPattern.behaviouralDesignPattern.observer;

/**
 * This class has the functionality of updating each customers whenever a new
 * Message is updated.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-11
 * @version 11.0.5
 */
public class MyTopicSubscriber implements Observer {
	private String name;
	private Subject topic;

	public MyTopicSubscriber(String name) {
		this.name = name;
	}

	@Override
	public void update() {
		String msg = (String) topic.getUpdate(this);
		if (msg == null) {
			System.out.println(name + ":: No new message");
		} else
			System.out.println(name + ":: Consuming message::" + msg);
	}

	@Override
	public void setSubject(Subject sub) {
		this.topic = sub;
	}

}
