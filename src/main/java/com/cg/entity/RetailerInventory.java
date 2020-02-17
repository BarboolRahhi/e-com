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
	
}
