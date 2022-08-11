package com.healthymeal.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthymeal.entity.Meal;
import com.healthymeal.entity.Plans;
import com.healthymeal.model.PlanDetailsModel;
import com.healthymeal.util.DbConnectivity;

//@WebServlet("/AddMealPerDay")
public class AddMealPerDay extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String days = request.getParameter("Days");
		String planName = request.getParameter("planname");
		String planPrice = request.getParameter("planPrice");
		String weightFrom = request.getParameter("weightFrom");
		String weightTo = request.getParameter("weightTo");

		ArrayList<Meal> mealObject = new ArrayList<>();
		for (int day = 1; day <= Integer.parseInt(days); day++) {
			String meals[] = new String[6];
			for (int meal = 0; meal <= 5; meal++) {
				meals[meal] = request.getParameter("Day" + day + "Meal" + (meal + 1));
			}
			mealObject.add(new Meal(meals[0], meals[1], meals[2], meals[3], meals[4], meals[5]));
		}

		Plans plans = new Plans();
		plans.setPlanName(planName);
		plans.setPlanDays(days);
		plans.setPlanPrice(planPrice);
		plans.setWeightFrom(weightFrom);
		plans.setWeightTo(weightTo);

		PlanDetailsModel planDetailsModel = new PlanDetailsModel();
		boolean respon = planDetailsModel.createPlan(plans);

		if (respon && planDetailsModel.setPLanDeatils(planName, mealObject))
			response.sendRedirect("CreatePlans.jsp?res=success");
		else
			response.sendRedirect("CreatePlans.jsp?res=failer");
	}

}
