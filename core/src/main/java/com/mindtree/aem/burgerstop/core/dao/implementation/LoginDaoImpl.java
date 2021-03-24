package com.mindtree.aem.burgerstop.core.dao.implementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mindtree.aem.burgerstop.core.dao.LoginDao;


public class LoginDaoImpl implements LoginDao{
	public String authenticateUser(String un , String pw) {
        System.out.println("login dao");
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
		boolean isPresent = false;

		String userNameDB = "";
		String passwordDB = "";

		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
		 
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BURGERSTOP","root","Dec2388@21");
		statement = con.createStatement();
		resultSet = statement.executeQuery("select USER_NAME, USER_PASSWORD from UserData");
		while (resultSet.next()) 
		{
			
		userNameDB = resultSet.getString("USER_NAME");
		passwordDB = resultSet.getString("USER_PASSWORD");
		if (un.equals(userNameDB) && pw.equals(passwordDB)) 
		  {
		    isPresent = true;
		    break;
	       } 
		} 
		}
		catch (SQLException e) {
		e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(isPresent)
			return "Valid user credentials";
		else
		    return "Invalid user credentials";
		}
}
