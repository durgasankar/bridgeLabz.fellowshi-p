package com.bridgeLabz.objectOrientedPrograms;

import com.bridgeLabz.utility.UtilJson;

public class MainClass {

	public static void main(String[] args) {
		Test test1 = new Test();
		test1.setId(10);
		test1.setName("raja");
		test1.setBalance(12560);

		String jsonOutput = UtilJson.convertObjectToJson(test1);
		System.out.println(jsonOutput);
	
		Test test2 = UtilJson.convertJsonToJava(jsonOutput, Test.class);
		System.out.println("---------------------------");
		System.out.println(test2.getId() + " " + test2.getName() + " " + test2.getBalance());
		
	}

}
