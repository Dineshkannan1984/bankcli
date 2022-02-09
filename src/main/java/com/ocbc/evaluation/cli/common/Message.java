
package com.ocbc.evaluation.cli.common;

import com.ocbc.evaluation.cli.CommandLine;

/**
 * @author DINESHKANNAN_R
 *
 */
public class Message {
	
	public static <T> void getGreetingInfo(T arg1) {
		CommandLine.logOutput("Hello, "+ arg1+"!");
	}
 
	public static <T> void printTransfer(T arg0, T arg1, T arg2) {
		CommandLine.logOutput("Transferred "+ arg1+" to "+ arg2);
	}

	public static <T> void  owingToStatement(T arg1, T arg2) {
		CommandLine.logOutput("Owing "+ arg1 +" to "+ arg2);
	}
	public static <T> void  owingFromStatement(T arg1, T arg2) {
		CommandLine.logOutput("Owing "+ arg1 +" from "+ arg2);
	}
	public static <T> void  printBalance(T arg1) {
		CommandLine.logOutput("Your balance is "+ arg1 );
	}

}
