package com.healthymeal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthymeal.entity.Plans;
import com.healthymeal.model.PlanDetailsModel;

public class BuyPlan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String planName = request.getParameter("planName");
		String planDays = request.getParameter("planDays");

		// getting userEmail from session
		String userEmail = "";
		HttpSession session = request.getSession();
		userEmail = (String) session.getAttribute("email");

		// model class
		PlanDetailsModel planDetailsModel = new PlanDetailsModel();
		boolean flag = planDetailsModel.checkBuyedPlan(userEmail);

		if (flag) {

			// entity class
			Plans plans = new Plans();
			plans.setPlanName(planName);
			plans.setPlanDays(planDays);

			flag = planDetailsModel.buyPlan(plans, userEmail);
			if (flag)
				response.sendRedirect("UserHome.jsp?res=success");
			else
				response.sendRedirect("UserHome.jsp?res=failer");
		} else {
			response.sendRedirect("UserHome.jsp?res=Already");
		}
	}
}