package com.aspire.onlinebookstore;

import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login {

	public String username, password;
	static final String URL = "jdbc:mysql://localhost:3306/Onlinebookstore";
	static final String USER = "root";
	static final String PASS = "Aspire@123";
	static Scanner scanner = new Scanner(System.in);
	public static Login login = null;

	public static Login getInstance() {
		if (Objects.isNull(login)) {
			login = new Login();
		}
		return login;
	}

	public void goToUsername() {
		System.out.println("Enter username:");
		System.out.println("It should contain 1 Uppercase and followed by lowercase");
		String username = scanner.next();
		String regex = "^*[A-Z]{1}[A-Z a-z]\\w{4,20}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(username);
		if (matcher.matches() == false) {
			System.out.println("invalid username");

			goToUsername();
		} else {
			System.out.println("Valid Username");

		}
	}

	public void goToPassword() {
		System.out.println("Enter password:");
		System.out.println("Password must be strong and contain atleast 8 characters");
		String password = scanner.next();
		Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$");
		Matcher matcher = pattern.matcher(password);

		if (matcher.matches() == false) {
			System.out.println("Invalid password");
			goToPassword();

		} else {
			System.out.println("Valid Password");

		}
	}
}
