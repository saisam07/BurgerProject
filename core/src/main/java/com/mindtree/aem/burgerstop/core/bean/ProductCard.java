package com.mindtree.aem.burgerstop.core.bean;

public class ProductCard {

	private String title;
	private String description;
	private float price;
	private String specification;
	private String imgDetails;
	private String pdpPath;
	private String cartPath;
	private String category;

	public ProductCard() {
		// TODO Auto-generated constructor stub
	}

	

	public ProductCard(String title, String description, float price, String specification, String imgDetails,
			String pdpPath, String cartPath, String category) {
		super();
		this.title = title;
		this.description = description;
		this.price = price;
		this.specification = specification;
		this.imgDetails = imgDetails;
		this.pdpPath = pdpPath;
		this.cartPath = cartPath;
		this.category = category;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



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

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getImgDetails() {
		return imgDetails;
	}

	public void setImgDetails(String imgDetails) {
		this.imgDetails = imgDetails;
	}

	public String getPdpPath() {
		return pdpPath;
	}

	public void setPdpPath(String pdpPath) {
		this.pdpPath = pdpPath;
	}

	public String getCartPath() {
		return cartPath;
	}

	public void setCartPath(String cartPath) {
		this.cartPath = cartPath;
	}



	@Override
	public String toString() {
		return "ProductCard [title=" + title + ", description=" + description + ", price=" + price + ", specification="
				+ specification + ", imgDetails=" + imgDetails + ", pdpPath=" + pdpPath + ", cartPath=" + cartPath
				+ ", category=" + category + "]";
	}

	
}
