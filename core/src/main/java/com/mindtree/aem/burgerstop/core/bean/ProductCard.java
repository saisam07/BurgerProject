package com.mindtree.aem.burgerstop.core.bean;

public class ProductCard {
	String title;
	String description;
	float price;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ProductCard [title=" + title + ", description=" + description + ", price=" + price + "]";
	}

}
