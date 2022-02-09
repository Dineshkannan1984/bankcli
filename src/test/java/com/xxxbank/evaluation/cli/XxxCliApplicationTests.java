package com.xxxbank.evaluation.cli;

import java.math.BigDecimal;

import org.springframework.boot.test.context.SpringBootTest;

import com.xxxbank.evaluation.cli.model.Account;
import com.xxxbank.evaluation.cli.service.AccountService;
import com.xxxbank.evaluation.cli.service.LoginService;
import com.xxxbank.evaluation.cli.service.TransactionService;

import junit.framework.TestCase;

@SpringBootTest
class XxxCliApplicationTests extends TestCase {
	
	TransactionService transactionService = TransactionService.getInstance();
	AccountService accountService = AccountService.getInstance();
	LoginService loginService = LoginService.getInstance();


	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public XxxCliApplicationTests(String testName) {
		super(testName);
	}


	/**
	 * Functional Test
	 */
	public void testLogin() {

		Account account = loginService.login("Dinesh");
		assertTrue(account != null);
		assertTrue(account.getAccountName().equals("Dinesh"));
	}

	public void testTopup() {
		Account account = loginService.login("Dinesh");
		transactionService.topUpAccount(account, new BigDecimal("500"));
		assertTrue(account.getAccoutBalance().compareTo(new BigDecimal("500")) == 0);

	}

	public void testPay() {
		Account account1 = loginService.login("Dinesh");
		Account account2 = loginService.login("Kannan");
		transactionService.topUpAccount(account2, new BigDecimal("500"));
		transactionService.makeTransfer(account2, new BigDecimal("100"), "Dinesh");
		assertTrue(account2.getAccoutBalance().compareTo(new BigDecimal("400")) == 0);
		account1 = loginService.login("Dinesh");
		assertTrue(account1.getAccoutBalance().compareTo(new BigDecimal("200")) == 0);

	}

	
	
}
