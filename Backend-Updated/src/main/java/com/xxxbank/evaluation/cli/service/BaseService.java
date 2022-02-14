/*
 * =============================================================================
 * For internal use of XXX Bank only.(C) 2022  XXX BANK.All Rights Reserved.
 * Information in this file is the intellectual property of XXX BANK
 * =============================================================================
 */
package com.xxxbank.evaluation.cli.service;

import com.xxxbank.evaluation.cli.repository.AccountRepository;

/**
 * Base Interface for creating Account Repo
 * 
 * @author DINESHKANNAN_R
 * @version 1.0
 * @since 04Feb2022
 *
 */
public interface BaseService {

	public static final AccountRepository accountRepo = AccountRepository.getInstance();
}
