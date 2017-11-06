package com.trms.dao;

import java.util.List;

import com.trms.model.TuitionReimbursementForm;

public interface AdminDAO {

	List<TuitionReimbursementForm> getAllForms(String status);
	
	void approveForm(String formID, String status) throws Exception;
	
	void denyForm(String username, String status) throws Exception;
	
	void approveReimbursement(String formID, String username, String status) throws Exception;
	
}