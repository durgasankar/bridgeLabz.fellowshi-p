package com.bridgeLabz.designPattern.structuralDesignPattern.adapter;

/**
 * Interface has Three methods of Volt class type.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-10
 * @version 11.0.5
 */
public interface SocketAdapter {

	public Volt get120Volt();

	public Volt get12Volt();

	public Volt get3Volt();

}
