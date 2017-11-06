package com.trms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trms.dao.AdminDAO;
import com.trms.dao.DAOUtilities;
import com.trms.model.TuitionReimbursementForm;

public class HeadServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AdminDAO dao = DAOUtilities.getAdminDAO();
		List<TuitionReimbursementForm> formsDH = dao.getAllForms("DS-APPROVED");
		request.getSession().setAttribute("formsDH", formsDH);
		request.getRequestDispatcher("request.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AdminDAO dao = DAOUtilities.getAdminDAO();
		String[] formID = request.getParameterValues("formID");
		String[] username = request.getParameterValues("username");
		String[] status = request.getParameterValues("status");

		try {
			for(int i = 0; i < username.length; i++) {
				if(status[i].equals("APPROVED")) {
					dao.approveForm(formID[i], "DH-APPROVED");
				}
				if(status[i].equals("DENIED")) {
					dao.denyForm(formID[i], "DH-DENIED");
				}
			}
			response.sendRedirect("admin.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}