package com.healthymeal.dbConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DbConnectivity {
	static Connection con;
	static PreparedStatement ps;

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

	public static void close() throws Exception {
		con.close();
	}
}
