package com.bridgeLabz.designPattern.creationalDesignPattern.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements CloneableInterface we get a clone override method which
 * allows us to transfer all data of that list to a new ArrayList each time we
 * call that method which satisfies prototype design pattern criteria.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-10
 * @version 11.0.5
 */
public class Employee implements Cloneable {

	private List<String> employeeList;

	/**
	 * Constructor to initialize ArrayList
	 */
	public Employee() {
		employeeList = new ArrayList<String>();
	}

	/**
	 * constructor which takes employee type list as input parameter and returns
	 * current list.
	 * 
	 * @param employeeList as List input parameter
	 */
	public Employee(List<String> employeeList) {
		this.employeeList = employeeList;
	}

	/**
	 * Adding certain data to arrayList
	 */
	public void loadData() {
		employeeList.add("Ramesh");
		employeeList.add("Suresh");
		employeeList.add("Amresh");
		employeeList.add("Rakesh");

	}

	/**
	 * Getter method for arrayList
	 * 
	 * @return String ArrayList
	 */
	public List<String> getEmployeeList() {
		return employeeList;
	}

	/**
	 * Override method of clone which transfer all data of main list to a temporary
	 * list and returns new object of the list.
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		List<String> tempList = new ArrayList<String>();
		for (String str : this.employeeList) {
			tempList.add(str);
		}
		return new Employee(tempList);
	}

}
