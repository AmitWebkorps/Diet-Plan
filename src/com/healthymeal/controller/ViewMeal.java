package com.healthymeal.controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthymeal.dbConnectivity.DbConnectivity;
import com.healthymeal.modal.MealDetails;

public class ViewMeal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mealName= request.getParameter("meal");
		PreparedStatement ps=DbConnectivity.connect("select * from meals where MealName=?");
		try {
			ps.setString(1,mealName);
			ResultSet data=ps.executeQuery();
			if(data.next()){
			  MealDetails meal = new MealDetails();
			  meal.setMealName(data.getString(1));
			  meal.setMealImage(data.getString(2));
			  meal.setMealPrice(data.getString(3));
			  meal.setMealType(data.getString(4));
			  request.setAttribute("meal",meal);
			  System.out.println("Aa gya");
			  request.getRequestDispatcher("ViewMeal.jsp").forward(request,response);
			}
	    }
		catch(Exception e){
			System.out.println(e);
		}
	}

}
