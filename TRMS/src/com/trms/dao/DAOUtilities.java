package com.trms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOUtilities {

	private static final String url = "jdbc:oracle:thin:@wilsondbinstance.cfmx8fx4enfy.us-west-2.rds.amazonaws.com:1521:ORCL";
	private static final String connectionUsername = "wzhong21";
	private static final String connectionPassword = "oracleSQL";
	
	private static Connection connection = null;
	
	private static UserDaoImpl userDaoImpl = null;
	
	public static synchronized Connection getConnection() throws SQLException {
		
		if(connection == null) {
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				System.out.println("Could not register driver!");
				e.printStackTrace();
			}
			
			connection = DriverManager.getConnection(url, connectionUsername, connectionPassword);
			
		}
		
		if(connection.isClosed()) {
			System.out.println("getting new connection...");
			connection = DriverManager.getConnection(url, connectionUsername, connectionPassword);
		}
		
		return connection;
		
	}
	
	public static synchronized UserDAO getUserDAO() {
		
		if(userDaoImpl  == null) {
			userDaoImpl = new UserDaoImpl();
		}
		
		return userDaoImpl;
			
	}

}