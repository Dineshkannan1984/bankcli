/*
 * =============================================================================
 * For internal use of XXX Bank only.(C) 2022  XXX BANK.All Rights Reserved.
 * Information in this file is the intellectual property of XXX BANK
 * =============================================================================
 */
package com.xxxbank.evaluation.cli.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxxbank.evaluation.cli.common.Message;
import com.xxxbank.evaluation.cli.model.Account;

/**
 * Account service use to process account related details
 * 
 * @author DINESHKANNAN_R
 * @version 1.0
 * @since 04Feb2022
 *
 */
 
@Service
public class LoginService implements BaseService{
	@Autowired
	private AccountService accountService;
 
	/**
	 * Method used perform login based on input user details
	 * If UserID available ,allow it and if not , create new user and allow  
	 * @param accountName
	 *            : Input param is account to be created
	 * @return Account details
	 */
	public Account login(String accountName) {
		Account acc = accountService.searchAccount(accountName.trim());
		if (acc == null) {
			acc = accountService.createAccount(accountName);
		}
		acc.setMessageDetails(Message.getGreetingInfo(accountName));
		return acc;
	}
}