package com.bridgeLabz.designPattern.creationalDesignPattern.prototype;

import java.util.List;

/**
 * This class has main implementation where we created first a new object of the
 * class. By using that object reference each time we created a called the clone
 * method and did addition deletion operations we got new objects whenever we
 * call.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-10
 * @version 11.0.5
 */
public class PrototypeImplementation {
	public static void main(String[] args) throws CloneNotSupportedException {

		Employee employee = new Employee();
		employee.loadData();

		Employee newEmployee = (Employee) employee.clone();
		Employee secondEmployee = (Employee) employee.clone();

		List<String> list = newEmployee.getEmployeeList();
		list.add("yadav");

		List<String> secondList = secondEmployee.getEmployeeList();
		secondList.remove("Ramesh");

		System.out.println("Printing employee List : " + employee.getEmployeeList());
		System.out.println("Printing newEmployee List : " + newEmployee.getEmployeeList());
		System.out.println("Printing secondEmployee List : " + secondEmployee.getEmployeeList());

	}

}
