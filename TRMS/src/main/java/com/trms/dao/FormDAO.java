package com.trms.dao;

import com.trms.model.TuitionReimbursementForm;

public interface FormDAO {

	void createForm(TuitionReimbursementForm trf) throws Exception;
	
}