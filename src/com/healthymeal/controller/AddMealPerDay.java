package com.healthymeal.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthymeal.dbConnectivity.DbConnectivity;
import com.healthymeal.entity.Meal;

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

		try {

			int respon = DbConnectivity.update(
					"insert into Plans(planname,plandays,planprice,weightFrom,weightTo) value(?,?,?,?,?)", planName,
					days, planPrice, weightFrom, weightTo);

			if (respon > 0) {
				ResultSet rs = DbConnectivity.query("select planid from plans where planName=?", planName);

				String planId = null;
				if (rs.next()) {
					planId = rs.getString(1);

					int res[] = new int[mealObject.size()];

					for (int count = 0; count < mealObject.size(); count++) {

						res[count] = DbConnectivity.update("insert into PlanPerDay() values(?,?,?,?,?,?,?,?)", planId,
								"" + count + 1, mealObject.get(count).getBreakFast(),
								mealObject.get(count).getMorningSnacks(), mealObject.get(count).getLunch(),
								mealObject.get(count).getAfternoonSnacks(), mealObject.get(count).getDinner(),
								mealObject.get(count).getHydration());
					}
					response.sendRedirect("CreatePlans.jsp?res=success");
				}
			} else
				response.sendRedirect("CreatePlans.jsp?res=failer");
		} catch (Exception e) {
			if (e.getMessage().equalsIgnoreCase("Duplicate entry 'first' for key 'plans.planName_UNIQUE")) {
				response.sendRedirect("CreatePlans.jsp?res=duplicate");
			}
			response.sendRedirect("CreatePlans.jsp?res=failer");
		}
	}

}
