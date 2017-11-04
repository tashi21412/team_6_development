package com.trms.servlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;


import com.trms.dao.DAOUtilities;
import com.trms.dao.UserDAO;
import com.trms.model.User;

public class RegistrationServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//request.getRequestDispatcher("index.html").forward(request, response);
		
		response.getWriter().print("I am here");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			System.out.println(request.getParameter("person"));
			
			//System.out.println(person);
			JSONObject jObj = new JSONObject(request.getParameter("person"));
			
			System.out.println(jObj.get("firstName"));
			Calendar calendar = Calendar.getInstance();
			Date hiredDate = (Date) calendar.getTime();
			
			String username = (String) jObj.get("username");
			String password = (String) jObj.get("password");
			String firstName = (String) jObj.get("firstName");
			String lastName = (String) jObj.get("lastName");
			String email= (String) jObj.get("email");
			double availableReimbursement = 1000.0;
		
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
		dao.registerAccount(user);
		
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}