package com.trms.servlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trms.dao.DAOUtilities;
import com.trms.dao.UserDAO;
import com.trms.model.User;

public class RegistrationServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("index.html").forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		Calendar calendar = Calendar.getInstance();
		Date hiredDate = (Date) calendar.getTime();
		Double availableReimbursement = 1000.00;
		
		User user = new User(
				username,
				password,
				firstName,
				lastName,
				email,
				hiredDate,
				availableReimbursement
				);
		
		UserDAO dao = DAOUtilities.getUserDAO();
		
		try {
			dao.registerAccount(user);
			response.sendRedirect("index.html");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}