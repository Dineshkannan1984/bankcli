
package com.xxxbank.evaluation.cli.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xxxbank.evaluation.cli.Exception.AccountNotFoundException;
import com.xxxbank.evaluation.cli.Exception.BankCLIException;
import com.xxxbank.evaluation.cli.common.Utils;
import com.xxxbank.evaluation.cli.model.Account;
import com.xxxbank.evaluation.cli.service.AccountService;
import com.xxxbank.evaluation.cli.service.LoginService;
import com.xxxbank.evaluation.cli.service.TransactionService;

/**
 * Controller Class to intercept all incoming request
 * from users and service the request based on action performed
 * @author DINESHKANNAN_R 
 */

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BankController {

	@Autowired
	LoginService loginService;

	@Autowired
	TransactionService transacationService;

	@Autowired
	AccountService accountService;

	public static Account loggedInAccount;

	/**
	 * Method used to get login user details and validate whether user is
	 * available or not and print remaining balance amount 
	 * Input param is Account details
	 * Return type is the status of Account creation
	 *
	 */

	@GetMapping("/login")
	public ResponseEntity<Account> login(@RequestBody Account account) {
		logOutput(account.getAccountName());
		try {
			loggedInAccount = loginService.login(Utils.cleanString(account.getAccountName()));
			accountService.getBalanceDetails(loggedInAccount);
		} catch (BankCLIException e) {
			logOutput(e.getMessage());
			return ResponseEntity.ok(loggedInAccount);
		} catch (Exception e) {
			logOutput(e.getMessage());
		}

		return ResponseEntity.ok(loggedInAccount);
	}

	/**
	 * Method used topup to an account Input param is topup amount Return type
	 * is the updated account info along with topup details
	 *
	 */
	@PostMapping("/topup/{amountStr}")
	public ResponseEntity<Account> topup(@PathVariable String amountStr) {
		BigDecimal amount = null;
		try {
			if (loggedInAccount == null) {
				loggedInAccount.setMessageDetails("Please login first");
				return ResponseEntity.ok(loggedInAccount);
			}
			amount = new BigDecimal(amountStr);
			transacationService.topUpAccount(loggedInAccount, amount);
			loggedInAccount = accountService.getBalanceDetails(loggedInAccount);
		} catch (NumberFormatException e) {
			logOutput("Please enter valid amount");
		} catch (BankCLIException e) {
			logOutput(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			logOutput(e.getMessage());
		}
		return ResponseEntity.ok(loggedInAccount);
	}

	/**
	 * Method used to pay to an account from another account Input param is
	 * Account details Return type is the account info containing Account
	 * balance and transfer details
	 */
	@PostMapping("/pay/")
	public ResponseEntity<Account> pay(Account account) {
		BigDecimal amount = account.getAmountStr();
		String accountName = account.getAccountName();
		try {
			if (loggedInAccount == null) {
				loggedInAccount.setMessageDetails("Please login first");
				return ResponseEntity.ok(loggedInAccount);
			}
			transacationService.makeTransfer(loggedInAccount, amount, Utils.cleanString(accountName));
			loggedInAccount = accountService.getBalanceDetails(loggedInAccount);
		} catch (NumberFormatException e) {
			logOutput("Please enter valid amount");
		} catch (AccountNotFoundException e) {
			logOutput(e.getMessage());
		} catch (BankCLIException e) {
			logOutput(e.getMessage());
		} catch (Exception e) {
			logOutput(e.getMessage());
		}
		return ResponseEntity.ok(loggedInAccount);
	}

	/**
	 * Method used to perform Logout action
	 * Input param is Account details
	 */
	@PostMapping("/logOut/")
	public ResponseEntity<Account> logOut(Account account) {
		try {
			loggedInAccount = null;
		} catch (BankCLIException e) {
			logOutput(e.getMessage());
			account.setMessageDetails("Exception in processing the request");
			return ResponseEntity.ok(account);
		} catch (Exception e) {
			logOutput(e.getMessage());
		}

		return ResponseEntity.ok(account);
	}

	public static void logOutput(String text) {
		System.out.println(text);

	}
}
