package com.cg.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.cg.service.RetailerInventoryService;
import com.cg.service.RetailerInventoryServiceImpl;
import com.cg.util.IdNotFound;
import com.cg.util.ProductNotFound;
import com.cg.util.ValidationException;

public class TestCanceledProduct {

	RetailerInventoryService service = new RetailerInventoryServiceImpl();
	RetailerInventoryDao dao = new RetailerInventoryDaoImpl();
	
	@Test
	public void test1() throws ProductNotFound {
		assertEquals(dao.getCancelProductReport(), service.getCancelProductReport());
	}
	
	@Test
	public void test2() {
		assertThrows(ProductNotFound.class, ()-> service.getCancelProductReport());
	}
}
