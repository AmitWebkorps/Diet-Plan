package com.healthymeal.dbConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnectivity {
	static Connection con;
	static PreparedStatement ps;
	static ResultSet rSet;
    static int response=0;
	public static PreparedStatement connect(String s1) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql:///HealthyMeal?useSSL=false&allowPublicKeyRetrieval=true", "root", "root");
			ps = con.prepareStatement(s1);
		} catch (Exception e) {
			System.out.println(e);
		}
		return ps;
	}
//------------------------------------------------------------------------//

	public static void close() throws Exception {
		con.close();
	}
//------------------------------------------------------------------------//
	public static int update(String Query,String...para)throws SQLException
	{
		  updateParameter(Query, para);
		  response=ps.executeUpdate();
		return response;
	}
	
//------------------------------------------------------------------------//
	public static ResultSet query(String Query,String...para)throws SQLException
	{
	      updateParameter(Query, para);
		  rSet=ps.executeQuery();
          return rSet;
	}
//------------------------------------------------------------------------//
	public static void updateParameter(String Query,String...para)
	{
		connect(Query);
		   try{
				for(int par=0;par<para.length;par++){
					ps.setString(par+1,para[par]);
				}
		   }
		   catch (Exception e) {
			   System.out.println(e);
		}
	}
//------------------------------------------------------------------------//
	
}
