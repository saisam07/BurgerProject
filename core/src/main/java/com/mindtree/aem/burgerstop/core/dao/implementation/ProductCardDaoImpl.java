package com.mindtree.aem.burgerstop.core.dao.implementation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.aem.burgerstop.core.bean.ProductCard;
import com.mindtree.aem.burgerstop.core.dao.ProductCardDao;
import com.mindtree.aem.burgerstop.core.utility.ConnectionEstablish;

public class ProductCardDaoImpl implements ProductCardDao{

	public List<ProductCard> getData() {

		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;

		ConnectionEstablish connection = new ConnectionEstablish();
		

		List<ProductCard> tile = new ArrayList<ProductCard>();
		ProductCard tiles = new ProductCard();
		String title;

		String description;

		float price;

		try {
			con = connection.databaseConnection();
			statement = con.createStatement();
			resultSet = statement.executeQuery("select * from product_tile_data");

			while (resultSet.next()) {

				title = resultSet.getString("title");

				description = resultSet.getString("product_description");

				price = resultSet.getFloat("price");

				tiles.setTitle(title);
				tiles.setDescription(description);
				tiles.setPrice(price);
				tile.add(tiles);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		finally {
			
			connection.closeConnection(statement, con);
		}
		return tile;
	}

}
