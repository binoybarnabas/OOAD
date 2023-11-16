package com.ilp.services;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.Product;
import com.ilp.entity.Service;

public class AccountConfiguration {

	public static Customer createCustomer(ArrayList<Product> productList) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Customer Code");
		String customerCode = scanner.nextLine();
		System.out.println("Enter Customer Name");
		String customerName = scanner.nextLine();
		ArrayList<Account> accountList = new ArrayList<Account>();
		accountList.add(AccountConfiguration.createAccount(productList));
		System.out.println("Account is active....\n");
		return new Customer(customerCode, customerName, accountList);
	}

	public static Account createAccount(ArrayList<Product> productList) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Account no");
		String accountNo = scanner.nextLine();
		System.out.println("Enter Account Balance");
		double accountBalance = scanner.nextDouble();
		System.out.println("select product");
		productConfiguration.displayAllProduct(productList);
		int index = scanner.nextInt();
		Product product = productList.get(index);
		while (product.getProductName().equals("Savings Account") && accountBalance < 1000) {
			System.out.println("Minimum Balance required for Savings account is 1000\n Enter new account balance");
			accountBalance = scanner.nextDouble();
		}
		return new Account(accountNo, accountBalance, product);

	}

	public static void addAccount(ArrayList<Customer> customerList, ArrayList<Product> productList) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your customer  Id");
		String customerCode = scanner.nextLine();
		for (Customer customer : customerList) {
			if (customer.getCustomerCode().equalsIgnoreCase(customerCode)) {
				customer.getAccountList().add(AccountConfiguration.createAccount(productList));
			}
		}
	}


	public static void transactionBill(ArrayList<Customer> customerList) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your customer  Id");
		String customerCode = scanner.nextLine();
		for (Customer customer : customerList) {
			if (customer.getCustomerCode().equalsIgnoreCase(customerCode)) {
				System.out.println(customer.getCustomerName() + "  has the following accounts ");
				AccountConfiguration.displayCustomerAccounts(customer.getAccountList());
				System.out.print("\nEnter account no : ");
				String accountNo = scanner.nextLine();
				for (Account account : customer.getAccountList()) {
					if (account.getAccountNo().equalsIgnoreCase(accountNo)) {
						ArrayList<Service> serviceList = account.getAccountType().getserviceList();
						productConfiguration.displayAllServices(serviceList);
						System.out.println("Enter service Code");
						String serviceCode = scanner.nextLine();
						for (Service service : serviceList) {
							if (service.getServiceCode().equalsIgnoreCase(serviceCode)) {
								System.out.println("enter the no of transactions");
								int noOfTransactions = scanner.nextInt();
								System.out.println("Transaction charges for " + noOfTransactions + " transactions is: "
										+ (noOfTransactions * Double.parseDouble(service.getServiceRate())));
							}
						}

					}
				}

			}
		}
	}

	public static void manageAccounts(ArrayList<Customer> customerList) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter your customer  Id");
			String customerCode = scanner.nextLine();
			for (Customer customer : customerList) {
				if (customer.getCustomerCode().equalsIgnoreCase(customerCode)) {
					System.out.println(customer.getCustomerName() + "  has the following accounts ");
					AccountConfiguration.displayCustomerAccounts(customer.getAccountList());
					System.out.print("\nEnter account no : ");
					String accountNo = scanner.nextLine();
					for (Account account : customer.getAccountList()) {
						if (account.getAccountNo().equalsIgnoreCase(accountNo)) {
							System.out.println("1.Deposit\n2. Withdraw\n3.Display Balance");
							int choice = scanner.nextInt();
							switch (choice) {
							case 1:
								AccountServices.depositMoney(account);
								break;
							case 2:
								AccountServices.withdrawMoney(account);
								break;
							case 3:
								AccountServices.displayBalance(account);
								break;
							default:
								System.out.println("invalid choice");
							}
						}
					}
				}
			}
		
	}

		public static void displayCustomerAccounts(ArrayList<Account> accountList) {
		System.out.println("Account No\tAccount Balance\tAccount Product");
		for (Account account : accountList)
			System.out.println(account.getAccountNo() + "\t\t" + account.getAccountBalance() + "\t\t"
					+ account.getAccountType().getProductName());
	}

	public static void displayAllCustomer(ArrayList<Customer> customerList) {
			System.out.println("list of customers");
			System.out.printf("Customer ID : Customer Name : Account No : Account Balance : Account Type");
			for (Customer customer : customerList) {
				for (Account account : customer.getAccountList()) {
					System.out.printf(customer.getCustomerCode()," : ",
							customer.getCustomerName()," : ",account.getAccountNo()," : ",account.getAccountBalance(),
							" : "account.getAccountType().getProductName());
				}
			}
		}
	}
	


