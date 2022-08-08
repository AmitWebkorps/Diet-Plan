package com.healthymeal.controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthymeal.dbConnectivity.DbConnectivity;


public class DeletePlan extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  //---------------------------------------------------------------------//
		String planName=request.getParameter("planName");
		
 //---------------------------------------------------------------------//
		PreparedStatement pStatement=DbConnectivity.connect("delete from plans where planName=?");
		try {
			pStatement.setString(1,planName );
 //---------------------------------------------------------------------//
			int res=pStatement.executeUpdate();
			if(res>0)
				response.sendRedirect("ViewPlan");
//---------------------------------------------------------------------//
			else
				throw new SQLException();
				
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
