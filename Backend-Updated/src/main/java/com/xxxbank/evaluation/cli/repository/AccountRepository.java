/*
 * =============================================================================
 * For internal use of XXX Bank only.(C) 2022  XXX BANK.All Rights Reserved.
 * Information in this file is the intellectual property of XXX BANK
 * =============================================================================
 */
package com.xxxbank.evaluation.cli.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.xxxbank.evaluation.cli.common.Utils;
import com.xxxbank.evaluation.cli.model.Account;
import com.xxxbank.evaluation.cli.model.Debt;

/**
 * Repository Class to handle account related transaction infromation
 * 
 * @author DINESHKANNAN_R
 * @version 1.0
 * @since 04Feb2022
 *
 */
public class AccountRepository {
	private static List<Account> accountList = new ArrayList<Account>();
	private static List<Debt> debtList = new ArrayList<Debt>();

	private static AccountRepository accountRepo = new AccountRepository();

	private AccountRepository() {
	};

	/**
	 * Method used to get instance of Account Repo
	 * 
	 * @return Instance of Account Repo
	 * 
	 *
	 */

	public static AccountRepository getInstance() {
		return accountRepo;
	}

	/**
	 * Method used to get account details based on account name
	 * 
	 * @param accountName
	 *            :Name of the account
	 * @return Account Details
	 * 
	 *
	 */
	public Account searchAccount(String accountName) {
		if (Utils.isEmpty(accountName)) {
			return null;
		}
		return accountList.stream().filter(acc -> acc.getAccountName().equalsIgnoreCase(accountName.trim())).findFirst()
				.orElse(null);
	}

	/**
	 * Method used to Save Account or update Account Details
	 * 
	 * @param account
	 *            :Input param is Account details
	 * @return boolean : Status of update
	 * 
	 *
	 */
	public boolean saveOrUpdateAccount(Account account) {
		if (null == account) {
			return false;
		}
		accountList.add(account);
		return true;
	}

	/**
	 * Method used to Retrieve Debt by Account Name
	 * 
	 * @param accountName
	 *            :Input param is Account Name
	 * @return List : Details of debt information
	 * 
	 *
	 */
	public List<Debt> retrieveDebtByAccountName(String accountName) {
		if (Utils.isEmpty(accountName)) {
			return null;
		}
		return debtList.stream().filter(debt -> debt.getAccountName().equalsIgnoreCase(accountName.trim()))
				.collect(Collectors.toList());
	}

	/**
	 * Method used to Retrieve Debt by Account Name
	 * 
	 * @param OweToAccountName
	 *            :Input param owe to other account
	 * @return account : Details of debt information owe to other account
	 * 
	 *
	 */
	public List<Debt> retrieveDebtByOweToAccountName(String OweToAccountName) {
		if (Utils.isEmpty(OweToAccountName)) {
			return null;
		}
		return debtList.stream().filter(debt -> debt.getOweToAccountName().equalsIgnoreCase(OweToAccountName.trim()))
				.collect(Collectors.toList());
	}

	/**
	 * Method used to get delete Debt details
	 * 
	 * @param debt
	 *            :Input debt details
	 * @return Boolean : status of the transaction
	 * 
	 *
	 */
	public boolean deleteDebt(Debt debt) {
		if (debtList.contains(debt)) {
			debtList.remove(debt);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Method used to get add Debt details
	 * 
	 * @param debt
	 *            :Input debt details
	 * @return Boolean : status of the transaction
	 * 
	 *
	 */
	public void addDebt(Debt debt) {
		if (!debtList.contains(debt)) {
			debtList.add(debt);
		}
	}

}
