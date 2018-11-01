package com.qa.persistence.repository;

import com.qa.persistence.domain.Account;

public interface IConnect {

	String createAccount(String account);

	Account findAccount(Long id);

	String getAllAccounts();

	String deleteAccount(Long id);

	String updateAccount(String a, Long id);

}