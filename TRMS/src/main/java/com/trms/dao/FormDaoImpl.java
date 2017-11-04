package com.trms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.trms.model.TuitionReimbursementForm;

public class FormDaoImpl implements FormDAO {

	@Override
	public void createForm(TuitionReimbursementForm trf) throws Exception {

		Connection connection = null;
		PreparedStatement stmt = null;
		Statement seqStmt = null;
		long formIdSeq = 0;
		
		try {
			connection = DAOUtilities.getConnection();
			String sql = "INSERT INTO TUITIONREIMBURSEMENTFORM VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			stmt = connection.prepareStatement(sql);
			seqStmt = connection.createStatement();
			String seqSql = "SELECT FORMIDSEQUENCE.NEXTVAL FROM DUAL";
			ResultSet rs = seqStmt.executeQuery(seqSql);
			if(rs.next())
				formIdSeq = rs.getLong(1);
			stmt.setLong(1, formIdSeq);
			Date sqlDate = new Date(trf.getEventDate().getTime());
			stmt.setDate(2, sqlDate);
			stmt.setString(3, trf.getEventTime());
			stmt.setString(4, trf.getLocation());
			stmt.setString(5, trf.getDescription());
			stmt.setDouble(6, trf.getCost());
			stmt.setString(7, trf.getGradingFormat());
			stmt.setString(8, trf.getEventType());
			stmt.setString(9, trf.getJustification());
			stmt.setString(10, trf.getUsername());
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
	public List<TuitionReimbursementForm> getAllForms(String username) {
		
		List<TuitionReimbursementForm> forms = new ArrayList<>();
		Connection connection = null;
		Statement stmt = null;

			try {
				connection = DAOUtilities.getConnection();
				stmt = connection.createStatement();
				String sql = "SELECT * FROM TUITIONREIMBURSEMENTFORM WHERE USERNAME = '" + username + "'";
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

}