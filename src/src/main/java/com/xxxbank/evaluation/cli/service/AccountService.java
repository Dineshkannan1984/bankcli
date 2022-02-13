package com.xxxbank.evaluation.cli.service;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.xxxbank.evaluation.cli.common.Message;
import com.xxxbank.evaluation.cli.common.Utils;
import com.xxxbank.evaluation.cli.controller.BankController;
import com.xxxbank.evaluation.cli.model.Account;
import com.xxxbank.evaluation.cli.model.Debt;

/**
 * Service class to service the account level details
 * @author DINESHKANNAN_R
 *
 */

@Service
public class AccountService implements BaseService {

	private AccountService() {
	};
	public static AccountService getInstance() {
		AccountService as = new AccountService();
		return as;
	}

	public boolean saveOrUpdateAccount(Account account) {
		return accountRepo.saveOrUpdateAccount(account);

	}

	public Account searchAccount(String accountName) {
		Account acc = accountRepo.searchAccount(accountName);
		if (null != acc) {
			acc.setDebts(retrieveDebtByAccountName(accountName));
			acc.setDebtsByOthers(retrieveDebtByOweToAccountName(accountName));
		}
		return acc;

	}

	public Account createAccount(String accountName) {
		Account account = new Account.AccountBuilder(accountName).withCreatedDateTime(LocalDateTime.now())
				.withAccoutBalance(BigDecimal.ZERO).build();
		this.saveOrUpdateAccount(account);
		return account;

	}

	public List<Debt> retrieveDebtByAccountName(String accountName) {
		return accountRepo.retrieveDebtByAccountName(accountName);
	}

	public List<Debt> retrieveDebtByOweToAccountName(String OweToAccountName) {
		return accountRepo.retrieveDebtByOweToAccountName(OweToAccountName);
	}
	public Account getBalanceDetails(Account account) {
		if (!Utils.isEmpty(account.getDebts())) {
			account.getDebts().stream().forEach((debt) -> {
				account.setMessageDetails(account.getMessageDetails()+Message.owingToStatement(debt.getDebtAmount(), debt.getOweToAccountName()));
			});
		}

		if (!Utils.isEmpty(account.getDebtsByOthers())) {
			account.getDebtsByOthers().stream().forEach((debt) -> {
				account.setMessageDetails(account.getMessageDetails()+(Message.owingFromStatement(debt.getDebtAmount(), debt.getAccountName())));
			});
		}
		account.setMessageDetails(Message.printBalance(account.getAccoutBalance()));
		return account;
	}

}
