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
		Statement seqStmt = null;
		long userIdSeq = 0;
		
		try {
			connection = DAOUtilities.getConnection();
			
			String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?, ?, ?)";
			stmt = connection.prepareStatement(sql);
			seqStmt = connection.createStatement();
			String seqSql = "SELECT USERIDSEQUENCE.NEXTVAL FROM DUAL";
			ResultSet rs = seqStmt.executeQuery(seqSql);
			
			if(rs.next()) 
				userIdSeq = rs.getLong(1);
			
				stmt.setString(1, user.getUsername());
				stmt.setString(2, user.getPassword());
				stmt.setString(3, user.getFirstName());
				stmt.setString(4, user.getLastName());
				stmt.setString(5, user.getEmail());
			
				stmt.setDouble(6, user.getAvailableReimbursement());
			
				stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null)
					stmt.close();
				if(seqStmt != null)
					seqStmt.close();
				if(connection != null)
					connection.close();
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}