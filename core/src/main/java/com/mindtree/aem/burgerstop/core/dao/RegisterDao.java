package com.adobe.aem.guides.burger.core.dao;

import com.adobe.aem.guides.burger.core.bean.Register;

public interface RegisterDao {
	public String storeUserObjectIntoDatabase(Register register);
	public String checkUser(Register register);
}	
