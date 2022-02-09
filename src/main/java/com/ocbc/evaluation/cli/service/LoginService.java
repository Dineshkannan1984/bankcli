package com.ocbc.evaluation.cli.service;

import com.ocbc.evaluation.cli.common.Message;
import com.ocbc.evaluation.cli.model.Account;

/**
 * @author DINESHKANNAN_R
 *
 */
 
public class LoginService implements BaseService{

	private AccountService accountService;
 
	public static LoginService getInstance() {
		LoginService as = new LoginService();
		as.accountService = AccountService.getInstance();
 		return as;
	}

	public Account login(String accountName) {
		Account acc = accountService.searchAccount(accountName.trim());
		if (acc == null) {
			acc = accountService.createAccount(accountName);
		}
		Message.getGreetingInfo(accountName);
		return acc;
	}
}