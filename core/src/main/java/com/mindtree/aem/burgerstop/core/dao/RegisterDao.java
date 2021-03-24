package com.mindtree.aem.burgerstop.core.dao;

import com.mindtree.aem.burgerstop.core.bean.Register;

public interface RegisterDao {
	public String storeUserObjectIntoDatabase(Register register);
	public String checkUser(Register register);
}	
