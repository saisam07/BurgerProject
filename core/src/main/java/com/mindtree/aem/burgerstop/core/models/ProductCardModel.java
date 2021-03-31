package com.mindtree.aem.burgerstop.core.models;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

import com.mindtree.aem.burgerstop.core.bean.ProductCard;
import com.mindtree.aem.burgerstop.core.dao.ProductCardDao;
import com.mindtree.aem.burgerstop.core.dao.implementation.ProductCardDaoImpl;

@Model(adaptables = Resource.class)
public class ProductCardModel {

	List<ProductCard> cards = new ArrayList<ProductCard>();

	ProductCardDao dao = new ProductCardDaoImpl();

	@PostConstruct
	public void display() {

		cards = dao.getData();

	}

	public List<ProductCard> getDetails() {

		return cards;
	}
}
