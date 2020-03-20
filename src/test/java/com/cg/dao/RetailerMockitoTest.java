package com.cg.dao;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.cg.entity.Product;
import com.cg.entity.RetailerInventory;
import com.cg.service.RetailerInventoryService;
import com.cg.service.RetailerInventoryServiceImpl;
import com.cg.util.IdNotFound;
import com.cg.util.ProductNotFound;
import com.cg.util.ValidationException;

import name.falgout.jeffrey.testing.junit5.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RetailerMockitoTest {
	static Product p1, p2, p3;
	static List<RetailerInventory> rlist;
	static List<Product> plist1;
	static RetailerInventory r1;
	
	@Mock
	RetailerInventoryDao dao;
	
	@InjectMocks
	RetailerInventoryService ser = new RetailerInventoryServiceImpl();
	
	@BeforeAll 
	public static void BeforeAll() {
		
		p1 = new Product(101, "Nokia C50", "Ram - 4gb Rom - 16gb", 1, 9500);
		p2 = new Product(103, "Fan", "Watt - 200w Rate - 4", 1, 3000);
		p3 = new Product(104, "hp Laptop", "Screen - 15in Ram - 16gb", 1, 45000);
		
		plist1 = new ArrayList<>();
		plist1.add(p1);
		plist1.add(p2);
		plist1.add(p3);		

	}
	
	@SuppressWarnings("unchecked")
	@BeforeEach
	public void beforeEach() throws IdNotFound, ProductNotFound{
		when(dao.getProductReportOfRetailer(1)).thenReturn(plist1);
	    when(dao.getProductReportOfRetailer(4)).thenThrow(IdNotFound.class);
	    when(dao.getProductReportOfRetailer(3)).thenThrow(ProductNotFound.class);
	    when(dao.getProductReportOfRetailer(-35)).thenThrow(ValidationException.class);
	}
	
	@DisplayName("product_report_size_test")
	@Test
	public void test1() throws IdNotFound, ProductNotFound, ValidationException {
		assertEquals(plist1.size(), ser.getProductReportOfRetailer("1").size());
	}
	
	@DisplayName("product_report_list_test")
	@Test
	public void test2() throws IdNotFound, ProductNotFound, ValidationException {
		assertEquals(plist1, ser.getProductReportOfRetailer("1"));
	}
	
	@DisplayName("product_report_exception_test")
	@Test
	public void test3() throws IdNotFound, ProductNotFound, ValidationException {
		assertAll(
				() -> assertThrows(IdNotFound.class, () -> ser.getProductReportOfRetailer("4")),
				() -> assertThrows(ProductNotFound.class, () -> ser.getProductReportOfRetailer("3")),
				() -> assertThrows(ValidationException.class, () -> ser.getProductReportOfRetailer("-35"))
		);
	}
	
	

}
