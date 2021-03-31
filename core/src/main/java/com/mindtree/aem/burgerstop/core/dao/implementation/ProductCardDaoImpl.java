package com.mindtree.aem.burgerstop.core.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mindtree.aem.burgerstop.core.bean.ProductCard;
import com.mindtree.aem.burgerstop.core.dao.ProductCardDao;
import com.mindtree.aem.burgerstop.core.utility.ConnectionEstablish;

public class ProductCardDaoImpl implements ProductCardDao {

	private final Logger logger = LoggerFactory.getLogger(getClass());
//public static void main(String args[]) {
//	List<ProductCard> tile1 = new ArrayList<ProductCard>();
//		tile1=new ProductCardDaoImpl().getData();
//		System.out.println(tile1);
//}

	public List<ProductCard> getData() {
		logger.info("In product card dao impl class");

		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		ConnectionEstablish connection = new ConnectionEstablish();

		List<ProductCard> tile = new ArrayList<ProductCard>();
	
		String title;

		String description;

		float price;

		String specification;

		String imgDetails;

		String pdpPath;

		String cartPath;

		String category;
		try {
			con = connection.databaseConnection();
			String query = "select * from productData";
			statement = con.prepareStatement(query);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {

				logger.info("In resultset");
				title = resultSet.getString("title");
				logger.info(title);
				description = resultSet.getString("product_description");
				logger.info(description);
				price = resultSet.getFloat("price");

				specification = resultSet.getString("product_specification");

				imgDetails = resultSet.getString("img_details");

				pdpPath = resultSet.getString("pdp_path");
				logger.info(pdpPath);
				cartPath = resultSet.getString("cart_path");
				logger.info(cartPath);
				category=resultSet.getString("category");

				
				tile.add(new ProductCard(title, description, price, specification, imgDetails, pdpPath, cartPath,category));

				logger.info("tiles ",tile);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			connection.closeConnection(statement, con);
		}
		logger.info("End of dao");
		return tile;

	}

}
