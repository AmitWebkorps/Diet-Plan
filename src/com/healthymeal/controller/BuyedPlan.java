package com.healthymeal.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.healthymeal.entity.Plans;
import com.healthymeal.model.PlanDetailsModel;

public class BuyedPlan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String userEmail = (String) session.getAttribute("email");

		//modal class
		PlanDetailsModel planDetailsModel = new PlanDetailsModel();
		Plans plans = planDetailsModel.getBuyedPlan(userEmail);

		//response
		request.setAttribute("plan", plans);
		request.getRequestDispatcher("BuyedPlan.jsp?").forward(request, response);
	}

}
