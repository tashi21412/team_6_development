package com.trms.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

		request.getRequestDispatcher("homepage.html").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String stringDate = request.getParameter("eventDate");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sdf.parse(stringDate));

		String eventTime = request.getParameter("eventTime");
		String location = request.getParameter("location");
		String description = request.getParameter("description");
		Double cost = Double.parseDouble(request.getParameter("cost"));
		String gradingFormat = request.getParameter("gradingFormat");
		String eventType = request.getParameter("eventType");
		String justification = request.getParameter("justification");
		
		TuitionReimbursementForm trf = new TuitionReimbursementForm(
				eventDate,
				eventTime,
				location,
				description,
				cost,
				gradingFormat,
				eventType,
				justification
				);
		
		FormDAO dao = DAOUtilities.getFormDAO();
		
		try {
			dao.createForm(trf);
			response.sendRedirect("homepage.html");
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
	}

}