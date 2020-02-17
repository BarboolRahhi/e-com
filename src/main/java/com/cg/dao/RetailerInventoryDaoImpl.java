package com.cg.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.cg.entity.Order;
import com.cg.entity.Product;
import com.cg.entity.RetailerInventory;
import com.cg.util.CgRepo;
import com.cg.util.IdNotFound;
import com.cg.util.OrderStatus;
import com.cg.util.ProductNotFound;

public class RetailerInventoryDaoImpl implements RetailerInventoryDao{

	private List<RetailerInventory> retailerList = CgRepo.rlist;
	private List<Order> orderList = CgRepo.olist;

	@Override
	public List<RetailerInventory> getListOfRetailer() {
		return retailerList;
	}

	@Override
	public List<Product> getProductReportOfRetailer(int id) throws IdNotFound, ProductNotFound {

		List<Product> list = new ArrayList<>();
		
		// Raised Exception 'ID Not Found' if no retailer id is found
		checkIdExist(id);
	
		retailerList.stream().filter(r -> r.getRetailerId() == id)
					.flatMap(r -> r.getProducts().stream())
					.forEach(list::add);

		if (list.isEmpty()) 
			throw new ProductNotFound("No Product Found For Retailer : " + id);

		return list;
	} 

	@Override
	public List<Order> getAllDeliveredProductReport() throws ProductNotFound {
		
		List<Order> list = new ArrayList<>();

		orderList.stream().filter(o -> o.getStatus().equals(OrderStatus.DILIVERED))
						  .forEach(list::add);

		// Raised Exception 'ProductNotFount' if no order is delivered 
		checkOrderFound(list, "No Delivered Product Found!"); 

		return list;
	}

	@Override
	public List<Order> getDeliveredProductReportOfRetailer(int id) throws IdNotFound, ProductNotFound {

		List<Order> list = new ArrayList<>();
		
		// Raised Exception 'ID Not Found' if no retailer id is found
		checkIdExist(id);

		orderList.stream().filter(o -> o.getStatus().equals(OrderStatus.DILIVERED))
						  .filter(o -> o.getProduct().getRetailerId() == id)
						  .forEach(list::add);

		// Raised Exception 'ProductNotFount' if no order is delivered for particular retailer or retailer id
		checkOrderFound(list, "No Delivered Oder Found For Retailer ID : " + id);

		return list;
	}

	@Override
	public List<Order> getDispatchedProductReport() throws ProductNotFound {
		List<Order> list = new ArrayList<>();

		orderList.stream().filter(o -> o.getStatus().equals(OrderStatus.DISPACHED))
		                  .forEach(list::add);

		// Raised Exception 'ProductNotFount' if no order is dispatched 
		checkOrderFound(list, "No Dispatched Product Found");
		
		return list;
	}

	@Override
	public List<Order> getCancelProductReport() throws ProductNotFound {

		List<Order> list = new ArrayList<>();

		orderList.stream().filter(o -> o.getStatus().equals(OrderStatus.CANCLE))
						  .forEach(list::add);

		// Raised Exception 'ProductNotFount' if no order is Canceled
		checkOrderFound(list, "No Cancel Product Found");

		return list;
	}

	private void checkIdExist(int id) throws IdNotFound {
		boolean idCheck = retailerList.stream().anyMatch(r -> r.getRetailerId() == id);
		
		if (!idCheck) 
			throw new IdNotFound("ID Does not Exixts");
	}
	
	private void checkOrderFound(List<Order> order, String msg) throws ProductNotFound {
		if (order.isEmpty()) 
			throw new ProductNotFound(msg);
	}


}
