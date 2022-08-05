package com.healthymeal.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.healthymeal.dbConnectivity.DbConnectivity;


@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB 
maxFileSize=1024*1024*50,      	// 50 MB
maxRequestSize=1024*1024*100)
public class AddMeal extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//---------------------------------------------------------------------------//	    	
		// getting value from HTML form
		String mealname = request.getParameter("mealname");
		Part imagepart = request.getPart("meal-image");
		String mealprice = request.getParameter("mealprice");
		String mealtype = request.getParameter("mealtype");
//---------------------------------------------------------------------------//

		// creating Connection with database and Prepared Statement

		PreparedStatement ps = DbConnectivity.connect("insert into meals values(?,?,?,?)");

//---------------------------------------------------------------------------//
		InputStream inputstream = null;
		FileOutputStream outputstream = null;
		if (imagepart != null) {

			try {
				inputstream = imagepart.getInputStream();
				outputstream = new FileOutputStream(
						"C:\\Users\\dell\\Documents\\workspace-sts-3.9.12.RELEASE\\HealthyMeals\\WebContent\\images\\"
								+ mealname + ".png");
				int bytes = 0;

				// Reading and writing the image copying image to our folder
				while ((bytes = inputstream.read()) != -1)
					outputstream.write(bytes);
				// ---------------------------------------------------------------------------//

				ps.setString(1, mealname);
				ps.setString(2, mealname + ".png");
				ps.setInt(3, Integer.parseInt(mealprice));
				ps.setString(4, mealtype);

				int res = ps.executeUpdate();
				if (res > 0) {
					// if image copied successfully and data inserted successfully
					response.sendRedirect("AddMeal.jsp?res=success");
				} else {
					throw new FileNotFoundException();
				}
//---------------------------------------------------------------------------//
			} catch (FileNotFoundException | SQLException e) {
				// if any exception generated
				System.out.println(e);
				response.sendRedirect("AddMeal.jsp?res=failer");
			} finally {

				if (outputstream != null) {
//---------------------------------------------------------------------------//

					// Closing all the files that we used previously
					inputstream.close();
					outputstream.close();
				}
			}
		} else {
			System.out.println("not Working");
		}
	}
}
