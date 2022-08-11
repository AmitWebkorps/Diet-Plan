package com.healthymeal.controller;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.healthymeal.entity.MealDetails;
import com.healthymeal.model.MealDetailsModel;

public class ViewMeal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    //model Class
		    MealDetailsModel mealDetailsModel = new MealDetailsModel();
		    ArrayList<MealDetails> aList=mealDetailsModel.getMealDetails();
		    
		   //forwarding response
			request.setAttribute("meal", aList);
			request.getRequestDispatcher("ViewMeal.jsp").forward(request, response);
		
	}

}
