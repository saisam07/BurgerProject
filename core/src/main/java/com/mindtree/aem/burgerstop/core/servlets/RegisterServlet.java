package com.adobe.aem.guides.burger.core.servlets;

import java.io.IOException;


import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.aem.guides.burger.core.service.RegisterService;
import com.adobe.aem.guides.burger.core.service.implementation.RegisterServiceImpl;


@Component(service=Servlet.class,
	property= {"sling.servlet.methods=" + HttpConstants.METHOD_GET, 
			"sling.servlet.paths=" +"/bin/burger/RegisterServlet"})
public class RegisterServlet extends SlingSafeMethodsServlet{
	
	private static final long serialVersionUID= 1L;
	
	private final Logger logger= LoggerFactory.getLogger(getClass());
		
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		logger.info("In Servlet");
		response.setHeader("Content-Type", "text/html");
		String username= request.getParameter("username");
		String email= request.getParameter("email");
		String password= request.getParameter("password");
		String conpassword= request.getParameter("conpassword");
		String country= request.getParameter("country");
		
		RegisterService rs=new RegisterServiceImpl();
		String userRegistered = rs.storeUserDataIntoObject(username, email, password, conpassword, country);
		
		if(userRegistered=="SUCCESS") {
			response.getWriter().write("Successfully registered");
		}else {
			response.getWriter().write(userRegistered);
		}
		
		logger.info("End of Servlet");
		
		response.getWriter().close();
	}
	
}
