package com.trms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.trms.model.User;

public class UserDaoImpl implements UserDAO {

	@Override
	public void registerAccount(User user) throws Exception{
		
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try {
			connection = DAOUtilities.getConnection();
			String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?, ?, ?)";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getFirstName());
			stmt.setString(4, user.getLastName());
			stmt.setString(5, user.getRole());
//			stmt.setDate(6, user.getHiredDate());
			stmt.setDouble(6, user.getAvailableReimbursement());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void loginAccount(User user) throws Exception {

		Connection connection = null;
		PreparedStatement stmt = null;
		
		try {
			connection = DAOUtilities.getConnection();
			String sql = "SELECT * FROM USER";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}