package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;

import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;

public interface IConnect {

	String createAccount(String account);

	Account findAccount(Long id);

	String getAllAccounts();

	String deleteAccount(Long id);

	String updateAccount(Account a, Long id);

}