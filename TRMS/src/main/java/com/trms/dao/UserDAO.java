package com.trms.dao;

import com.trms.model.User;

public interface UserDAO {

	void registerAccount(User user) throws Exception;
	
	User loginAccount(User user) throws Exception;
	
}