package com.cg.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.cg.entity.Product;
import com.cg.entity.RetailerInventory;
import com.cg.service.RetailerInventoryService;
import com.cg.service.RetailerInventoryServiceImpl;
import com.cg.util.IdNotFound;
import com.cg.util.ProductNotFound;
import com.cg.util.ValidationException;


public class TestProductOfRetaileTest {

	static RetailerInventoryService service;
	static List<RetailerInventory> rlist;
	static List<Product> plist1;

	@BeforeAll
	public static void beforeAll() {
		service = new RetailerInventoryServiceImpl();
	}

	@BeforeEach
	public void beforeEach() {

		Product p1 = new Product(101, "Nokia C50", "Ram - 4gb Rom - 16gb", 1, 9500);
		Product p3 = new Product(103, "Fan", "Watt - 200w Rate - 4", 1, 3000);
		Product p4 = new Product(104, "hp Laptop", "Screen - 15in Ram - 16gb", 1, 45000);

		// Product List Of Retailer one having four product
		plist1 = new ArrayList<>();
		plist1.add(p1);
		plist1.add(p3);
		plist1.add(p4);

		RetailerInventory r1 = new RetailerInventory(1, "Agay Sharma", plist1, LocalDateTime.of(2017, 1, 23, 9, 4));

		rlist = new ArrayList<>();
		rlist.add(r1);

	}

	@Test
	public void testReatiler1() {
		assertThrows(IdNotFound.class, () -> service.getProductReportOfRetailer("4"));
	}

	@Test
	public void test2() {
		assertThrows(ValidationException.class, () -> service.getProductReportOfRetailer("4fg"));
	}

	@Test
	public void test3() {
		assertThrows(ValidationException.class, () -> service.getProductReportOfRetailer("-12"));
	}

	@Test
	public void test4() {
		assertThrows(ValidationException.class, () -> service.getProductReportOfRetailer("12./"));
	}

	@Test
	public void test5() throws ProductNotFound, IdNotFound, ValidationException {
		assertEquals(plist1,
				service.getProductReportOfRetailer("1"));
	}

}
