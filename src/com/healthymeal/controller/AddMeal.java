package com.healthymeal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.healthymeal.entity.MealDetails;
import com.healthymeal.model.MealDetailsModel;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
		maxFileSize = 1024 * 1024 * 50, // 50 MB
		maxRequestSize = 1024 * 1024 * 100)
public class AddMeal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// getting value from HTML form
		String mealName = request.getParameter("mealname");
		Part imagePart = request.getPart("meal-image");
		String mealPrice = request.getParameter("mealprice");
		String mealType = request.getParameter("mealtype");
		String mealIngredients = request.getParameter("ingredients");

		// entity class
		MealDetails mealDetails = new MealDetails();
		mealDetails.setMealName(mealName);
		mealDetails.setMealImagePart(imagePart);
		mealDetails.setMealPrice(mealPrice);
		mealDetails.setMealType(mealType);
		mealDetails.setMealIngredients(mealIngredients);

		//model class
		MealDetailsModel mealDetailsModel = new MealDetailsModel();
		boolean res = mealDetailsModel.addMeal(mealDetails);
		
		if (res) {
			response.sendRedirect("AddMeal.jsp?res=success");
		} else {
			response.sendRedirect("AddMeal.jsp?res=failer");
		}

	}
}
