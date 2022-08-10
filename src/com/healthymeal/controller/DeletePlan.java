package com.healthymeal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthymeal.model.PlanDetailsModel;

public class DeletePlan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//getting data from html page 
		String planName = request.getParameter("planName");
		
		// Creating model object and calling method 
		PlanDetailsModel planDetailsModel = new PlanDetailsModel();
        boolean deleteResponse = planDetailsModel.deletePlan(planName);
        
        //Response code 
		if (deleteResponse)
			request.setAttribute("respond", "Deleted Successfully");
		else
			request.setAttribute("respond", "Something went Wrong");
		request.getRequestDispatcher("ViewPlan").forward(request, response);

	}

}
