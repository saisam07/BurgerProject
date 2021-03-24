package com.mindtree.aem.burgerstop.core.service.implementation;

import com.mindtree.aem.burgerstop.core.bean.Register;
import com.mindtree.aem.burgerstop.core.dao.RegisterDao;
import com.mindtree.aem.burgerstop.core.dao.implementation.RegisterDaoImpl;
import com.mindtree.aem.burgerstop.core.service.RegisterService;

public class RegisterServiceImpl implements RegisterService{

	@Override
	public String storeUserDataIntoObject(String username, String email, String password, String conpassword, String country) {
			
			Register register=new Register();
			register.setUsername(username);
			register.setEmail(email);
			register.setPassword(password);
			register.setConpassword(conpassword);
			register.setCountry(country);
			
			RegisterDao rd=new RegisterDaoImpl();
			String msg= rd.checkUser(register);
			
			return msg;
	}

}
