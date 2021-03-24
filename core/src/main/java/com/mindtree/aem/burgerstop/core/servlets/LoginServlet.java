package com.mindtree.aem.burgerstop.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mindtree.aem.burgerstop.core.dao.LoginDao;
import com.mindtree.aem.burgerstop.core.dao.implementation.LoginDaoImpl;




@Component(service=Servlet.class,
property = {"sling.servlet.paths=" + "/bin/burger/LoginServlet"} )

public class LoginServlet extends SlingAllMethodsServlet
{
	private static final long serialVersionUID = 1L;
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException 
	{
		logger.info("In Login Servlet");
		String un = request.getParameter("username");
		logger.info("un2="+un);
		String pw = request.getParameter("password");
		logger.info("pw2="+pw);
		LoginDao dao = new LoginDaoImpl();
		String check = 	dao.authenticateUser(un, pw);
		logger.info("check="+check);
		response.setHeader("Content-Type","text/html");
		response.getWriter().println(check);
		response.getWriter().close();
  
		logger.info("end of login servlet");
	}
}
