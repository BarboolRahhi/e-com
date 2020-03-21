package com.cg.service;

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
		Product p7 = new Product(107, "Nitro 5", "graphic 4gb", 2, 50000);
		Order o4 = new Order(1004, p4, OrderStatus.DISPACHED, LocalDate.of(2020, 5, 6));
		Order o5 = new Order(1005, p7, OrderStatus.DISPACHED, LocalDate.of(2020, 7, 6));
		orderList = new ArrayList<Order>();
		orderList.add(o4);
		orderList.add(o5);
	
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
