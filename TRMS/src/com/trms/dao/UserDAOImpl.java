package com.trms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.trms.model.User;

public class UserDAOImpl implements UserDAO {

	@Override
	public void registerAccount(User user) {
		
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try {
			connection = DAOUtilities.getConnection();
			String sql = "INSERT INTO USER VALUES (?, ?, ?, ?, ?, ?, ?)";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getFirstName());
			stmt.setString(4, user.getLastName());
			stmt.setString(5, user.getRole());
//			stmt.setDate(6, user.getHiredDate());
			stmt.setDouble(7, user.getavailableReimburstment());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void loginAccount(User user) {

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