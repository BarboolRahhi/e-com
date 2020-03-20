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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + orderId;
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
		Order other = (Order) obj;
		if (orderId != other.orderId)
			return false;
		return true;
	}
	
	
	
}
