
package com.ocbc.evaluation.cli;

import java.math.BigDecimal;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import com.ocbc.evaluation.cli.Exception.AccountNotFoundException;
import com.ocbc.evaluation.cli.Exception.BankCLIException;
import com.ocbc.evaluation.cli.common.Utils;
import com.ocbc.evaluation.cli.model.Account;
import com.ocbc.evaluation.cli.service.AccountService;
import com.ocbc.evaluation.cli.service.LoginService;
import com.ocbc.evaluation.cli.service.TransactionService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author DINESHKANNAN_R
 *
 */

@ShellComponent
public class CommandLine {

	LoginService loginService = LoginService.getInstance();
	TransactionService transacationService = TransactionService.getInstance();
	AccountService accountService = AccountService.getInstance();
	Account loggedInAccount = null;

	/**
	 * Method used to get login user details and validate whether user is
	 * available or not and print remaining balance amount
	 *
	 */

	@ShellMethod(value = "login")
	public void login(String accountName) {
		try {
			loggedInAccount = loginService.login(Utils.cleanString(accountName));
			accountService.getBalanceDetails(loggedInAccount);
		} catch (BankCLIException e) {
			logOutput(e.getMessage());
			return;
		} catch (Exception e) {
			logOutput(e.getMessage());
		}
	}

	/**
	 * Method used topup to an account
	 *
	 */

	@ShellMethod(value = "topup")
	public void topup(String amountStr) {
		BigDecimal amount = null;
		try {
			if (loggedInAccount == null) {
				logOutput("Please login first");
				return;
			}
			amount = new BigDecimal(amountStr);
			transacationService.topUpAccount(loggedInAccount, amount);
			accountService.getBalanceDetails(loggedInAccount);
		} catch (NumberFormatException e) {
			logOutput("Please enter valid amount");
		} catch (BankCLIException e) {
			logOutput(e.getMessage());
		} catch (Exception e) {
			logOutput(e.getMessage());
		}
	}

	/**
	 * Method used to pay to an account from another account
	 *
	 */
	@ShellMethod(value = "pay")
	public void pay(String accountName, String amountStr) {
		BigDecimal amount = null;
		try {

			amount = new BigDecimal(amountStr);
			if (loggedInAccount == null) {
				logOutput("Please login first");
				return;
			}
			transacationService.makeTransfer(loggedInAccount, amount, Utils.cleanString(accountName));
			accountService.getBalanceDetails(loggedInAccount);
		} catch (NumberFormatException e) {
			logOutput("Please enter valid amount");
		} catch (AccountNotFoundException e) {
			logOutput(e.getMessage());
		} catch (BankCLIException e) {
			logOutput(e.getMessage());
		} catch (Exception e) {
			logOutput(e.getMessage());
		}
	}

	public static void logOutput(String text) {
		System.out.println(text);

	}
}
