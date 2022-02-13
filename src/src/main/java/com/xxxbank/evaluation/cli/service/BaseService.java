/**
 * 
 */
package com.xxxbank.evaluation.cli.service;

import com.xxxbank.evaluation.cli.repository.AccountRepository;

/**
 * @author DINESHKANNAN_R
 *
 */
public interface BaseService {

	public static final AccountRepository accountRepo =  AccountRepository.getInstance();
}
