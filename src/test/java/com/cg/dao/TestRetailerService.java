package com.cg.dao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.List;
import java.util.stream.Collectors;


import com.cg.service.RetailerInventoryService;
import com.cg.service.RetailerInventoryServiceImpl;
import com.cg.util.CgRepo;
import com.cg.util.IdNotFound;
import com.cg.util.ProductNotFound;
import com.cg.util.ValidationException;

public class TestRetailerService {
	
	RetailerInventoryService service = new RetailerInventoryServiceImpl();
	RetailerInventoryDao dao = new RetailerInventoryDaoImpl();
	
	@Test
	public void test1() {
		assertEquals(dao.getListOfRetailer(), service.getListOfRetailer());
	}
	
	@Test
	public void test2() {
		assertThrows(IdNotFound.class, ()-> service.getProductReportOfRetailer("4"));
	}
	
	@Test
	public void test3() {
		assertThrows(ValidationException.class, ()-> service.getProductReportOfRetailer("4fg"));
	}
	
	@Test
	public void test4() throws ProductNotFound {
		assertEquals(dao.getAllDeliveredProductReport(), service.getAllDeliveredProductReport());
	}
	
	

}
