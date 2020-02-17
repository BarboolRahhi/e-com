package com.cg.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.cg.entity.Order;
import com.cg.entity.Product;
import com.cg.entity.RetailerInventory;

public class CgRepo {
	
	public static List<RetailerInventory> rlist = new ArrayList<>();
	public static List<Order> olist = new ArrayList<>();
	public static List<Product> allProductlist = new ArrayList<>();
 	
	static {

		//-----Product List---prod_id
		Product p1 = new Product(101, "Nokia C50", "Ram - 4gb Rom - 16gb", 1, 9500);
		Product p2 = new Product(102, "Charger C50", "Ram - 4gb Rom - 16gb", 2, 500);
		Product p3 = new Product(103, "Fan", "Watt - 200w Rate - 4", 1, 3000);
		Product p4 = new Product(104, "hp Laptop", "Screen - 15in Ram - 16gb", 1, 45000);
		
		allProductlist.add(p1);
		allProductlist.add(p2);
		allProductlist.add(p3);
		allProductlist.add(p4);
		
		List<Product> plist1 = new ArrayList<>();
		plist1.add(p1);
		plist1.add(p3);
		plist1.add(p4);
		
		List<Product> plist2 = new ArrayList<>();
		plist2.add(p2);
		
		List<Product> plist3 = new ArrayList<>();
		
		Order o1 = new Order(1001, p1, OrderStatus.DILIVERED, LocalDate.of(2020, 2, 20));
		Order o2 = new Order(1002, p3, OrderStatus.DILIVERED, LocalDate.of(2020, 1, 14));
		Order o3 = new Order(1003, p2, OrderStatus.CANCLE, LocalDate.of(2020, 1, 6));
		Order o4 = new Order(1003, p4, OrderStatus.DISPACHED, LocalDate.of(2020, 5, 6));
		
		olist.add(o1);
		olist.add(o2);
		olist.add(o3);
		olist.add(o4);
		 
		RetailerInventory r1 = new RetailerInventory(1, "Agay Sharma", plist1, LocalDateTime.of(2017, 1, 23, 9, 4));
		RetailerInventory r2 = new RetailerInventory(2, "Rahhi Barbool", plist2,  LocalDateTime.of(2016, 4, 17, 1, 45));
		RetailerInventory r3 = new RetailerInventory(3, "Pritam Sharma", plist3,  LocalDateTime.of(2014, 6, 1, 10, 34));
		
		rlist.add(r1);
		rlist.add(r2);
		rlist.add(r3);
	}
}
