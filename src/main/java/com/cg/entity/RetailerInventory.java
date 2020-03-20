package com.cg.entity;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

public class RetailerInventory {
	private int retailerId;
	private String retailerName;
	private List<Product> products;
	private LocalDateTime saleDateTime;
	
	public RetailerInventory(int retailerId, String retailerName, List<Product> products, LocalDateTime saleDateTime) {
		super();
		this.retailerId = retailerId;
		this.retailerName = retailerName;
		this.products = products;
		this.saleDateTime = saleDateTime;
	}

	public int getRetailerId() {
		return retailerId;
	}

	public String getRetailerName() {
		return retailerName;
	}

	public List<Product> getProducts() {
		return products;
	}

	public LocalDateTime getSaleDateTime() {
		return saleDateTime;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + retailerId;
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
		RetailerInventory other = (RetailerInventory) obj;
		if (retailerId != other.retailerId)
			return false;
		return true;
	}
	
	
	
}
