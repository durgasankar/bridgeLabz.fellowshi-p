package com.bridgeLabz.objectOrientedPrograms.stockMarket;

import com.bridgeLabz.objectOrientedPrograms.stockMarket.operarion.Operation;
import com.bridgeLabz.objectOrientedPrograms.stockMarket.recordDetails.Transaction;
import com.bridgeLabz.utility.Util;

/**
 * This class has the all implementation of all trading operation between
 * customer and Company.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-07
 * @modified 2019-12-12
 * @updated -> separated this class from Customer Operation class. -> addition
 *          of transaction date and time feature. -> addition of transaction
 *          symbol features.
 * @version 11.0.5
 */
public class Implementation {

	public static void main(String[] args) {
		Operation implimentation = new Operation();

		boolean isQuitApplication = false;
		while (!isQuitApplication) {
			System.out.println(
					"Enter action :\n1-> login as company. 2-> login as customer. 3-> Quit application. 4-> display dateTime transaction. 5-> display sell sybol transaction.");
			int action = Util.scanner.nextInt();
			switch (action) {
			case 1:
				implimentation.companyOperation(isQuitApplication);
				break;

			case 2:
				implimentation.customerOperation(isQuitApplication);
				break;

			case 3:
				isQuitApplication = true;
				break;

			case 4:
				System.out.println("Recent date time of Transactions");
				Transaction.displayTimeRecord();
				break;

			case 5:
				System.out.println("Recent Symbol transactions.");
				Transaction.displaySymbolRecord();
				break;

			default:
				System.out.println("Please read instructions!");
			}
		}

	}

}
