package com.bridgeLabz.designPattern.behaviouralDesignPattern.observer;

/**
 * Interface Observer which has 2 unimplemented method.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-11
 * @version 11.0.5
 */

public interface Observer {

	// method to update the observer, used by subject
	public void update();

	// attach with subject to observe
	public void setSubject(Subject sub);
}
