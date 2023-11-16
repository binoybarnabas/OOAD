package com.ilp.services;

import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.Product;
import com.ilp.entity.SavingsAccount;

public class AccountServices {

	public static void displayBalance(Acc, ount account) {
		System.out.println("Balance : " + account.getAccountBalance());

	}
	public static void withdrawMoney(Account account) {
		Product product = account.getAccountType();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the amount to  withdraw");
		double withdrawalAmount = scanner.nextDouble();
		Double remainingBalance = account.getAccountBalance() - withdrawalAmount;

		if (product instanceof SavingsAccount) {
			product = (SavingsAccount) product;
			if (remainingBalance >= 1000) {
				account.setAccountBalance(remainingBalance);
			} else {
				System.out.println("Cannot withdraw money");
			}

		} 
		else {
			if (remainingBalance >= 0) {
				account.setAccountBalance(remainingBalance);
			} 
			else {
				System.out.println("Cannot withdraw money");
			}
		}

	}
	public static void depositMoney(Account account) {
		Product product = account.getAccountType();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the amount to deposit");
		double depositAmount = scanner.nextDouble();
		System.out.println("do you prefer cheque deposit (y/n)");
		char checkDeposit = scanner.next().charAt(0);
		if (Character.toLowerCase(checkDeposit) == 'y' && product instanceof LoanAccount) {
			account.setAccountBalance(account.getAccountBalance() + (0.97 * depositAmount));
		} else
			account.setAccountBalance(account.getAccountBalance() + depositAmount);
	}

}
