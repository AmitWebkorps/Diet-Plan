package com.healthymeal.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthymeal.model.PlanDetailsModel;

//@WebServlet("/CreatePlan")
public class CreatePlan extends HttpServlet {
   private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Creating ArrayList for storing all available meals for Displaying on JSP page
		// from model Class
		PlanDetailsModel planDetailsModel = new PlanDetailsModel();
		ArrayList<String> mealName = planDetailsModel.createPlan();

		request.setAttribute("mealName", mealName);
		// Forward to to the JSP file.
		request.getRequestDispatcher("AddMealPerDay.jsp").forward(request, response);
	}

}
