package com.healthymeal.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthymeal.entity.Plans;
import com.healthymeal.model.PlanDetailsModel;

public class ViewPlan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PlanDetailsModel planDetailsModel = new PlanDetailsModel();
		ArrayList<Plans> plans = planDetailsModel.getPlan();

		request.setAttribute("plans", plans);
		request.getRequestDispatcher("ViewPlans.jsp").forward(request, response);

	}

}
