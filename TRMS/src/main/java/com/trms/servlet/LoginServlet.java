package com.trms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trms.dao.DAOUtilities;
import com.trms.dao.UserDAO;
import com.trms.model.User;

public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("index.html").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = new User(
				username,
				password
				);
		
		UserDAO dao = DAOUtilities.getUserDAO();
		
		try {
			if(dao.loginAccount(user).equals(user)) {
				request.getSession().setAttribute("username", user.getUsername());
				response.sendRedirect("homepage.jsp");
			}
		} catch (Exception e) {
			request.getRequestDispatcher("index.html").forward(request, response);
			e.printStackTrace();
		}
		
	}

}