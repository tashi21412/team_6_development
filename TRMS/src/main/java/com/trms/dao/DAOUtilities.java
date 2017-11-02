package com.trms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOUtilities {

<<<<<<< HEAD:TRMS/src/main/java/com/trms/dao/DAOUtilities.java
	// groupproj1.c7bgoxp8ztvz.us-east-2.rds.amazonaws.com
	private static final String url = "jdbc:oracle:thin:@mydatabase.caado1dqwhw6.us-west-2.rds.amazonaws.com:1521:ORCL";
	private static final String connectionUsername = "chinook";
	private static final String connectionPassword = "Jampa21412";
=======
	private static final String url = "jdbc:oracle:thin:@groupproj1.c7bgoxp8ztvz.us-east-2.rds.amazonaws.com:1521:ORCL";
	private static final String connectionUsername = "medalistrelles";
	private static final String connectionPassword = "mypassword";
>>>>>>> 27396b7172fa81b4968936999ce5109755cbba6e:TRMS/src/com/trms/dao/DAOUtilities.java
	
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