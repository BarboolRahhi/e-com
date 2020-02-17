package com.cg.service;

import java.util.List;

import com.cg.dao.RetailerInventoryDao;
import com.cg.dao.RetailerInventoryDaoImpl;
import com.cg.entity.Order;
import com.cg.entity.Product;
import com.cg.entity.RetailerInventory;
import com.cg.util.IdNotFound;
import com.cg.util.ProductNotFound;
import com.cg.util.ValidationException;

public class RetailerInventoryServiceImpl implements RetailerInventoryService {
	
	RetailerInventoryDao dao = new RetailerInventoryDaoImpl();

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
	public List<Order> getAllDeliveredProductReport() throws ProductNotFound {
		return dao.getAllDeliveredProductReport();
	}

	@Override
	public List<Order> getDeliveredProductReportOfRetailer(String id) throws IdNotFound, ProductNotFound, ValidationException {
		checkIdValidation(id);
		int newID = Integer.parseInt(id);
		return dao.getDeliveredProductReportOfRetailer(newID);
	}

	@Override
	public List<Order> getDispachedProductReport() throws ProductNotFound {
		return dao.getDispatchedProductReport();
	}

	@Override
	public List<Order> getCancelProductReport() throws ProductNotFound {
		return dao.getCancelProductReport();
	}
	
	private void checkIdValidation(String id) throws ValidationException {
		if (!id.matches("\\d+") || id.isEmpty()) 
			throw new ValidationException("ID Must be an Integer Value");
		
	}
	
	
}
