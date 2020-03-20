package com.cg.service;

import java.util.List;

import com.cg.entity.Order;
import com.cg.entity.Product;
import com.cg.entity.RetailerInventory;
import com.cg.util.IdNotFound;
import com.cg.util.OrderStatus;
import com.cg.util.ProductNotFound;
import com.cg.util.ValidationException;

public interface RetailerInventoryService {
	
	List<RetailerInventory> getListOfRetailer();
	List<Product> getProductReportOfRetailer(String id) throws IdNotFound, ProductNotFound, ValidationException;
	List<Order> getAllDeliveredProductReport() throws ProductNotFound;
	List<Order> getDeliveredProductReportOfRetailer(String id) throws IdNotFound, ProductNotFound, ValidationException;
	List<Order> getDispachedProductReport() throws ProductNotFound;
	List<Order> getCancelProductReport() throws ProductNotFound;
	
	
}
