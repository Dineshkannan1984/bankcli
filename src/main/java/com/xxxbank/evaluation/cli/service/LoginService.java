package com.xxxbank.evaluation.cli.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxxbank.evaluation.cli.common.Message;
import com.xxxbank.evaluation.cli.model.Account;

/**
 * @author DINESHKANNAN_R
 *
 */
 
@Service
public class LoginService implements BaseService{
	@Autowired
	private AccountService accountService;
 
	public Account login(String accountName) {
		Account acc = accountService.searchAccount(accountName.trim());
		if (acc == null) {
			acc = accountService.createAccount(accountName);
		}
		acc.setMessageDetails(Message.getGreetingInfo(accountName));
		return acc;
	}
}