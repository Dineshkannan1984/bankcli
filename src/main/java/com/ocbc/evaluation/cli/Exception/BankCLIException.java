/**
 * 
 */
package com.ocbc.evaluation.cli.Exception;

/**
 * @author DINESHKANNAN_R
 *
 */
public class BankCLIException extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BankCLIException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
	public BankCLIException(String errorMessage) {
        super(errorMessage);
    }
}
