package com.mindtree.aem.burgerstop.core.bean;

public class Register {
	String username;
	String	email;
	String password;
	String conpassword;
	String country;
	public Register() {
		super();
	}
	public Register(String username, String email, String password, String conpassword, String country) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.conpassword = conpassword;
		this.country = country;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConpassword() {
		return conpassword;
	}
	public void setConpassword(String conpassword) {
		this.conpassword = conpassword;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Register [username=" + username + ", email=" + email + ", password=" + password + ", conpassword="
				+ conpassword + ", country=" + country + "]";
	}
	
	
	
}
