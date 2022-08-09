package com.healthymeal.controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthymeal.dbConnectivity.DbConnectivity;
import com.healthymeal.modal.Meal;

public class ViewPlanDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String planName=request.getParameter("planName");
		ArrayList<Meal> aList= new ArrayList<>();
		PreparedStatement pStatement=DbConnectivity.connect("select * from planperday where planId=(select PlanId from plans where planName=?)");
		try {
			pStatement.setString(1,planName);
			ResultSet rs=pStatement.executeQuery();
			while(rs.next()) 
			{
          aList.add(new Meal(rs.getString(3),rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7), rs.getString(8)));
			}
			System.out.println("AA GYA");
			request.setAttribute("meal",aList);
			request.getRequestDispatcher("ViewPlanDetails.jsp").forward(request,response);
		} catch (Exception e) {
			System.out.println("AA GYA3333");
			System.out.println(e);
		}
}
}