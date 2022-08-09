package com.healthymeal.controller;

import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthymeal.dbConnectivity.DbConnectivity;
//@WebServlet("/Signup")
public class Signup extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//-----------------------------------------------------//
	
	//getting user/Admin details from user/Admin Registration from 
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
//-----------------------------------------------------//
	//Storing user/admin details in database
		PreparedStatement ps = DbConnectivity.connect("insert into user(Name,Email,Password,Role) values(?,?,?,?)");
		try {
			ps.setString(1, name);
			ps.setString(2, username);
			ps.setString(3, password);
			ps.setString(4, role);
			int res = ps.executeUpdate();
			System.out.println("gya");
//-----------------------------------------------------//
	//if data Stored Successfully
			if (res > 0 && role.equals("admin"))
				response.sendRedirect("login.jsp");
//-----------------------------------------------------//
			else if (res > 0 && role.equals("Client"))
			{
				 HttpSession session=request.getSession(true);
			         session.setAttribute("email", username);
				response.sendRedirect("UserSignup.jsp");
			}
	//if any problem occur while storing this data
			else
				System.out.println("Something Went Wrong");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
