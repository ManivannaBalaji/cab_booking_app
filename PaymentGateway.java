package com.manivannabalaji.cabbookingapp;

import java.time.LocalDate;
import java.util.Scanner;

public class PaymentGateway {

	/**
	 * Method to perform payment
	 * @return
	 */
	protected static boolean performPayment() {
		Scanner scanner = new Scanner(System.in);
		boolean paymentSuccess = false;
		int option = 0;
		long cardNumber = 0L;
		String tempDate;
		LocalDate expiryDate, currentDate;
		
		currentDate = LocalDate.now();
		System.out.println("Payment method\n1.Cash\n2.Card Payment\nPlease choose an option");
		option = scanner.nextInt();
		switch(option) {
			case 1:
				System.out.println("Payment Accepted");
				break;
			case 2:
				System.out.println("Enter card number");
				cardNumber = scanner.nextLong();
				scanner.nextLine();
				System.out.println("Enter expiry date (YYYY-MM)");
				tempDate = scanner.nextLine();
				tempDate += "-01";
				expiryDate = LocalDate.parse(tempDate);
				if(expiryDate.isBefore(currentDate)) {
					System.out.println("Card Expired, please try with other card!");
					paymentSuccess = false;
					System.exit(0);
				}
				System.out.println("Payment details");
				System.out.println("Card No: " + cardNumber);
				paymentSuccess = true;
				break;
		}
		scanner.close();
		return paymentSuccess;
	}
	
}
