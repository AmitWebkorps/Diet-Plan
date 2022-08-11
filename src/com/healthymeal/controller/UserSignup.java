package com.healthymeal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.healthymeal.entity.User;
import com.healthymeal.model.AuthenticationModel;

public class UserSignup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String age = request.getParameter("age");
		String weight = request.getParameter("weight");
		String height = request.getParameter("height");
		HttpSession session = request.getSession(true);
		String email = (String) session.getAttribute("email");
		System.out.println(email);

		// entity class
		User user = new User();
		user.setAge(Integer.parseInt(age));
		user.setHeight(Double.parseDouble(height));
		user.setWeight(Integer.parseInt(weight));
        user.setEmail(email);
		// model class
		AuthenticationModel authenticationModel = new AuthenticationModel();
		boolean res = authenticationModel.setUserDetails(user);

		if (res) {
			response.sendRedirect("UserHome.jsp");
		} else {
			response.sendRedirect("UserSignup.jsp?res=Failer");
		}

	}
}
