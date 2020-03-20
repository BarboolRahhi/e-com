package com.cg.dao;

import java.util.List;

import com.cg.entity.Order;
import com.cg.entity.Product;
import com.cg.entity.RetailerInventory;
import com.cg.util.IdNotFound;
import com.cg.util.OrderStatus;
import com.cg.util.ProductNotFound;

public interface RetailerInventoryDao {
	
	List<RetailerInventory> getListOfRetailer();
	List<Product> getProductReportOfRetailer(int id) throws IdNotFound, ProductNotFound;
	List<Order> getDeliveredProductReportOfRetailer(int id) throws IdNotFound, ProductNotFound;
	List<Order> getProductReportByOrderStatus(OrderStatus status) throws ProductNotFound;
	
}
