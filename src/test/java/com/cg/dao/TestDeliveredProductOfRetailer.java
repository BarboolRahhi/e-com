package com.cg.dao;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.cg.service.RetailerInventoryService;
import com.cg.service.RetailerInventoryServiceImpl;
import com.cg.util.IdNotFound;
import com.cg.util.ProductNotFound;
import com.cg.util.ValidationException;

public class TestDeliveredProductOfRetailer {

	RetailerInventoryService service = new RetailerInventoryServiceImpl();
	RetailerInventoryDao dao = new RetailerInventoryDaoImpl();
	
	@Test
	public void test1() {
		assertThrows(IdNotFound.class, ()-> service.getDeliveredProductReportOfRetailer("56"));
	}
	
	@Test
	public void test2() {
		assertThrows(ValidationException.class, ()-> service.getDeliveredProductReportOfRetailer("2df"));
	}
	
	@Test
	public void test3() {
		assertThrows(ProductNotFound.class, ()-> service.getDeliveredProductReportOfRetailer("2"));
	}
}
