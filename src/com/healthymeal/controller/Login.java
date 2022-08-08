package com.healthymeal.controller;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthymeal.dbConnectivity.DbConnectivity;
import com.healthymeal.modal.User;

//@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//-----------------------------------------------------//
	//getting user/Admin details from user/Admin login from
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
//-----------------------------------------------------//
     // creating  connection and matching login details in the table
		PreparedStatement ps = DbConnectivity.connect("select * from user where email=? and password=?");
		try {
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
//-----------------------------------------------------//
    // if  we found corresponding data now check weather admin or user 
			if (rs.next()) {
				
		//if admin login
				if (rs.getString(4).equals("Admin"))
					response.sendRedirect("AddMeal.jsp");
				
//-----------------------------------------------------//
		//if user login
				else
				{
					Cookie ck= new Cookie("email",username);
                    response.addCookie(ck);
					response.sendRedirect("UserHome.jsp");
				}
//-----------------------------------------------------//
	//if we did not find corresponding data
			} else {
				response.sendRedirect("login.jsp?fail=failer");
//-----------------------------------------------------//
			}
    // if any Exception occur
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
