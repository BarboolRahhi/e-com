package com.cg.dao;

import java.util.ArrayList;
import java.util.List;

import com.cg.entity.Order;
import com.cg.entity.Product;
import com.cg.entity.RetailerInventory;
import com.cg.util.CgRepo;
import com.cg.util.Constant;
import com.cg.util.IdNotFound;
import com.cg.util.OrderStatus;
import com.cg.util.ProductNotFound;
import com.google.common.base.Optional;

public class RetailerInventoryDaoImpl implements RetailerInventoryDao {

	private List<RetailerInventory> retailerList = CgRepo.getRetailerList();
	private List<Order> orderList = CgRepo.getOrderList();

	@Override
	public List<RetailerInventory> getListOfRetailer() {
		return retailerList;
	}

	@Override
	public List<Product> getProductReportOfRetailer(int id) throws IdNotFound, ProductNotFound {

		List<Product> list = new ArrayList<>();

		// Raised Exception 'ID Not Found' if no retailer id is found
		checkIdExist(id);

		retailerList.stream().filter(r -> r.getRetailerId() == id).flatMap(r -> r.getProducts().stream())
				.forEach(list::add);

		if (list.isEmpty())
			throw new ProductNotFound(Constant.NO_PRODUCT_FOR_RETAILER + id);

		return list;
	}

	@Override
	public List<Order> getProductReportByOrderStatus(OrderStatus status) throws ProductNotFound {

		List<Order> list = new ArrayList<>();

		orderList.stream().filter(o -> o.getStatus().equals(status)).forEach(list::add);

		// Raised Exception 'ProductNotFount' if no order is delivered
		
 		checkOrderFound(list, Optional.of(status), Optional.absent());

		return list;
	}

	@Override
	public List<Order> getDeliveredProductReportOfRetailer(int id) throws IdNotFound, ProductNotFound {

		List<Order> list = new ArrayList<>();

		// Raised Exception 'ID Not Found' if no retailer id is found
		checkIdExist(id);

		orderList.stream().filter(o -> o.getStatus().equals(OrderStatus.DILIVERED))
				.filter(o -> o.getProduct().getRetailerId() == id).forEach(list::add);

		// Raised Exception 'ProductNotFount' if no order is delivered for particular
		// retailer or retailer id
		checkOrderFound(list, Optional.absent(), Optional.of(Constant.NO_DELIVERED_PRODUCT_FOR_RETAILER + id));

		return list;
	}



	private void checkIdExist(int id) throws IdNotFound {
		boolean idCheck = retailerList.stream().anyMatch(r -> r.getRetailerId() == id);
		

		if (!idCheck)
			throw new IdNotFound(Constant.NO_ID_FOUND);
	}

	private void checkOrderFound(
			List<Order> order, 
			Optional<OrderStatus> status,
			Optional<String> msg
			) throws ProductNotFound 
	{
		if (order.isEmpty()) {
			switch (status.get()) {
			case CANCLE:
				throw new ProductNotFound(Constant.NO_CANCEL_PRODUCT);
			case DILIVERED:
				throw new ProductNotFound(Constant.NO_DELIVERED_PRODUCT);
			case DISPACHED:
				throw new ProductNotFound(Constant.NO_DISPATCHED_PRODUCT);
			default:
				throw new ProductNotFound(msg.get());
			}
		}

	}

}
