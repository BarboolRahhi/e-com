package com.cg.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.cg.entity.Product;
import com.cg.entity.RetailerInventory;
import com.cg.service.RetailerInventoryService;
import com.cg.service.RetailerInventoryServiceImpl;
import com.cg.util.CgRepo;


public class TestALLRetailerList {

	static RetailerInventoryService service;
	static List<RetailerInventory> rlist; 

	@BeforeAll
	public static void beforeAll() {
		service = new RetailerInventoryServiceImpl();
	}

	@BeforeEach
	public void beforeEach() {

		Product p1 = new Product(101, "Nokia C50", "Ram - 4gb Rom - 16gb", 1, 9500);
		Product p2 = new Product(102, "Charger C50", "Ram - 4gb Rom - 16gb", 2, 500);
		Product p3 = new Product(103, "Fan", "Watt - 200w Rate - 4", 1, 3000);
		Product p4 = new Product(104, "hp Laptop", "Screen - 15in Ram - 16gb", 1, 45000);

		// Product List Of Retailer one having four product
		List<Product> plist1 = new ArrayList<>();
		plist1.add(p1);
		plist1.add(p3);
		plist1.add(p4);

		// Product List Of Retailer second having one product only
		List<Product> plist2 = new ArrayList<>();
		plist2.add(p2);

		// Product List Of Retailer third having no product
		List<Product> plist3 = new ArrayList<>();

		RetailerInventory r1 = new RetailerInventory(1, "Agay Sharma", plist1, LocalDateTime.of(2017, 1, 23, 9, 4));
		RetailerInventory r2 = new RetailerInventory(2, "Rahhi Barbool", plist2,  LocalDateTime.of(2016, 4, 17, 1, 45));
		RetailerInventory r3 = new RetailerInventory(3, "Pritam Sharma", plist3,  LocalDateTime.of(2014, 6, 1, 10, 34));

		rlist = new ArrayList<>();
		rlist.add(r1);
		rlist.add(r2);
		rlist.add(r3);
	}


	@Test
	public void test1() {
		assertEquals(rlist, service.getListOfRetailer());
	}

	@Test
	public void test2() {
		assertEquals(3, service.getListOfRetailer().size());
	}

}
