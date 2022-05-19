package com.aspire.onlinebookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Registration {

	static final String URL = "jdbc:mysql://localhost:3306/record";
	static final String USER = "root";
	static final String PASS = "Aspire@123";
	public static Registration registration = null;

	public static Registration getInstance() {
		if (Objects.isNull(registration)) {
			registration = new Registration();
		}
		return registration;
	}

	public String username, password, phonenumber, emailid;
	Scanner scanner = new Scanner(System.in);
	Login login = Login.getInstance();

	public void portal() {
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			goToUsername();
			goToPassword();
			goToPhonenumber();
			goToEmailid();
			break;
		case 2:
			login.goToUsername();
			login.goToPassword();
			break;
		}
	}

	public void goToUsername() {
		System.out.println("Enter username:");
		System.out.println("It should contain 1 Uppercase and followed by lowercase");
		username = scanner.next();
		if (!Pattern.matches("^*[A-Z]{1}[A-Z a-z]\\w{5,20}$", username)) {
			System.out.println("Please Enter Valid Username");
			goToUsername();
		}
	}

	public void goToPassword() {
		System.out.println("Enter password:");
		System.out.println("Password must be strong and valid");
		password = scanner.next();
		if (!Pattern.matches("^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$", password)) {
			System.out.println("Please Enter Valid Password");
			goToPassword();
		}
	}

	public void goToPhonenumber() {
		System.out.println("Enter phonenumber:");
		System.out.println("Phoneno should contain 10 numbers");
		phonenumber = scanner.next();
		if (!Pattern.matches("^[6-9][0-9]{9}$", phonenumber)) {
			System.out.println("Please Enter Valid Phonenumber");
			goToPhonenumber();
		}
	}

	public void goToEmailid() {
		System.out.println("Enter emailid:");
		System.out.println("Emailid should be valid");
		emailid = scanner.next();
		if (!Pattern.matches("^[a-zA-Z0-9_!#$%&'*+/=?'{|}~^.-]+@[a-zA-Z0-9.-]+$", emailid)) {
			System.out.println("Please Enter Valid Emailid");
			goToEmailid();
		}
	}

	public void updateRegistration() {
		String query = "Insert into registrationDetails values(?,?,?,?)";
		try {
			Connection connection = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement pre = connection.prepareStatement(query);
			pre.setString(1, username);
			pre.setString(2, password);
			pre.setString(3, phonenumber);
			pre.setString(4, emailid);
			pre.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
