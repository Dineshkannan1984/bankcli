
package com.xxxbank.evaluation.cli.common;

import com.xxxbank.evaluation.cli.controller.BankController;

/**
 * @author DINESHKANNAN_R
 *
 */
public class Message {
	
	public static <T> String  getGreetingInfo(T arg1) {
		return "Hello, "+ arg1+"!";
	}
 
	public static <T> String  printTransfer(T arg0, T arg1, T arg2) {
		return "Transferred "+ arg1+" to "+ arg2;
	}

	public static <T> String  owingToStatement(T arg1, T arg2) {
		return"Owing "+ arg1 +" to "+ arg2;
	}
	public static <T> String  owingFromStatement(T arg1, T arg2) {
		return "Owing "+ arg1 +" from "+ arg2;
	}
	public static <T> String  printBalance(T arg1) {
		return "Your balance is "+ arg1 ;
	}

}
