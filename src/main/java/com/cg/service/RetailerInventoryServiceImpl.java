package com.cg.service;

import java.util.List;

import com.cg.dao.RetailerInventoryDao;
import com.cg.dao.RetailerInventoryDaoImpl;
import com.cg.entity.Order;
import com.cg.entity.Product;
import com.cg.entity.RetailerInventory;
import com.cg.util.Constant;
import com.cg.util.IdNotFound;
import com.cg.util.OrderStatus;
import com.cg.util.ProductNotFound;
import com.cg.util.ValidationException;

public class RetailerInventoryServiceImpl implements RetailerInventoryService {
	
	RetailerInventoryDao dao = new RetailerInventoryDaoImpl();
	
	public void setDao(RetailerInventoryDao dao) {
		this.dao = dao;
	}

	@Override
	public List<RetailerInventory> getListOfRetailer() {
		return dao.getListOfRetailer();
	}

	@Override
	public List<Product> getProductReportOfRetailer(String id) throws IdNotFound, ProductNotFound, ValidationException {
		checkIdValidation(id);
		int newID = Integer.parseInt(id);
		return dao.getProductReportOfRetailer(newID);
	}

	@Override
	public List<Order> getDeliveredProductReport() throws ProductNotFound {
		return dao.getProductReportByOrderStatus(OrderStatus.DILIVERED);
	}

	@Override
	public List<Order> getDeliveredProductReportOfRetailer(String id) throws IdNotFound, ProductNotFound, ValidationException {
		checkIdValidation(id);
		int newID = Integer.parseInt(id);
		return dao.getDeliveredProductReportOfRetailer(newID);
	}

	@Override
	public List<Order> getDispachedProductReport() throws ProductNotFound {
		return dao.getProductReportByOrderStatus(OrderStatus.DISPACHED);
	}

	@Override
	public List<Order> getCancelProductReport() throws ProductNotFound {
		return dao.getProductReportByOrderStatus(OrderStatus.CANCLE);
	}
	
	private void checkIdValidation(String id) throws ValidationException {
		if (!id.matches("\\d+") || id.isEmpty()) 
			throw new ValidationException(Constant.ID_VALIDATION);
		
	}
	
	
}
