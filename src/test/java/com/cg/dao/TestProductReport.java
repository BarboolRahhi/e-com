package com.cg.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.entity.Order;
import com.cg.entity.Product;
import com.cg.util.OrderStatus;
import com.cg.util.ProductNotFound;


public class TestProductReport {

	static RetailerInventoryDao dao;
	static List<Order> orderList; 
	
	@BeforeAll
	public static void beforeAll() {
		dao = new RetailerInventoryDaoImpl();
	}
	
	@BeforeEach
	public void beforeEach() {
		
		Product p1 = new Product(101, "Nokia C50", "Ram - 4gb Rom - 16gb", 1, 9500);
		Product p2 = new Product(102, "Charger C50", "Ram - 4gb Rom - 16gb", 2, 500);
		Product p3 = new Product(103, "Fan", "Watt - 200w Rate - 4", 1, 3000);
		Product p4 = new Product(104, "hp Laptop", "Screen - 15in Ram - 16gb", 1, 45000);
		Product p7 = new Product(107, "Nitro 5", "graphic 4gb", 2, 50000);
		
		Order o1 = new Order(1001, p1, OrderStatus.DILIVERED, LocalDate.of(2020, 2, 20));
		Order o2 = new Order(1002, p3, OrderStatus.DILIVERED, LocalDate.of(2020, 1, 14));
		Order o3 = new Order(1003, p2, OrderStatus.CANCLE, LocalDate.of(2020, 1, 6));
		Order o4 = new Order(1004, p4, OrderStatus.DISPACHED, LocalDate.of(2020, 5, 6));
		Order o5 = new Order(1005, p7, OrderStatus.DISPACHED, LocalDate.of(2020, 7, 6));

		orderList = new ArrayList<>();
		orderList.add(o1);
		orderList.add(o2);
		orderList.add(o3);
		orderList.add(o4);
		orderList.add(o5);
	}
	
	@Test
	public void testDispatchProduct() throws ProductNotFound {
		List<Order> tempOrderList = orderList.stream()
				.filter(o-> o.getStatus().equals(OrderStatus.DISPACHED))
				.collect(Collectors.toList());

		assertEquals(tempOrderList, dao.getProductReportByOrderStatus(OrderStatus.DISPACHED));
	}
	
	@Test
	public void testCancleProduct() throws ProductNotFound {
		List<Order> tempOrderList = orderList.stream()
				.filter(o-> o.getStatus().equals(OrderStatus.CANCLE))
				.collect(Collectors.toList());

		assertEquals(tempOrderList, dao.getProductReportByOrderStatus(OrderStatus.CANCLE));
	}
	
	@Test
	public void testDeliveredProduct() throws ProductNotFound {
		List<Order> tempOrderList = orderList.stream()
				.filter(o-> o.getStatus().equals(OrderStatus.DILIVERED))
				.collect(Collectors.toList());

		assertEquals(tempOrderList, dao.getProductReportByOrderStatus(OrderStatus.DILIVERED));
	}


}
