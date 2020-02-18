package com.cg.dao;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.cg.service.RetailerInventoryService;
import com.cg.service.RetailerInventoryServiceImpl;
import com.cg.util.IdNotFound;
import com.cg.util.ValidationException;

public class TestAllProductOfRetailer {
	
	RetailerInventoryService service = new RetailerInventoryServiceImpl();
	RetailerInventoryDao dao = new RetailerInventoryDaoImpl();
	
	@Test
	public void test2() {
		assertThrows(IdNotFound.class, ()-> service.getProductReportOfRetailer("4"));
	}
	
	@Test
	public void test3() {
		assertThrows(ValidationException.class, ()-> service.getProductReportOfRetailer("4fg"));
	}

}
