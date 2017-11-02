package com.trms.dao;

import java.sql.SQLException;

import com.trms.model.User;

public interface AdminDAO {
	
	void registerAccount(User user) throws Exception;
	
	void loginAccount(User user) throws Exception;
	
	void apprveEvent() throws SQLException;
}
