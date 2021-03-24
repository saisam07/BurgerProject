package com.adobe.aem.guides.burger.core.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionEstablish {
	final private static String url="jdbc:mysql://localhost:3306/BURGERSTOP?autoReconnect=true&useSSL=false"; 
	final private static String userName="root";
	final private static String password="Dec2388@21";

	
	public Connection databaseConnection() {
		

		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		try {
			con = DriverManager.getConnection(url, userName,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return con;
	}
	public void closeConnection(PreparedStatement pst, Connection con) {
		if (pst != null) {
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
