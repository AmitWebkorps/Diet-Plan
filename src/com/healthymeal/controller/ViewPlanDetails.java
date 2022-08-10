package com.healthymeal.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthymeal.entity.Meal;
import com.healthymeal.model.PlanDetailsModel;

public class ViewPlanDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Getting values
		String planName = request.getParameter("planName");

		// model code
		PlanDetailsModel pDetailsModel = new PlanDetailsModel();
		ArrayList<Meal> aList = pDetailsModel.getPlanDetails(planName);

		//response code
		request.setAttribute("meal", aList);
		request.getRequestDispatcher("ViewPlanDetails.jsp").forward(request, response);

	}
}