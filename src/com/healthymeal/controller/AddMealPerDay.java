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
import com.healthymeal.modal.Meal;

//@WebServlet("/AddMealPerDay")
public class AddMealPerDay extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String days=request.getParameter("Days");
	   String planName=request.getParameter("planname");
	   String planPrice=request.getParameter("planPrice");
	   String weightFrom=request.getParameter("weightFrom");
	   String weightTo=request.getParameter("weightTo");
//---------------------------------------------------------------//	   
	   
	   ArrayList<Meal> mealObject=new ArrayList<>();
	   for(int day=1;day<=Integer.parseInt(days);day++)
       {
		   String meals[]=new String[6];
		   for(int meal=0;meal<=5;meal++)
	       {
			   meals[meal]=request.getParameter("Day"+day+"Meal"+(meal+1));
	       }
		  mealObject.add(new Meal(meals[0],meals[1],meals[2],meals[3],meals[4],meals[5]));
       } 
	   
//---------------------------------------------------------------//	   
	   PreparedStatement ps=DbConnectivity.connect("insert into Plans(planname,plandays,planprice,weightFrom,weightTo) value(?,?,?,?,?)");
		try {
			ps.setString(1,planName);
			ps.setString(2,days);
			ps.setString(3,planPrice);
			ps.setString(4,weightFrom);
			ps.setString(5,weightTo);
			int respon=ps.executeUpdate();
//---------------------------------------------------------------//	   
			if(respon>0)
			{
				ps=DbConnectivity.connect("select planid from plans where planName='"+planName+"'");
				ResultSet rs=ps.executeQuery();
				String planId=null;
				if(rs.next())
				{
					planId=rs.getString(1);
				ps=DbConnectivity.connect("insert into PlanPerDay() values(?,?,?,?,?,?,?,?)");
				int res[]=new int[mealObject.size()];
				for(int count=0;count<mealObject.size();count++)
				{
					ps.setString(1,planId);
					ps.setInt(2,count+1);
					ps.setString(3,mealObject.get(count).getBreakFast());
					ps.setString(4,mealObject.get(count).getMorningSnacks());
					ps.setString(5,mealObject.get(count).getLunch());
					ps.setString(6,mealObject.get(count).getAfternoonSnacks());
					ps.setString(7,mealObject.get(count).getDinner());
					ps.setString(8,mealObject.get(count).getHydration());
				 res[count]=ps.executeUpdate();
				}
				response.sendRedirect("CreatePlans.jsp?res=success");
			  }
			}
			else
				response.sendRedirect("CreatePlans.jsp?res=failer");
		}
		catch(Exception e) {
			if(e.getMessage().equalsIgnoreCase("Duplicate entry 'first' for key 'plans.planName_UNIQUE"))
			{
				response.sendRedirect("CreatePlans.jsp?res=duplicate");
			}
			response.sendRedirect("CreatePlans.jsp?res=failer");
		}
	}
	
}
