package com.cg.entity;

import java.time.LocalDate;

import com.cg.util.OrderStatus;

public class Order {
	private int orderId;
	private Product product;
	private OrderStatus status;
	private LocalDate orderDate;
	
	public Order(int orderId, Product product, OrderStatus status, LocalDate orderDate) {
		super();
		this.orderId = orderId;
		this.product = product;
		this.status = status;
		this.orderDate = orderDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public Product getProduct() {
		return product;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}
	
	
}
