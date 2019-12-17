
package com.bridgeLabz.designPattern.behaviouralDesignPattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * This class has the functionality of notifying registering unregistering
 * customers and notifying them when new message is posted.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-11
 * @version 11.0.5
 */
public class MyTopic implements Subject {

	private List<Observer> observers;
	private String message;
	private boolean changed;
	private final Object MUTEX = new Object();

	public MyTopic() {
		this.observers = new ArrayList<>();
	}

	/**
	 * overridden method which check the functionality of presence in the list if
	 * not present then add to the list.
	 */
	@Override
	public void register(Observer observer) {
		if (observer == null)
			throw new NullPointerException("Null Observer");
		synchronized (MUTEX) {
			if (!observers.contains(observer))
				observers.add(observer);
		}
	}

	/**
	 * Overridden method which bears the functionality of removing observer from the
	 * list.
	 */
	@Override
	public void unregister(Observer observer) {
		synchronized (MUTEX) {
			observers.remove(observer);
		}
	}

	/**
	 * synchronization is used to make sure any observer registered after message is
	 * received is not notified
	 */
	@Override
	public void notifyObservers() {
		List<Observer> observersLocal = null;
		synchronized (MUTEX) {
			if (!changed)
				return;
			observersLocal = new ArrayList<>(this.observers);
			this.changed = false;
		}
		for (Observer obj : observersLocal) {
			obj.update();
		}

	}

	@Override
	public Object getUpdate(Observer obj) {
		return this.message;
	}

	/**
	 * After posting the message notification is sent to the observer.
	 * 
	 * @param msg as String input parameter.
	 */
	public void postMessage(String msg) {
		System.out.println("Message Posted to Topic:" + msg);
		this.message = msg;
		this.changed = true;
		notifyObservers();
	}

}
