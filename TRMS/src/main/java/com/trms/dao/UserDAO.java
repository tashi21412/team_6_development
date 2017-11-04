package com.trms.dao;

import com.trms.model.User;

public interface UserDAO {

	void registerAccount(User user) throws Exception;
	
<<<<<<< HEAD
	
	void loginAccount(User user) throws Exception;
=======
	User loginAccount(User user) throws Exception;
>>>>>>> 7554cb9f0b865a1afaa9d26b80c5040ffbeb07f9
	
	//to submit a form
	
}