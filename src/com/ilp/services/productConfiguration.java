package com.ilp.services;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.CurrentAccount;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.Product;
import com.ilp.entity.SavingsAccount;
import com.ilp.entity.Service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class productConfiguration {

	private static final boolean Matcher = false;

	public static Service createService() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter Service code");
		String serviceCode = scanner.nextLine();
		System.out.println("enter Service name");
		String serviceName = scanner.nextLine();
		System.out.println("enter Service rate");
		String serviceRate = scanner.nextLine();
		return new Service(serviceRate, serviceCode, serviceName);
	}

	public static void displayAllServices(ArrayList<Service> serviceList) {
		System.out.printf("%-6s%-15s%-20s%-15s%n", "Index", "Service Code", "Service Name", "Service Rate");
		for (Service service : serviceList) {
			System.out.printf("%-6d%-15s%-20s%-15s%n", serviceList.indexOf(service), service.getServiceCode(),
					service.getServiceName(), service.getServiceRate());

		}
	}

	public static Product createProduct(ArrayList<Service> serviceList) {
		if (serviceList.isEmpty()) {
			System.out.println("-----------------service not defined----------------");
			return null;
		}
		Scanner scanner = new Scanner(System.in);
		char goToMenu;
		System.out.println("Enter product code");
		String productCode = scanner.nextLine();
		System.out.println("Enter product Name");
		String productName = scanner.nextLine();
		ArrayList<Service> selectedServices = new ArrayList<Service>();

		System.out.println("----------------Select Services to add----------------");
		do {
			displayAllServices(serviceList);
			int index = scanner.nextInt();
			scanner.nextLine(); // Consume the newline character
			selectedServices.add(serviceList.get(index));
			System.out.println("Do you want to add another service y/n");
			goToMenu = scanner.next().charAt(0);
		} while (goToMenu == 'y');

		Pattern savingsAccount = Pattern.compile("Savings account|SavingsMaxAccount|SavingsAccount|Savings Max Account",
				Pattern.CASE_INSENSITIVE);
		Pattern currentAccount = Pattern.compile("Current account|CurrentAccount", Pattern.CASE_INSENSITIVE);
		Pattern loanAccount = Pattern.compile("Loan account|LoanAccount", Pattern.CASE_INSENSITIVE);

		if (savingsAccount.matcher(productName).find()) {
			System.out.println("Savings Account");
			return new SavingsAccount(productCode, "Savings Account", selectedServices);
		} else if (currentAccount.matcher(productName).find()) {
			System.out.println("current Account");
			return new CurrentAccount(productCode, "Current Account", selectedServices);
		} else if (loanAccount.matcher(productName).find()) {
			System.out.println("loan Account ");
			return new LoanAccount(productCode, "Loan Account", selectedServices);
		} else {
			System.out.println("Invalid input !");
			return null;
		}

	}

	public static void displayAllProduct(ArrayList<Product> productList) {
		System.out.printf("%-6s%-20s%n", "Index", "Product Name");
		for (Product product : productList) {

			System.out.printf("%-6d%-20s%n", productList.indexOf(product), product.getProductName());

		}
	}

}
