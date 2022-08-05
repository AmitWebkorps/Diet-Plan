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

public class ViewPlan extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PreparedStatement ps=DbConnectivity.connect("select * from Plans");
		ArrayList<String> plan=new ArrayList<String>();
		try {
		ResultSet data=ps.executeQuery();
		while(data.next()){
			plan.add(data.getString(1));
		}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

}
