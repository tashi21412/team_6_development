package com.trms.dao;

import com.trms.model.User;

public interface UserDAO {

	void registerAccount(User user) throws Exception;
	
	
	void loginAccount(User user) throws Exception;
	
	//to submit a form
	
}