package com.manivannabalaji.cabbookingapp;

public class CalculateFare {
	/**
	 * 
	 * @param option
	 * @param distance
	 * @return the traveling charges based on car type, distance, peak hours and senior citizen concessions.
	 */
	public static int calculatePrice(int option, int[] prices, float distance, boolean peakHours, boolean seniorCitizen) {
		double price = 0;
		switch(option) {
			case 1:
				price = prices[0] * (int) distance;
				break;
			case 2:
				price = prices[1] * (int) distance;
				break;
			case 3:
				price = prices[2] * (int) distance;
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
	 * This method validates the GST tax for cab fare.
	 * @param percentage
	 * @param price
	 * @return GST tax for the journey.
	 */
	public static int calculateGst(int percentage, int price) {
		double gstPrice = (percentage/(double)100) * price;
		gstPrice = Math.ceil(gstPrice);
		return (int)gstPrice;
	}
}
