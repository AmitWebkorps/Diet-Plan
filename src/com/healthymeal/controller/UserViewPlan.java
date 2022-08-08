package com.healthymeal.controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthymeal.dbConnectivity.DbConnectivity;
import com.healthymeal.modal.Plans;

public class UserViewPlan extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//-----------------------------------------------------------//
		ArrayList<Plans> plans=new ArrayList<Plans>();
//-----------------------------------------------------------//
		PreparedStatement ps=DbConnectivity.connect("select * from plans");
		try {
			ResultSet data=ps.executeQuery();
//-----------------------------------------------------------//
			while(data.next()){
			 Plans plan= new Plans();
//-----------------------------------------------------------//
			 plan.setPlanName(data.getString(2));
			 plan.setPlanDays(data.getString(3));
			 plan.setPlanPrice(data.getString(4));
			 plan.setWeightFrom(data.getString(5));
			 plan.setWeightTo(data.getString(6));
//-----------------------------------------------------------//
			 plans.add(plan);
			}
//-----------------------------------------------------------//
			request.setAttribute("plans", plans);
			request.getRequestDispatcher("UserViewPlan.jsp").forward(request,response);
	    }
		catch(Exception e){
			System.out.println(e);
		}
	}

}
