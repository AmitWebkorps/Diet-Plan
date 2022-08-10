package com.healthymeal.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthymeal.dbConnectivity.DbConnectivity;
import com.healthymeal.entity.MealDetails;

public class ViewMeal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<MealDetails> aList = new ArrayList<>();
		try {
			ResultSet data = DbConnectivity.query("select * from meals");
			while (data.next()) {
				MealDetails meal = new MealDetails();
				meal.setMealName(data.getString(1));
				meal.setMealImage(data.getString(2));
				meal.setMealPrice(data.getString(3));
				meal.setMealType(data.getString(4));
				aList.add(meal);
			}
			request.setAttribute("meal", aList);
			request.getRequestDispatcher("ViewMeal.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
