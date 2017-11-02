package com.trms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
			String sql = "INSERT INTO TUITIONREIMBURSEMENTFORM VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
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

}