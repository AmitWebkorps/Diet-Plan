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

public class BuyPlan extends HttpServlet {
	private static final long serialVersionUID = 1L;
      protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//----------------------------------------------------------------------------------------------//   	
    	  
    	  String planName = request.getParameter("planName");
    	  String planDays = request.getParameter("planDays");
    	  
    	  
//----------------------------------------------------------------------------------------------//   
    	  
    	  String userEmail="";
    	  HttpSession session=request.getSession();
    	  userEmail=(String)session.getAttribute("email");
//----------------------------------------------------------------------------------------------//   	 
			
    	  PreparedStatement pStatement=DbConnectivity.connect("select BuyedPlan from user where email=?");
    	  try {
    		  pStatement.setString(1,userEmail);
    		  ResultSet rs=pStatement.executeQuery();
    	   if(rs.next())
    		   
//----------------------------------------------------------------------------------------------//   	 
    	     
    		   if(rs.getString(1)== null) 
    		{
	    		pStatement= DbConnectivity.connect("update user set BuyedPlan=? , planday=? where email=? ");
				pStatement.setString(1,planName);
				pStatement.setString(2,planDays);
				pStatement.setString(3,userEmail);
			    int res=pStatement.executeUpdate();
			    
//----------------------------------------------------------------------------------------------//   	 
			  
			    if(res>0)
			    {
			    	response.sendRedirect("UserHome.jsp?res=success");
			    }
			    else
				{
	    			response.sendRedirect("UserHome.jsp?res=failer");
				}
			    
//----------------------------------------------------------------------------------------------//   	 
    		}
    		else
			{
    			response.sendRedirect("UserHome.jsp?res=Already");
			}
		} catch (Exception e) {
			System.out.println(e);	
			response.sendRedirect("UserHome.jsp?res=failer");
		}
	 } 
}