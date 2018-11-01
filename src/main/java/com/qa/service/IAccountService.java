package com.qa.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.qa.persistence.domain.Account;

public interface IAccountService {

	Account getAccount(Long accountNum);

	String createAccount(String account);

	String getAllAccounts() throws JsonProcessingException;

	String deleteAccount(Long id);

	String updateAccount(Long id, String account);

}