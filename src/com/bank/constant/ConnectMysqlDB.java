/**
 * 
 */
package com.bank.constant;

/**
 * @author Arnaud
 *
 */

public class ConnectMysqlDB {
 
	// Mysql Database connection settings
	private String driverClassName = "com.mysql.jdbc.Driver";
	private String databaseURL = "jdbc:mysql://localhost:3306/bank1_db";
	private String databaseUserName = "root";
	private String databaseUserPassword = "123";
	
	public String getDriverClassName() {
		return driverClassName;
	}
	
	public String getDatabaseURL() {
		return databaseURL;
	}
	
	public String getDatabaseUserName() {
		return databaseUserName;
	}
	
	public String getDatabaseUserPassword() {
		return databaseUserPassword;
	}
}
