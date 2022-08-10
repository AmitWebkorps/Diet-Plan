package com.healthymeal.model;

import java.sql.ResultSet;
import com.healthymeal.dbConnectivity.DbConnectivity;
import com.healthymeal.entity.Login;
import com.healthymeal.entity.User;

public class AuthenticationModel {
	
	public Boolean getLogin(Login l)
	{
		Boolean flag=null;
		String username=l.getUserNameString();
		String password=l.getPasswordString();
		try {
		ResultSet rs= DbConnectivity.query("select * from user where email=? and password=?",username,password); 
		if (rs.next()){
	            if (rs.getString(4).equals("Admin"))
					 flag=true;

				else  flag=false;
	        }
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;
	}
	
	public boolean getSignup(User user)
	{
		try {
			int res = DbConnectivity.update("insert into user(Name,Email,Password,Role) values(?,?,?,?)",user.getName(),
					user.getEmail(), user.getPassword(), user.getRole());
		     if(res>0)
		    	 return true;
		   } catch (Exception e) {
			System.out.println(e);
		}
		
		return true;
	}
	
	public boolean setUserDetails(User user)
	{
		try {
			// res is response
			int res = DbConnectivity.update("update user set age=? ,weight=? ,height=? where email=?",""+user.getAge(),""+user.getWeight(),
					""+user.getHeight(),user.getEmail());
			if(res>0)
				return true;

		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
}
