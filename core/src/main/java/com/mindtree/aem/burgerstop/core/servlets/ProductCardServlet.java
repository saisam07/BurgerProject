package com.mindtree.aem.burgerstop.core.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mindtree.aem.burgerstop.core.dao.ProductCardDaoImpl;
import com.mindtree.aem.burgerstop.core.entity.ProductCard;

@Component(service = Servlet.class, property = { Constants.SERVICE_DESCRIPTION + "=Product card servlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_GET,
		"sling.servlet.paths=" + "/bin/aem-burgerstop/productCardServlet" })

public class ProductCardServlet extends SlingSafeMethodsServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Logger logger = LoggerFactory.getLogger(getClass());

	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Content-Type", "text/html");

		logger.info("start of servlet");
		ProductCardDaoImpl dao = new ProductCardDaoImpl();

		List<ProductCard> card = new ArrayList<ProductCard>();

		card = dao.getData();

		for (int i = 0; i < card.size(); i++) {
			response.getWriter().println(card.get(i).getTitle());
			response.getWriter().print(";");
			response.getWriter().println(card.get(i).getDescription());
			response.getWriter().print(";");
			response.getWriter().println(card.get(i).getPrice());
			response.getWriter().print(";");
		}

		response.getWriter().close();
		logger.info("end of servlet");
	}

}
