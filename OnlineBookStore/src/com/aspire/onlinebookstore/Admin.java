package com.aspire.onlinebookstore;

import java.util.Scanner;

public class Admin {
	private String adminUsername = "Admin@123";
	private String adminPassword = "12345";
	public String username, password;
	Scanner scanner = new Scanner(System.in);

	public void goToDashboard() {
		System.out.println("Hai Admin...!Welcome to the Portal...");
		System.out.println("Enter Username:");
		username = scanner.nextLine();
		System.out.println("Enter Password:");
		password = scanner.nextLine();
		if (((adminUsername.equals(username)) && (adminPassword.equals(password))) == true) {
			manageOptions();
		}
	}

	public void manageOptions() {
		AdminAuthorities authorities = new AdminAuthorities();
		System.out.println("Welcome Admin...To continue \n1.ManageBooks \n2.ManageOrders \n3.ManageUser");
		int choice;
		choice = scanner.nextInt();
		switch (choice) {
		case 1:
			authorities.goToManageBooks();
			break;
		case 2:
			authorities.goToManageOrders();
			break;
		case 3:
			authorities.goToManageUser();
			break;
		}
	}
}
