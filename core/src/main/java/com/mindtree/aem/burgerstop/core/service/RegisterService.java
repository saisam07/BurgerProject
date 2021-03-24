package com.adobe.aem.guides.burger.core.service;

public interface RegisterService {
	public String storeUserDataIntoObject(String username, String email, String password, String conpassword, String country);
}
