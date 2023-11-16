package com.ilp.utility;

import com.ilp.entity.*;
import com.ilp.services.*;
import java.util.*;

public class BankUtility {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		char goToMainMenu;
		Product product = null;
		Customer newCustomer = null;
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		ArrayList<Service> serviceList = new ArrayList<Service>();
		ArrayList<Product> productList = new ArrayList<Product>();

		do {
			int choice = scanner.nextInt();
			System.out.println("****Welcome To Bank****\n1.create service\n2.create product\n3.Create Accounts\n4.Add Account\n5.Display Accounts\n6.Transaction Bill\n7.Manage Accounts");
			switch (choice) {
			case 1: 
				serviceList.add(productConfiguration.createService());
				break;
			case 2:
				product = productConfiguration.createProduct(serviceList);
				productList.add(product);
				break;
			case 3:
				customer = AccountConfiguration.createCustomer(productList);
				customerList.add(customer);
				break;
			case 4:
				AccountConfiguration.addAccount(customerList, productList);
				break;
			case 5:
				AccountConfiguration.displayAllCustomer(customerList);
				break;
			case 6: 
				AccountConfiguration.transactionBill(customerList);
				break;
			case 7:
				AccountConfiguration.manageAccounts(customerList);
				break;
			default:
				System.out.println("invalid choice"); break;
			}
			System.out.println("go to Main menu y/n");
			goToMainMenu = scanner.next().charAt(0);
		} while (goToMainMenu == 'y');
	}

}
