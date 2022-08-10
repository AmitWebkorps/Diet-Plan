package com.healthymeal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthymeal.entity.User;
import com.healthymeal.model.AuthenticationModel;

public class Signup extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// getting user/Admin details from user/Admin Registration from
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		
		//entity class code 
		User user= new User();
		user.setName(name);
		user.setEmail(username);
		user.setPassword(password);
		user.setRole(role);
		
		//model class code
		AuthenticationModel authenticationModel = new AuthenticationModel();
		boolean res=authenticationModel.getSignup(user);
		
			// if data Stored Successfully
			if (res  && role.equals("admin"))
				response.sendRedirect("login.jsp");
			
			else if (res && role.equals("Client")) {
				HttpSession session = request.getSession(true);
				session.setAttribute("email", username);
				response.sendRedirect("UserSignup.jsp");
			}
			// if any problem occur while storing this data
			else
				System.out.println("Something Went Wrong");
		
	}

}
