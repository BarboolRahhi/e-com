package com.cg.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.cg.entity.Order;
import com.cg.entity.Product;
import com.cg.entity.RetailerInventory;
import com.cg.service.RetailerInventoryService;
import com.cg.service.RetailerInventoryServiceImpl;
import com.cg.util.CgRepo;
import com.cg.util.IdNotFound;
import com.cg.util.OrderStatus;
import com.cg.util.ProductNotFound;
import com.cg.util.ValidationException;


public class TestCanceledProduct {

	static RetailerInventoryService service;
	static List<RetailerInventory> retailerList; 
	static List<Order> orderList; 
	
	@BeforeAll
	public static void beforeAll() {
		service = new RetailerInventoryServiceImpl();
	}
	
	@BeforeEach
	public void beforeEach() {
		Product p2 = new Product(102, "Charger C50", "Ram - 4gb Rom - 16gb", 2, 500);
		Order o3 = new Order(1003, p2, OrderStatus.CANCLE, LocalDate.of(2020, 1, 6));
		orderList = new ArrayList<Order>();
		orderList.add(o3);
	}
	
	@Test
	public void test1() throws ProductNotFound {
		assertEquals(orderList, service.getCancelProductReport());
	}

	
	@Test
	public void test2() throws ProductNotFound {
		assertEquals(1, service.getCancelProductReport().size());
	}
}
