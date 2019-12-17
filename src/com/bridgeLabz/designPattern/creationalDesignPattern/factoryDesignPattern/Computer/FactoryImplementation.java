package com.bridgeLabz.designPattern.creationalDesignPattern.factoryDesignPattern.Computer;

public class FactoryImplementation {
	public static void main(String[] args) {
		Computer pc = ComputerFactory.getComputer("pc", "2.4 gHz", "1 tb", "octacore");
		Computer server = ComputerFactory.getComputer("server", "2 gHz", "500 gb", "quardcore");
		System.out.println("Pc config : \n" + pc.toString());
		System.out.println("Server config : \n" + server.toString());

	}

}
