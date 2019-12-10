package com.bridgeLabz.designPattern.structuralDesignPattern.facade;

import java.sql.Connection;

/**
 * This class has the main implementation of codes based on user request.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-10
 * @version 11.0.5
 */
public class HelperFacade {
	/**
	 * This function takes the input based on user input and shows the data based on
	 * user request.avoiding exposer of user to the main database connection codes.
	 * 
	 * @param dbType     Database type
	 * @param reportType type of report present in eNum
	 * @param tableName  as String parameter
	 */
	public static void generateReport(DBTypes dbType, ReportTypes reportType, String tableName) {
		Connection con = null;

		switch (dbType) {
		case MYSQL:
			con = MySqlHelper.getMySqlDBConnection();
			MySqlHelper mySqlHelper = new MySqlHelper();
			switch (reportType) {
			case HTML:
				mySqlHelper.generateMySqlHTMLReport(tableName, con);
				break;
			case PDF:
				mySqlHelper.generateMySqlPDFReport(tableName, con);
				break;
			}
			break;
		case ORACLE:
			con = OracleHelper.getOracleDBConnection();
			OracleHelper oracleHelper = new OracleHelper();
			switch (reportType) {
			case HTML:
				oracleHelper.generateOracleHTMLReport(tableName, con);
				break;
			case PDF:
				oracleHelper.generateOraclePDFReport(tableName, con);
				break;
			}
			break;
		case MANGODB:
			con = MangoDBHelper.getMangoDBConnection();
			MangoDBHelper mangoDbHelper = new MangoDBHelper();
			switch (reportType) {
			case HTML:
				mangoDbHelper.generateMangoDBHTMLReport(tableName, con);
				break;
			case PDF:
				mangoDbHelper.generateMangoDBPDFReport(tableName, con);
				break;
			}
			break;
		}
	}

	public static enum DBTypes {
		MYSQL, ORACLE, MANGODB;
	}

	public static enum ReportTypes {
		HTML, PDF;
	}

}
