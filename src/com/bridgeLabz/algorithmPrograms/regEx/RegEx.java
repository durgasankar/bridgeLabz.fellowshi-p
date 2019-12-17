package com.bridgeLabz.algorithmPrograms.regEx;
//System.out.println(u.convertString(user,u.getFileText("newfile.txt")));
import com.bridgeLabz.utility.Util;

public class RegEx {
	public static void main(String[] args) {
		UserDetails userDetails = new UserDetails();
		System.out.println("Please Enter your first name :");
		userDetails.setFirstName(Util.scanner.nextLine());
		System.out.println("Please Enter your Last name :");
		userDetails.setFirstName(Util.scanner.nextLine());
		System.out.println("Please Enter Mobile Number :");
		userDetails.setFirstName(Util.scanner.nextLine());
		System.out.println("Please Enter Date :");
		userDetails.setDate(Util.getFormatedDate(Util.printDate(Util.scanner.nextLine())));

//		Util.writeToFile(
//				"Hello <<name>>, We have your full name as <<full name>> in our system. "
//						+ "Your contact number is 91-xxxxxxxxxx. Please,let us know in case of any clarification."
//						+ " Thank you BridgeLabz 01/01/2016.",
//				"C:\\Users\\durgasankar\\eclipse-workspace\\welcome.txt");
		
//		String data = Util.readFile("C:\\Users\\durgasankar\\eclipse-workspace\\welcome.txt");
//		System.out.println(data);
		//regular expression
		
	}

}
