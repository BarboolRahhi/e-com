package com.cg.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.cg.entity.Order;
import com.cg.entity.Product;
import com.cg.entity.RetailerInventory;

public class CgRepo {

	private static List<RetailerInventory> retailerList = new ArrayList<>();
	private static List<Order> orderList = new ArrayList<>();
	private static List<Product> productList = new ArrayList<>();

	static {

		/**
		 * Product List having name, info, price, retailer_id
		 * 
		 * Product p1 = new Product(product_id, product_name, product_info, retailer_id, product_price);
		 */
		Product p1 = new Product(101, "Nokia C50", "Ram - 4gb Rom - 16gb", 1, 9500);
		Product p2 = new Product(102, "Charger C50", "Ram - 4gb Rom - 16gb", 2, 500);
		Product p3 = new Product(103, "Fan", "Watt - 200w Rate - 4", 1, 3000);
		Product p4 = new Product(104, "hp Laptop", "Screen - 15in Ram - 16gb", 1, 45000);
		Product p5 = new Product(105, "Chair", "Max Weight - 150kg", 4, 300);
		Product p6 = new Product(106, "Harry Potter", "Story Book Rate - 5", 4, 450);
		Product p7 = new Product(107, "Nitro 5", "graphic 4gb", 2, 50000);

		productList.add(p1);
		productList.add(p2);
		productList.add(p3);
		productList.add(p4);
		productList.add(p5);
		productList.add(p6);
		productList.add(p7);

		// Product List Of Retailer one having four product
		List<Product> plist1 = new ArrayList<>();
		plist1.add(p1);
		plist1.add(p3);
		plist1.add(p4);

		// Product List Of Retailer second having one product only
		List<Product> plist2 = new ArrayList<>();
		plist2.add(p2);
		plist2.add(p7);

		// Product List Of Retailer third having no product
		List<Product> plist3 = new ArrayList<>();

		// Product List Of Retailer fourth having two product
		List<Product> plist4 = new ArrayList<>();
		plist4.add(p5);
		plist4.add(p6);
		
		/**
		 * Order List having product, Order Status and Date
		 * 
		 * Order obj = new Order(order_id, product,  order_status, order_date);
		 */

		Order o1 = new Order(1001, p1, OrderStatus.DILIVERED, LocalDate.of(2020, 2, 20));
		Order o2 = new Order(1002, p3, OrderStatus.DILIVERED, LocalDate.of(2020, 1, 14));
		Order o3 = new Order(1003, p2, OrderStatus.CANCLE, LocalDate.of(2020, 1, 6));
		Order o4 = new Order(1004, p4, OrderStatus.DISPACHED, LocalDate.of(2020, 5, 6));
		Order o5 = new Order(1005, p7, OrderStatus.DISPACHED, LocalDate.of(2020, 7, 6));

		orderList.add(o1);
		orderList.add(o2);
		orderList.add(o3);
		orderList.add(o4);
		orderList.add(o5);

		/**
		 *RetailerInventory List having list of product,
		 *
		 *RetailerInventory r1 = new RetailerInventory(retailer_date, retailer_name, list_of_product, join_date);
		 */

		RetailerInventory r1 = new RetailerInventory(1, "Agay Sharma", plist1, LocalDateTime.of(2017, 1, 23, 9, 4));
		RetailerInventory r2 = new RetailerInventory(2, "Rahhi Barbool", plist2,  LocalDateTime.of(2016, 4, 17, 1, 45));
		RetailerInventory r3 = new RetailerInventory(3, "Pritam Sharma", plist3,  LocalDateTime.of(2014, 6, 1, 10, 34));
		RetailerInventory r4 = new RetailerInventory(4, "Rahul Sharma", plist4,  LocalDateTime.of(2014, 6, 1, 10, 34));

		retailerList.add(r1);
		retailerList.add(r2);
		retailerList.add(r3);
		retailerList.add(r4);
	}

	private CgRepo() {
		
	}

	public static List<RetailerInventory> getRetailerList() {
		return retailerList;
	}

	public static List<Order> getOrderList() {
		return orderList;
	}

	public static List<Product> getProductList() {
		return productList;
	}
	
}
