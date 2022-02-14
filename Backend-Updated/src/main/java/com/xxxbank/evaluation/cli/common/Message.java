/*
 * =============================================================================
 * For internal use of XXX Bank only.(C) 2022  XXX BANK.All Rights Reserved.
 * Information in this file is the intellectual property of XXX BANK
 * =============================================================================
 */
package com.xxxbank.evaluation.cli.common;

import java.math.BigDecimal;

/**
 * Class to define dynamic message based on user action
 * 
 * @author DINESHKANNAN_R
 * @version 1.0
 * @since 04Feb2022
 */
public class Message {

	/**
	 * Method used to get message of Greeting Details
	 * 
	 * @param userId
	 *            :Input param user Login
	 * @return String : Greeting Message
	 * 
	 *
	 */
	public static String getGreetingInfo(String userId) {
		return "Hello, " + userId + "!";
	}

	/**
	 * Method used to get transfer message information
	 * 
	 * @param transferAmount
	 *            :Amount to transfer
	 * @param transferTo
	 *            :transfer to account
	 * @return String : Transfer Message
	 * 
	 *
	 */

	public static <T> String printTransfer(BigDecimal transferAmount, String transferTo) {
		return "Transferred " + transferAmount + " to " + transferTo;
	}

	/**
	 * Method used to get Owing to message information
	 * 
	 * @param debtAmount
	 *            :Debt amount
	 * @param oweToAccountName
	 *            :Owe to account info details
	 * @return String : Owing to Message
	 * 
	 *
	 */

	public static <T> String owingToStatement(BigDecimal debtAmount, String oweToAccountName) {
		return "Owing " + debtAmount + " to " + oweToAccountName;
	}

	/**
	 * Method used to get Owing From message information
	 * 
	 * @param debtAmount
	 *            :Debt amount
	 * @param accountName
	 *            :Owe From account info details
	 * @return String : Owing From Message
	 * 
	 *
	 */
	public static <T> String owingFromStatement(BigDecimal debtAmount, String accountName) {
		return "Owing " + debtAmount + " from " + accountName;
	}

	/**
	 * Method used to get Balance Account Message Details
	 * 
	 * @param account
	 *            :Input param is Account details
	 * @return String : Balance Message
	 * 
	 *
	 */
	public static <T> String printBalance(BigDecimal accoutBalance) {
		return "Your balance is " + accoutBalance;
	}

}
