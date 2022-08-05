package com.healthymeal.controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthymeal.dbConnectivity.DbConnectivity;
//@WebServlet("/CreatePlan")
public class CreatePlan extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 //-------------------------------------------------------------//
	//Creating ArrayList for storing  all available meals  for Displaying on JSP page
		ArrayList<String> mealName = new ArrayList<>();
		
 //-------------------------------------------------------------//		
		
  //creating preparedStatement
		PreparedStatement ps = DbConnectivity.connect("Select * from meals");
		
 //-------------------------------------------------------------//
		
	//getting Days from JSP page for creating table according to this size 
		String Days = request.getParameter("Days");
		
//----------------------------------------------------------------//
		try {

       //getting value from database and storing it in the ArrayList
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				mealName.add(rs.getString(1));
			}
//----------------------------------------------------------------//			
			
			String size = "" + mealName.size();
			request.setAttribute("mealName", mealName);
			// Forward to to the JSP file.
			request.getRequestDispatcher("AddMealPerDay.jsp?size="+size).forward(request, response);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
