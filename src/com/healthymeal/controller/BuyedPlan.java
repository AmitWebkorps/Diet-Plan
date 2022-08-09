package com.healthymeal.controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthymeal.dbConnectivity.DbConnectivity;
import com.healthymeal.modal.Plans;

public class BuyedPlan extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		String userEmail=(String)session.getAttribute("email");
		Plans plans=null;
	   PreparedStatement preparedStatement=DbConnectivity.connect("select * from plans where planName=(select BuyedPlan from user where email=?)");
	   try {
		  
		  preparedStatement.setString(1, userEmail);
		  ResultSet rs= preparedStatement.executeQuery();
		  if(rs.next())
		  {
			  plans =new Plans();
			  plans.setPlanName(rs.getString(2));
			  plans.setPlanDays(rs.getString(3));
			  plans.setPlanPrice(rs.getString(4));
              
		  }
		  request.setAttribute("plan",plans);
		  request.getRequestDispatcher("BuyedPlan.jsp?").forward(request, response);
		  
	} catch (Exception e) {
		 System.out.println("Amit ji yadav");
		System.out.println(e);
		}
	}

}