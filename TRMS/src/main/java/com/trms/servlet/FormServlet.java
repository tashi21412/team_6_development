package com.trms.servlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trms.dao.DAOUtilities;
import com.trms.dao.FormDAO;
import com.trms.model.TuitionReimbursementForm;

public class FormServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("homepage.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String stringDate = request.getParameter("eventDate");
		String[] arrayDate = stringDate.split("/");
		int date = Integer.parseInt(arrayDate[0]);
		int month = Integer.parseInt(arrayDate[1]);
		int year = Integer.parseInt(arrayDate[2]);
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, date);
		Date eventDate = (Date) calendar.getTime();
		String eventTime = request.getParameter("eventTime");
		String location = request.getParameter("location");
		String description = request.getParameter("description");
		Double cost = Double.parseDouble(request.getParameter("cost"));
		String gradingFormat = request.getParameter("gradingFormat");
		String eventType = request.getParameter("eventType");
		String justification = request.getParameter("justification");
		String username = (String) request.getSession().getAttribute("username");
		
		TuitionReimbursementForm trf = new TuitionReimbursementForm(
				eventDate,
				eventTime,
				location,
				description,
				cost,
				gradingFormat,
				eventType,
				justification,
				username
				);
		
		FormDAO dao = DAOUtilities.getFormDAO();
		
		try {
			dao.createForm(trf);
			response.sendRedirect("homepage.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
	}

}