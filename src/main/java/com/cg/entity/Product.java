package com.cg.entity;

public class Product {
	private int productId;
	private String productName;
	private String productInfo;
	private int retailerId;
	private double price;
	
	public Product(int productId, String productName, String productInfo, int retailerId, double price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productInfo = productInfo;
		this.retailerId = retailerId;
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public String getProductInfo() {
		return productInfo;
	}

	public int getRetailerId() {
		return retailerId;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + productId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (productId != other.productId)
			return false;
		return true;
	}

}
