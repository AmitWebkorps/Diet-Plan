package com.healthymeal.controller;

import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthymeal.dbConnectivity.DbConnectivity;

public class UserSignup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//---------------------------------------------------------------//
		String age = request.getParameter("age");
		String weight = request.getParameter("weight");
		String height = request.getParameter("height");
//---------------------------------------------------------------//
		HttpSession session = request.getSession(true);
		String email = (String) session.getAttribute("email");
		System.out.println(email);
//---------------------------------------------------------------//
		PreparedStatement pStatement = DbConnectivity
				.connect("update user set age=? ,weight=? ,height=? where email=?");
//---------------------------------------------------------------//
		try {
             pStatement.setString(1, age);
             pStatement.setString(2,weight);
             pStatement.setString(3, height);
             pStatement.setString(4, email);
//---------------------------------------------------------------//
           //res is response
            int res=pStatement.executeUpdate();
             if(res>0)
             {
//---------------------------------------------------------------//
            	 response.sendRedirect("UserHome.jsp");
             }
             else 
             {
//---------------------------------------------------------------//
            	 response.sendRedirect("UserSignup.jsp?res=Failer");
             }
             
		} catch (Exception e) {
			System.out.println(e);
			response.sendRedirect("UserSignup.jsp?res=Failer");
		}
	}
}
