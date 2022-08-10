package com.healthymeal.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthymeal.dbConnectivity.DbConnectivity;

public class BuyPlan extends HttpServlet {
	private static final long serialVersionUID = 1L;
      protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 
    	  String planName = request.getParameter("planName");
    	  String planDays = request.getParameter("planDays");
    	  
    	  String userEmail="";
    	  HttpSession session=request.getSession();
    	  userEmail=(String)session.getAttribute("email"); 
			
    	  try {
    		 ResultSet rs=DbConnectivity.query("select BuyedPlan from user where email=?",userEmail);
    	    if(rs.next() && rs.getString(1)== null)
    	    {
	             int res=DbConnectivity.update("update user set BuyedPlan=? , "
	             		+ "planday=? where email=? ",planName,planDays,userEmail);
			     if(res>0)
			        response.sendRedirect("UserHome.jsp?res=success");
				    response.sendRedirect("UserHome.jsp?res=failer");
			}
    		else
			{
    			response.sendRedirect("UserHome.jsp?res=Already");
			}
		  } 
    	  catch (Exception e) {
			System.out.println(e);	
			response.sendRedirect("UserHome.jsp?res=failer");
		}
	 } 
}