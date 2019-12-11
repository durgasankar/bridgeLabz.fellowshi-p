package com.bridgeLabz.designPattern.behaviouralDesignPattern.observer;

/**
 * Interface subject which has 4 unimplemented method.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-11
 * @version 11.0.5
 */
public interface Subject {

	// methods to register observers
	public void register(Observer observer);

	// methods to unregister observers
	public void unregister(Observer observer);

	// method to notify observers of change
	public void notifyObservers();

	// method to get updates from subject
	public Object getUpdate(Observer observer);

}
