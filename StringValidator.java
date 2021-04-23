package com.manivannabalaji.cabbookingapp;

public class StringValidator {
	/**
	 * This method validates the mobile number to check it has atleast 10 digits and greater than zero.
	 * @param mobileNumber
	 * @return boolean
	 */
	public static boolean validateMobile(long mobileNumber) {
		String mobileString = String.valueOf(mobileNumber);
		if(mobileString.length() > 9 && mobileNumber > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	
	/**
	 * This method validates whether the password has 8 characters length.
	 * @param password
	 * @return boolean
	 */
	public static boolean validatePassword(String password) {
		if(password.length() > 7) {
			return true;
		}else {
			return false;
		}
	}
	
}
