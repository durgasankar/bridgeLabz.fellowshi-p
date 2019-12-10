package com.bridgeLabz.designPattern.structuralDesignPattern.facade;

import java.sql.Connection;

/**
 * This class has the main implementation of the codes based user request.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-10
 * @version 11.0.5
 */
public class FacadePatternImplementation {

	public static void main(String[] args) {

		String tableName = "Employee";
		Connection con = MySqlHelper.getMySqlDBConnection();
		MySqlHelper mySqlHelper = new MySqlHelper();
		mySqlHelper.generateMySqlHTMLReport(tableName, con);

		Connection con1 = OracleHelper.getOracleDBConnection();
		OracleHelper oracleHelper = new OracleHelper();
		oracleHelper.generateOraclePDFReport(tableName, con1);

		Connection con2 = MangoDBHelper.getMangoDBConnection();
		MangoDBHelper mangoDBHelper = new MangoDBHelper();
		mangoDBHelper.generateMangoDBHTMLReport(tableName, con2);

		HelperFacade.generateReport(HelperFacade.DBTypes.MYSQL, HelperFacade.ReportTypes.HTML, tableName);
		HelperFacade.generateReport(HelperFacade.DBTypes.ORACLE, HelperFacade.ReportTypes.PDF, tableName);
		HelperFacade.generateReport(HelperFacade.DBTypes.MANGODB, HelperFacade.ReportTypes.PDF, tableName);
	}

}
