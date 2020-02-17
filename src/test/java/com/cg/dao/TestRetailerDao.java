package com.cg.dao;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.cg.entity.Order;
import com.cg.entity.Product;
import com.cg.util.CgRepo;
import com.cg.util.IdNotFound;
import com.cg.util.OrderStatus;
import com.cg.util.ProductNotFound;



public class TestRetailerDao {

	RetailerInventoryDaoImpl dao = new RetailerInventoryDaoImpl();
	
	@Test
	public void testSeries1() {
		
		assertEquals(CgRepo.rlist, dao.getListOfRetailer());
	}
	
	@Test
	public void testSeries2() throws IdNotFound, ProductNotFound {
		
		List<Product> excepted = CgRepo.allProductlist.stream().filter(p -> p.getRetailerId() == 1)
				.collect(Collectors.toList());
		
 		assertEquals(excepted, dao.getProductReportOfRetailer(1));
	}

	@Test
	public void testSeries3() throws IdNotFound, ProductNotFound {
		assertThrows(IdNotFound.class,() -> dao.getProductReportOfRetailer(4));
	}
	
	@Test
	public void testSeries4() throws IdNotFound, ProductNotFound {
		assertThrows(ProductNotFound.class, () -> dao.getProductReportOfRetailer(3));
	}
	
	@Test
	public void testSeries5() throws ProductNotFound {
		List<Order> excepted = CgRepo.olist.stream().filter(p -> p.getStatus() == OrderStatus.DILIVERED)
				.collect(Collectors.toList());
		assertEquals(excepted, dao.getAllDeliveredProductReport());
	}
	
//	@Test
//	public void testSeries6() throws IdNotFound, ProductNotFound {
//		assertThrows(ProductNotFound.class, () -> dao.getAllDeliveredProductReport());
//	}
	
	
}












