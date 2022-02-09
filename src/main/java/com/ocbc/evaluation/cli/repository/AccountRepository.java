/**
 * 
 */
package com.ocbc.evaluation.cli.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ocbc.evaluation.cli.common.Utils;
import com.ocbc.evaluation.cli.model.Account;
import com.ocbc.evaluation.cli.model.Debt;

/**
 * @author DINESHKANNAN_R
 *
 */
public class AccountRepository {
	private static List<Account> accountList = new ArrayList<Account>();
	private static List<Debt> debtList = new ArrayList<Debt>();

	private static AccountRepository accountRepo = new AccountRepository();

	private AccountRepository() {
	};

	public static AccountRepository getInstance() {
		return accountRepo;
	}

	public Account searchAccount(String accountName) {
		if (Utils.isEmpty(accountName)) {
			return null;
		}
		return accountList.stream().filter(acc -> acc.getAccountName().equalsIgnoreCase(accountName.trim())).findFirst()
				.orElse(null);
	}

	public boolean saveOrUpdateAccount(Account account) {
		if (null == account) {
			return false;
		}
		accountList.add(account);
		return true;
	}

	public List<Debt> retrieveDebtByAccountName(String accountName) {
		if (Utils.isEmpty(accountName)) {
			return null;
		}
		return debtList.stream().filter(debt -> debt.getAccountName().equalsIgnoreCase(accountName.trim()))
				.collect(Collectors.toList());
	}

	public List<Debt> retrieveDebtByOweToAccountName(String OweToAccountName) {
		if (Utils.isEmpty(OweToAccountName)) {
			return null;
		}
		return debtList.stream().filter(debt -> debt.getOweToAccountName().equalsIgnoreCase(OweToAccountName.trim()))
				.collect(Collectors.toList());
	}
	public boolean deleteDebt(Debt debt ) {
		if(debtList.contains(debt)) {
			debtList.remove(debt);
			return true;
		}else {
			return false;
		}
	}
	public void  addDebt(Debt debt ) {
		if(!debtList.contains(debt)){
		debtList.add(debt) ;
		}
	}

}
