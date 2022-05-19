/* Title : Online Book Store
 * Author: Monika Mani
 * Created at:April 26,2022
 * Updated at:May 12,2022
 * Reviewed by:Shilpa Madhusoodhanan
 * Reviewed Date:May 5,2022
 */
package com.aspire.onlinebookstore;

import java.util.Scanner;

public class Onlinebookstoremain {
	 
	 public static void main(String[] args) {
		Registration registration=Registration.getInstance();
		Scanner scanner=new Scanner(System.in);
		System.out.println("Welcome to the portal \n1.Register\n2.Login\n3.Admin");
		registration.portal();
		registration.updateRegistration();
		Admin admin=new Admin();
		admin.goToDashboard();
}
}
