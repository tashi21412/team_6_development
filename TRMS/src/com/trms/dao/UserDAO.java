package com.trms.dao;

import com.trms.model.User;

public interface UserDAO {

	void registerAccount(User user);
	
	void loginAccount(User user);
	
}