package com.cg.ui;

import java.util.List;

import com.cg.entity.Product;
import com.cg.entity.RetailerInventory;
import com.cg.service.RetailerInventoryService;
import com.cg.service.RetailerInventoryServiceImpl;
import com.cg.util.IdNotFound;
import com.cg.util.ProductNotFound;

public interface ReportUI {
	
	void displayListOfRetailer();
	void displayProductReportOfRetailer(String id);
	void displayAllDeliveredProductReport();
	void displayDeliveredProductReportOfRetailer(String id);
	void displayDispachedProductReport();
	void displayCancleProductReport();

}
