/*
 * =============================================================================
 * For internal use of XXX Bank only.(C) 2022  XXX BANK.All Rights Reserved.
 * Information in this file is the intellectual property of XXX BANK
 * =============================================================================
 */
package com.xxxbank.evaluation.cli.common;

/**
 *  Utils class to define all validation and manipulation tasks
 * 
 * @author DINESHKANNAN_R
 * @version 1.0
 * @since 04Feb2022
 */
import java.util.List;

public class Utils {

	/**
	 * Method to check whether the string is empty or null
	 * 
	 * @param val
	 *            :Input String
	 * @return Boolean : Validation result
	 * 
	 *
	 */
	public static boolean isEmpty(String val) {
		return (null == val || val.trim().isEmpty());
	}

	/**
	 * Method to check whether the List is empty or null
	 * 
	 * @param val
	 *            :Input List
	 * @return Boolean : Validation result
	 * 
	 *
	 */

	public static <T> boolean isEmpty(List<T> val) {
		return (null == val || val.isEmpty());
	}

	/**
	 * Method to clean Input String
	 * 
	 * @param val
	 *            :Input String
	 * @return String : Trimmed String
	 * 
	 *
	 */
	public static String cleanString(String val) {
		if (isEmpty(val)) {
			return null;
		}
		return val.trim();
	}
}
