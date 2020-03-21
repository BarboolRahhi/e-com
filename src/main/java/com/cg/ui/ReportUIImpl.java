package com.cg.ui;

import java.util.List;

import com.cg.entity.Order;
import com.cg.entity.Product;
import com.cg.entity.RetailerInventory;
import com.cg.service.RetailerInventoryService;
import com.cg.service.RetailerInventoryServiceImpl;
import com.cg.util.IdNotFound;
import com.cg.util.ProductNotFound;
import com.cg.util.ValidationException;

import sun.print.resources.serviceui;

public class ReportUIImpl implements ReportUI {

	RetailerInventoryService service = new RetailerInventoryServiceImpl();

	@Override
	public void displayListOfRetailer() {
		displayRetailer(service.getListOfRetailer());
	}

	@Override
	public void displayProductReportOfRetailer(String id) {
		try {
			
			displayProducts(service.getProductReportOfRetailer(id));
		} catch ( ValidationException | IdNotFound | ProductNotFound  e) {
			System.out.println(e.getMessage());
		} 
	}

	@Override
	public void displayAllDeliveredProductReport() {
		try {
			displayOrder(service.getDeliveredProductReport());
		} catch (ProductNotFound e) {
			System.out.println(e.getMessage());
		} 
	}

	@Override
	public void displayDeliveredProductReportOfRetailer(String id) {
		try {
			displayOrder(service.getDeliveredProductReportOfRetailer(id));
		} catch ( ValidationException | IdNotFound | ProductNotFound e) {
			System.out.println(e.getMessage());
		} 
	}

	@Override
	public void displayDispachedProductReport() {
		try {
			displayOrder(service.getDispachedProductReport());
		} catch (ProductNotFound e) {
			System.out.println(e.getMessage());
		} 
	}

	@Override
	public void displayCancleProductReport() {
		try {
			displayOrder(service.getCancelProductReport());
		} catch (ProductNotFound e) {
			System.out.println(e.getMessage());
		} 
	}

	
	private void displayRetailer(List<RetailerInventory> list) {
		list.forEach(retailer -> {
			System.out.println("...................................................................................................");
			System.out.printf("| %s%20s%25s                                        |\n", "Retailer ID", "Retailer Name", "Date");
			System.out.println("...................................................................................................");
			System.out.printf("%12d%20s%28s\n", 
					retailer.getRetailerId(),
					retailer.getRetailerName(),
					retailer.getSaleDateTime()
					);
			System.out.println("\nProducts of Retailer : " + retailer.getRetailerName());
			displayProducts(retailer.getProducts());
			System.out.println("\n\n");
		});
	}
	
	private void displayOrder(List<Order> list) {
		list.forEach(order -> {
			System.out.println("...................................................................................................");
			System.out.printf("| %s%20s%25s                                           |\n", "Order ID", "Order Status", "Order Date");
			System.out.println("...................................................................................................");
			System.out.printf("%10d%20s%25s\n", 
					order.getOrderId(),
					order.getStatus(),
					order.getOrderDate()
					);
			System.out.println("\n---------------------------------------------------------------------------------------------------");
			System.out.printf("| %s%20s%25s%20s%20s |\n", "Product ID", "Product Name", "Product Info", "Retailer ID" , "Product Salary");
			System.out.println("---------------------------------------------------------------------------------------------------");
			displayProduct(order.getProduct());
			System.out.println("\n\n");
		});
	}
	
	private void displayProducts(List<Product> list) {
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.printf("| %s%20s%25s%20s%20s |\n", "Product ID", "Product Name", "Product Info", "Retailer ID" , "Product Salary");
		System.out.println("---------------------------------------------------------------------------------------------------");
		list.forEach(pro -> {
			displayProduct(pro);
		});
		if (list.isEmpty()) {
			System.out.println("Retailer have no product yet!");
		}
	}
	
	private void displayProduct(Product pro) {
		System.out.printf("%5d%25s%30s%15d%15.2f\n", 
				pro.getProductId(),
				pro.getProductName(),
				pro.getProductInfo(),
				pro.getRetailerId(),
				pro.getPrice());
		
	}

}
