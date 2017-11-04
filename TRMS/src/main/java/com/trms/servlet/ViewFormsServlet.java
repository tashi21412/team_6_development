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
		List<TuitionReimbursementForm> forms = null;
		try {
			forms = dao.getAllForms();
			System.out.println("test");
			request.getSession().setAttribute("forms", forms);
			request.getRequestDispatcher("homepage.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}