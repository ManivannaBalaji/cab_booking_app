package com.manivannabalaji.cabbookingapp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class PrintStatement {
	
	/**
	 * 
	 * @param option
	 * @param bookingDate
	 * @param bookingTime
	 * @param journeyDate
	 * @param journeyTime
	 * @param distance
	 * @param price
	 * @param peakHours
	 * @param seniorCitizen
	 * @apiNote Prints the total journey fare including taxes.
	 */
	public static void printRecepit(int option, LocalDate bookingDate, 
										LocalTime bookingTime, LocalDate journeyDate, 
										LocalTime journeyTime, float distance, 
										int price, int gstPrice, 
										boolean peakHours, boolean seniorCitizen,
										String source, String destination) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.US);
		String formattedTime = formatter.format(bookingTime);
		
		System.out.println("=======================================");
		System.out.println("Price Details");
		if(option == 1) {
			System.out.println("Car Type : Micro");
		} else if(option == 2) {
			System.out.println("Car Type : Mini");
		} else if(option == 3) {
			System.out.println("Car Type : Prime");
		}
		System.out.println("Pickup location : " + source);
		System.out.println("Drop location : " + destination);
		System.out.println("Booking Date : " + bookingDate);
		System.out.println("Booking Time : " + formattedTime);
		System.out.println("Journey Date : " + journeyDate);
		System.out.println("Journey Time : " + journeyTime);
		System.out.println("Distance : " + distance);
		if(peakHours) {
			System.out.println("Peak Hours : Yes (Extra 1.25% charges apply)");
		}else {
			System.out.println("Peak Hours : No");
		}
		if(seniorCitizen) {
			System.out.println("Senior Citizen : Yes");
		}else {
			System.out.println("Senior Citizen : No");
		}
		System.out.println("Price : Rs." + price);
		System.out.println("GST : Rs." + gstPrice);
		System.out.println("Total Amount : Rs." + (price + gstPrice));
		System.out.println("**Happy Journey**");
		System.out.println("=======================================");
		
	}
}
