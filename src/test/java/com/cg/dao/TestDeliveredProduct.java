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


public class TestDeliveredProduct {
	
	static RetailerInventoryService service;
	static List<RetailerInventory> retailerList; 
	static List<Order> orderList; 
	
	@BeforeAll
	public static void beforeAll() {
		service = new RetailerInventoryServiceImpl();
	}
	
	@BeforeEach
	public void beforeEach() {
		Product p1 = new Product(101, "Nokia C50", "Ram - 4gb Rom - 16gb", 1, 9500);
		Product p3 = new Product(103, "Fan", "Watt - 200w Rate - 4", 1, 3000);
		Order o1 = new Order(1001, p1, OrderStatus.DILIVERED, LocalDate.of(2020, 2, 20));
		Order o2 = new Order(1002, p3, OrderStatus.DILIVERED, LocalDate.of(2020, 1, 14));
		orderList = new ArrayList<Order>();
		orderList.add(o1);
		orderList.add(o2);
	}
	
	@Test
	public void test1() throws ProductNotFound {
		assertEquals(orderList, service.getAllDeliveredProductReport());
	}
	
//	@Test
//	public void test2() {
//		assertThrows(ProductNotFound.class, ()-> service.getAllDeliveredProductReport());
//	}
	
	@Test
	public void test3() throws ProductNotFound {
		assertEquals(orderList.size(), service.getAllDeliveredProductReport().size());
	}
	
}
