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
		
		JSONObject jObj = new JSONObject(request.getParameter("loginPerson"));
		
		String username = (String) jObj.get("username");
		String password = (String) jObj.get("password");
		
		User user = new User(
				username,
				password);
		
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		    
		    
		UserDAO dao = DAOUtilities.getUserDAO();
		
		
		try {
			if(dao.loginAccount(user).equals(user)) {
				request.getSession().setAttribute("username", user.getUsername());
				
				JSONObject json = new JSONObject();
				User anotherUser = dao.getUserInformation(username);
				
				json.put("userName", anotherUser.getUsername);
				json.put("fullName", anotherUser.getFirstName() + " "+ anotherUser.getLastName());
				json.put("role", anotherUser.getRole());
				json.put("availableReimbursement", anotherUser.getAvailableReimbursement);

				// finally output the json string
				out.print(json.toString());
				
				
				response.sendRedirect("homepage.jsp");
			}
		} catch (Exception e) {
			request.getRequestDispatcher("index.html").forward(request, response);
			e.printStackTrace();
		}
		
	}

}