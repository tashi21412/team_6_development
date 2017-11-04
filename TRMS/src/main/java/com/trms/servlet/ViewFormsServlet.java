package com.trms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trms.dao.DAOUtilities;
import com.trms.dao.FormDAO;
import com.trms.model.TuitionReimbursementForm;

public class ViewFormsServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		FormDAO dao = DAOUtilities.getFormDAO();
		String username = (String) request.getSession().getAttribute("username");
		List<TuitionReimbursementForm> forms = dao.getAllForms(username);
		System.out.println(forms);
		request.getSession().setAttribute("forms", forms);
		request.getRequestDispatcher("profile.jsp").forward(request, response);

	}

}