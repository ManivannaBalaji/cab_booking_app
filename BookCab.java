package com.manivannabalaji.cabbookingapp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.Scanner;

public class BookCab {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		long mobileNumber;
		String password = "pass1234", currentPassword, dobString;
		String source, destination;
		LocalDate dateOfBirth;
		int option = 0, price = 0, gstPrice = 0;
		int journeyHour = 0;
		float distance = 0f;
		boolean peakHours = false, seniorCitizen = false;
		String journeyDate, journeyTime;
		LocalDate travelDate, bookingDate;
		LocalTime travelTime = null, bookingTime;
		
		bookingDate = LocalDate.now();
		bookingTime = LocalTime.now();
		
		System.out.println("=======================================");
		System.out.println("Welcome to Cab Booking\nLogin");
		System.out.println("=======================================");
		System.out.println("Enter your mobile number");
		mobileNumber = scanner.nextLong();
		scanner.nextLine();
		
		System.out.println("Enter your password");
		currentPassword = scanner.nextLine();
		
		if(String.valueOf(mobileNumber).length() < 10 || !password.equals(currentPassword)) {
			System.out.println("Invalid Login please try again!");
			System.exit(0);
		}
		
		System.out.println("Car Booking\n1.Micro (Rs.10/KM)\n2.Mini (Rs.15/KM)\n3.Prime (Rs.20/KM)\nEnter your choice");
		option = scanner.nextInt();
		
		scanner.nextLine();
		System.out.println("Enter your pickup Location");
		source = scanner.nextLine();
		
		System.out.println("Enter your drop location");
		destination = scanner.nextLine();
		
		System.out.println("Enter Journey Distance in kms");
		distance = scanner.nextFloat();
		scanner.nextLine();
		
		System.out.println("Enter Journery Date in YYYY-MM-DD Format");
		journeyDate = scanner.nextLine();
		travelDate = LocalDate.parse(journeyDate);
		if(travelDate.isBefore(bookingDate)){
			System.out.println("Please mention a valid date");
			System.exit(0);
		}else {
			System.out.println("Enter Journey Time in HH:MM Format");
			journeyTime = scanner.nextLine();
			travelTime = LocalTime.parse(journeyTime);
			if(travelDate.isEqual(bookingDate)) {
				if(travelTime.isBefore(bookingTime)) {
					System.out.println("Please mention a valid time");
					System.exit(0);
				}
			}
			journeyHour = travelTime.getHour();
			if(journeyHour >= 17 && journeyHour <= 19) {
				peakHours = true;
			}
			System.out.println("Enter your Date-of-Birth (YYYY-MM-DD)");
			dobString = scanner.nextLine();
			dateOfBirth = LocalDate.parse(dobString);
			Period interval = Period.between(dateOfBirth, bookingDate);
			int intervalYears = interval.getYears();
			if(intervalYears > 60) {
				seniorCitizen = true;
			}else if(intervalYears < 1) {
				System.out.println("Invalid Date-of-Birth, Try Again");
				System.exit(0);
			}
		}
		price = CalculateFare.calculatePrice(option, distance, peakHours, seniorCitizen);
		gstPrice = CalculateFare.calculateGst(price);
		PrintStatement.printRecepit(option, bookingDate, bookingTime, travelDate, travelTime, distance, price, gstPrice, peakHours, seniorCitizen, source, destination);
		PaymentGateway.performPayment();
		scanner.close();
		
	}

}
