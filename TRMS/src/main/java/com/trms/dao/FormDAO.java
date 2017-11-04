package com.trms.dao;

import java.util.List;

import com.trms.model.TuitionReimbursementForm;

public interface FormDAO {

	void createForm(TuitionReimbursementForm trf) throws Exception;
	
	List<TuitionReimbursementForm> getAllForms() throws Exception;
	
}