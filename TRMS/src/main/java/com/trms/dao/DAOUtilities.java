package com.trms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOUtilities {

<<<<<<< HEAD

	// groupproj1.c7bgoxp8ztvz.us-east-2.rds.amazonaws.com

	private static final String url = "jdbc:oracle:thin:@groupproj1.c7bgoxp8ztvz.us-east-2.rds.amazonaws.com:1521:ORCL";
	private static final String connectionUsername = "medalistrelles";
	private static final String connectionPassword = "mypassword";

=======
	private static final String url = "jdbc:oracle:thin:@wilsondbinstance.cfmx8fx4enfy.us-west-2.rds.amazonaws.com:1521:ORCL";
	private static final String connectionUsername = "wzhong21";
	private static final String connectionPassword = "oracleSQL";
>>>>>>> 94fcc0f15a2481817291925fa6dbc57a99032506
	
	private static Connection connection = null;
	
	private static UserDaoImpl userDaoImpl = null;
	private static FormDaoImpl formDaoImpl = null;
	
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
		
		if(userDaoImpl == null) {
			userDaoImpl = new UserDaoImpl();
		}
		
		return userDaoImpl;
			
	}

	public static synchronized FormDAO getFormDAO() {
		
		if(formDaoImpl == null) {
			formDaoImpl = new FormDaoImpl();
		}
		
		return formDaoImpl;
			
	}
	
}