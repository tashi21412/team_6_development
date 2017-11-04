package com.trms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.trms.model.User;

public class UserDaoImpl implements UserDAO {

	@Override
	public void registerAccount(User user) throws Exception{
		
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try {
			connection = DAOUtilities.getConnection();

			String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?, ?, ?, ?)";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getFirstName());
			stmt.setString(4, user.getLastName());
			stmt.setString(5, user.getEmail());
			Date sqlDate = new Date(user.getHiredDate().getTime());
			stmt.setDate(6, sqlDate);
			stmt.setDouble(7, user.getAvailableReimbursement());
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null)
					stmt.close();
				if(connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public User loginAccount(User user) throws Exception {

		Connection connection = null;
		PreparedStatement stmt = null;
		User existUser = null;
		
		try {
			connection = DAOUtilities.getConnection();
			String sql = "SELECT * FROM USERS WHERE USERNAME = ? AND PASSWORD = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			ResultSet rs = stmt.executeQuery();
			if(rs.next())
				existUser = user;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null)
					stmt.close();
				if(connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return existUser;
		
	}
	
	@Override 
	public User userInformation(String username) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;
		User currentUserInformation = null;
		
		try {
			connection = DAOUtilities.getConnection();
			String sql = "SELECT * FROM USERS WHERE USERNAME = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, user.getUsername());
			ResultSet rs = stmt.executeQuery();
			
			currentUserInformation = new User (rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5),rs.getInt(6));
		}
		catch (Exception e) {
			e.printStack();
		}
	}

}