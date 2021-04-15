package com.manivannabalaji.cabbookingapp;

public class CalculateFare {
	/**
	 * 
	 * @param option
	 * @param distance
	 * @return the traveling charges based on car type, distance, peak hours and senior citizen concessions.
	 */
	public static int calculatePrice(int option, float distance, boolean peakHours, boolean seniorCitizen) {
		int microPrice = 10, miniPrice = 15, primePrice = 20;
		double price = 0;
		switch(option) {
			case 1:
				price = microPrice * (int) distance;
				break;
			case 2:
				price = miniPrice * (int) distance;
				break;
			case 3:
				price = primePrice * (int) distance;
				break;
		}
		if(peakHours) {
			price += (0.0125 * price);
			price = Math.ceil(price);
		}
		if(seniorCitizen) {
			price /= 2;
		}
		return (int)price;
	}
	
	
	/**
	 * 
	 * @param price
	 * @return the GST tax amount for the journey fare.
	 */
	public static int calculateGst(int price) {
		double gstPrice = 0.07 * price;
		gstPrice = Math.ceil(gstPrice);
		return (int)gstPrice;
	}
}
