package com.trms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trms.dao.AdminDAO;
import com.trms.dao.DAOUtilities;
import com.trms.dao.FormDAO;
import com.trms.model.TuitionReimbursementForm;

public class ViewFormsServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		FormDAO dao = DAOUtilities.getFormDAO();
		String username = (String) request.getSession().getAttribute("username");
		List<TuitionReimbursementForm> forms = dao.getAllForms(username);
		request.getSession().setAttribute("forms", forms);
		request.getRequestDispatcher("profile.jsp").forward(request, response);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		FormDAO dao1 = DAOUtilities.getFormDAO();
		String[] formID = request.getParameterValues("formID");
		String[] grade = request.getParameterValues("grade");
		
		AdminDAO dao2 = DAOUtilities.getAdminDAO();

		try {
			for(int i = 0; i < formID.length; i++) {
				if(grade[i].equals("PASSED"))
					dao1.postGrade(formID[i], grade[i]);
					dao2.approveForm(formID[i], "GRADE SUBMITTED");
			}
			response.sendRedirect("homepage.html");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}