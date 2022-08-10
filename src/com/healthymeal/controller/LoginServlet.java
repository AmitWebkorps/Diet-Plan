package com.healthymeal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthymeal.entity.Login;
import com.healthymeal.model.AuthenticationModel;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// getting user/Admin details from user/Admin login from
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// entity class code
		Login login = new Login();
		login.setUserNameString(username);
		login.setPasswordString(password);

		// model class code
		AuthenticationModel authenticationModel = new AuthenticationModel();
		Boolean respon = authenticationModel.getLogin(login);

		// response code
		if (respon == null) {
			response.sendRedirect("login.jsp?fail=failer");
		} else if (respon) {
			response.sendRedirect("AddMeal.jsp");
		} else {
			HttpSession session = request.getSession(true);
			session.setAttribute("email", username);

			response.sendRedirect("UserHome.jsp");
		}

	}

}
