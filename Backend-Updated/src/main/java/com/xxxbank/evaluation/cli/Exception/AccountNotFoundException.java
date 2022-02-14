/*
 * =============================================================================
 * For internal use of XXX Bank only.(C) 2022  XXX BANK.All Rights Reserved.
 * Information in this file is the intellectual property of XXX BANK
 * =============================================================================
 */
package com.xxxbank.evaluation.cli.Exception;

/**
 * Exception Handling method for Account Details
 * @author DINESHKANNAN_R
 * @version 1.0
 * @since 04Feb2022
 *
 */
public class AccountNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	/**
	 * Method to generate Exception when account not found
	 * @param errorMessage
	 *            :Error Message
	 *  @param err
	 *            :throwable Error
	 */
    public AccountNotFoundException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

	/**
	 * Method to generate Exception when account not found
	 * @param errorMessage
	 *            :Error Message
	 *  @param err
	 *            :throwable Error
	 */
    public AccountNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
