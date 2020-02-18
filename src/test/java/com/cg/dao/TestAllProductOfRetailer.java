package com.cg.dao;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cg.service.RetailerInventoryService;
import com.cg.service.RetailerInventoryServiceImpl;
import com.cg.util.IdNotFound;
import com.cg.util.ValidationException;

public class TestAllProductOfRetailer {
	
	static RetailerInventoryService service;
	
	@BeforeAll
	public static void BeforeClass() {
		service = new RetailerInventoryServiceImpl();
	}
	
	@Test
	public void test1() {
		assertThrows(IdNotFound.class, ()-> service.getProductReportOfRetailer("4"));
	}
	
	@Test
	public void test2() {
		assertThrows(ValidationException.class, ()-> service.getProductReportOfRetailer("4fg"));
	}
	
	@Test
	public void test3() {
		assertThrows(ValidationException.class, ()-> service.getProductReportOfRetailer("-12"));
	}
	
	@Test
	public void test4() {
		assertThrows(ValidationException.class, ()-> service.getProductReportOfRetailer("12./"));
	}


}
