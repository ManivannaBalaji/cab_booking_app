package com.manivannabalaji.cabbookingapp;

import java.time.LocalDate;
import java.time.Period;

public class TimeValidator {
	
	/**
	 * This method validates whether the passed hour is between 17 and 19 (peak hours)
	 * @param hour
	 * @return boolean
	 */
	public static boolean peakHour(int hour) {
		if(hour >= 17 && hour <= 19) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Method to find the years between two dates.
	 * @param dateOfBirth
	 * @param bookingDate
	 * @return intervalYears
	 */
	public static int getInterval(LocalDate dateOfBirth, LocalDate bookingDate) {
		Period interval = Period.between(dateOfBirth, bookingDate);
		int intervalYears = interval.getYears();
		return intervalYears;
	}
}
