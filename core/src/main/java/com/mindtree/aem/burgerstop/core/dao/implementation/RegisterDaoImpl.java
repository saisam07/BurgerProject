package com.adobe.aem.guides.burger.core.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.adobe.aem.guides.burger.core.bean.Register;
import com.adobe.aem.guides.burger.core.dao.RegisterDao;
import com.adobe.aem.guides.burger.core.utility.ConnectionEstablish;

public class RegisterDaoImpl implements RegisterDao {
	ConnectionEstablish ce = new ConnectionEstablish();

	@Override
	public String storeUserObjectIntoDatabase(Register register) {
		
		Connection con = null;
		PreparedStatement pst = null;
		boolean isAdded = false;

		con = ce.databaseConnection();
		try {
			String query = "Insert into UserData(USER_NAME, USER_EMAIL, USER_PASSWORD, USER_CONFIRMPASSWORD, USER_COUNTRY) values(?,?,?,?,?)";
			pst = con.prepareStatement(query);
			
			pst.setString(1, register.getUsername());
			pst.setString(2, register.getEmail());
			pst.setString(3, register.getPassword());
			pst.setString(4, register.getConpassword());
			pst.setString(5, register.getCountry());
			pst.execute();

			isAdded = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ce.closeConnection(pst, con);
		}
		if (isAdded) {
			return "SUCCESS";
		} else {
			return "Something went wrong";
		}
	}

	@Override
	public String checkUser(Register register) {
		Statement st;
		ResultSet rs;
		String usernameDB="";
		boolean present=false;
		String msg="";
		Connection con=ce.databaseConnection();
		
		try {
			st=con.createStatement();
			rs=st.executeQuery("Select USER_NAME from UserData");
			while(rs.next()) {
				usernameDB = rs.getString("USER_NAME");
				if(register.getUsername().equals(usernameDB)) {
					present=true;
				}
			}
			if(present) {
				msg= "User already exists";
				rs.close();
				st.close();
				con.close();
			}else {
				msg=storeUserObjectIntoDatabase(register);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}
	
	

}
