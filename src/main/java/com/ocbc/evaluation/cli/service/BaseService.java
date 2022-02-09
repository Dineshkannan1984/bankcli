/**
 * 
 */
package com.ocbc.evaluation.cli.service;

import com.ocbc.evaluation.cli.repository.AccountRepository;

/**
 * @author DINESHKANNAN_R
 *
 */
public interface BaseService {

	public static final AccountRepository accountRepo =  AccountRepository.getInstance();
}
