package com.trms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.trms.model.TuitionReimbursementForm;

public class AdminDaoImpl implements AdminDAO {

	@Override
	public List<TuitionReimbursementForm> getAllForms(String status) {
		
		List<TuitionReimbursementForm> forms = new ArrayList<>();
		Connection connection = null;
		Statement stmt = null;

			try {
				connection = DAOUtilities.getConnection();
				stmt = connection.createStatement();
				String sql = "SELECT * FROM TUITIONREIMBURSEMENTFORM WHERE STATUS = '" + status + "'";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					TuitionReimbursementForm trf = new TuitionReimbursementForm();
					trf.setFormID(rs.getLong("FORMID"));
					trf.setEventDate(rs.getDate("EVENTDATE"));
					trf.setEventTime(rs.getString("EVENTTIME"));
					trf.setLocation(rs.getString("LOCATION"));
					trf.setDescription(rs.getString("DESCRIPTION"));
					trf.setCost(rs.getDouble("COST"));
					trf.setGradingFormat(rs.getString("GRADINGFORMAT"));
					trf.setEventType(rs.getString("EVENTTYPE"));
					trf.setJustification(rs.getString("JUSTIFICATION"));
					trf.setUsername(rs.getString("USERNAME"));
					trf.setStatus(rs.getString("STATUS"));
					forms.add(trf);
				}
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
		
		return forms;
		
	}
	
	@Override
	public void approveForm(String formID, String status) throws Exception {

		Connection connection = null;
		PreparedStatement stmt = null;
		long longFormID = Long.parseLong(formID);
		
		try {
			connection = DAOUtilities.getConnection();
			String sql = "UPDATE TUITIONREIMBURSEMENTFORM SET STATUS = ? WHERE FORMID = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, status);
			stmt.setLong(2, longFormID);
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
	public void denyForm(String username, String status) throws Exception {
	
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try{
			connection = DAOUtilities.getConnection();
			String sql = "UPDATE TUITIONREIMBURSEMENTFORM SET STATUS = ? WHERE USERNAME = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, status);
			stmt.setString(2, username);
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
	public void approveReimbursement(String formID, String username, String status) throws Exception {

		Connection connection = null;
		PreparedStatement stmt = null;
		PreparedStatement totalStmt = null;
		PreparedStatement awardedStmt = null;
		PreparedStatement reimburseStmt = null;
		double totalReimbursement = 0.00;
		double availableReimbursement = 0.00;
		long longFormID = Long.parseLong(formID);
		
		try{
			connection = DAOUtilities.getConnection();
			String sql = "UPDATE TUITIONREIMBURSEMENTFORM SET STATUS = ? WHERE FORMID = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, status);
			stmt.setLong(2, longFormID);
			stmt.executeUpdate();
			
			String totalSql = "SELECT AVAILABLEREIMBURSEMENT FROM USERS WHERE USERNAME = ?";
			totalStmt = connection.prepareStatement(totalSql);
			totalStmt.setString(1, username);
			ResultSet rs1 = totalStmt.executeQuery();
			rs1.next();
			totalReimbursement = rs1.getDouble("AVAILABLEREIMBURSEMENT");
			
			String awardedSql = "SELECT COST FROM TUITIONREIMBURSEMENTFORM WHERE FORMID = ?";
			awardedStmt = connection.prepareStatement(awardedSql);
			awardedStmt.setLong(1, longFormID);
			ResultSet rs2 = awardedStmt.executeQuery();
			rs2.next();
			availableReimbursement = totalReimbursement - rs2.getDouble("COST");
			
			String reimburseSql = "UPDATE USERS SET AVAILABLEREIMBURSEMENT = ? WHERE USERNAME = ?";
			reimburseStmt = connection.prepareStatement(reimburseSql);
			reimburseStmt.setDouble(1, availableReimbursement);
			reimburseStmt.setString(2, username);
			reimburseStmt.executeUpdate();			
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

}