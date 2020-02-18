package com.cg.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.cg.service.RetailerInventoryService;
import com.cg.service.RetailerInventoryServiceImpl;

public class TestALLRetailerList {
	

	RetailerInventoryService service = new RetailerInventoryServiceImpl();
	RetailerInventoryDao dao = new RetailerInventoryDaoImpl();
	
	@Test
	public void test1() {
		assertEquals(dao.getListOfRetailer(), service.getListOfRetailer());
	}
	
}
