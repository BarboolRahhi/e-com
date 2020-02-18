package com.cg.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.entity.RetailerInventory;
import com.cg.service.RetailerInventoryService;
import com.cg.service.RetailerInventoryServiceImpl;
import com.cg.util.CgRepo;

public class TestALLRetailerList {
		
	static RetailerInventoryService service;
	static List<RetailerInventory> retailerList; 
	
	@BeforeAll
	public static void BeforeClass() {
		service = new RetailerInventoryServiceImpl();
	}
	
	@BeforeEach
	public void beforeEach() {
		retailerList = CgRepo.rlist;
	}
	

	@Test
	public void test1() {
		assertEquals(retailerList, service.getListOfRetailer());
	}
	
	@Test
	public void test2() {
		assertEquals(retailerList, service.getListOfRetailer());
	}
	
}
