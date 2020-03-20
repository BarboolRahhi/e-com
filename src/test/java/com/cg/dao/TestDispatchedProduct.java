package com.cg.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.cg.entity.Order;
import com.cg.entity.Product;
import com.cg.entity.RetailerInventory;
import com.cg.service.RetailerInventoryService;
import com.cg.service.RetailerInventoryServiceImpl;
import com.cg.util.IdNotFound;
import com.cg.util.OrderStatus;
import com.cg.util.ProductNotFound;
import com.cg.util.ValidationException;


public class TestDispatchedProduct {

	static RetailerInventoryService service;
	static List<Order> orderList; 
	
	@BeforeAll
	public static void testbeforeAll() {
		service = new RetailerInventoryServiceImpl();
	}
	
	@BeforeEach
	public void beforeEach() {
		Product p4 = new Product(104, "hp Laptop", "Screen - 15in Ram - 16gb", 1, 45000);
		Order o4 = new Order(1003, p4, OrderStatus.DISPACHED, LocalDate.of(2020, 5, 6));
		orderList = new ArrayList<Order>();
		orderList.add(o4);
	
	}
	
	
	@Test
	public void test1() throws ProductNotFound {
		assertEquals(orderList, service.getDispachedProductReport());
	}
	
//	@Test
//	public void test2() {
//		assertThrows(ProductNotFound.class, ()-> service.getDispachedProductReport());
//	}
//	
	@Test
	public void test3() throws ProductNotFound {
		assertEquals(orderList.size(), service.getDispachedProductReport().size());
	}
}
