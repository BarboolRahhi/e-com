package com.cg.ui;

import java.util.Scanner;

import com.cg.dao.RetailerInventoryDao;
import com.cg.dao.RetailerInventoryDaoImpl;
import com.cg.util.Constant;
import com.cg.util.OrderStatus;
import com.cg.util.ProductNotFound;

public class ReportMainUI {

	static Scanner scan = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		String opt = null;
		do {
			dislayMenu();
			System.out.println("Enter Your Choice !");
			showReport(scan.nextInt());
			System.out.println("Press 'y' to Continue !");
			opt = scan.next();
		} while (opt.equals("y"));
		
	}

	public static void dislayMenu() {

		System.out.println("-----------------------------------------------------");
		System.out.println("| PRESS '1' All List Of Retailer and thier Product. |");
		System.out.println("-----------------------------------------------------");
		System.out.println("| PRESS '2' All Product List of Retailer            |");
		System.out.println("-----------------------------------------------------");
		System.out.println("| PRESS '3' All Deliverd Products Report            |");
		System.out.println("-----------------------------------------------------");
		System.out.println("| PRESS '4' Deliverd Products Report of Retailer    |");
		System.out.println("-----------------------------------------------------");
		System.out.println("| PRESS '5' All Dispached Products Report           |");
		System.out.println("-----------------------------------------------------");
		System.out.println("| PRESS '6' All Cancel Products Report              |");
		System.out.println("-----------------------------------------------------");
	}

	public static void showReport(int choice) {
		ReportUI ui = new ReportUIImpl();
		
		switch (choice) {
		case Constant.ONE:
			ui.displayListOfRetailer();
			break;
		case Constant.TWO:
			System.out.println("Enter the Id : ");
			ui.displayProductReportOfRetailer(scan.next());
			break;
		case Constant.THREE:
			ui.displayAllDeliveredProductReport();
			break;
		case Constant.FOUR:
			System.out.println("Enter the Id : ");
			ui.displayDeliveredProductReportOfRetailer(scan.next());
			break;
		case Constant.FIVE:
			ui.displayDispachedProductReport();
			break;
		case Constant.SIX:
			ui.displayCancleProductReport();
			break;
		default:
			System.out.println("Invaild Input");
		}
	}


}
