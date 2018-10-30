package com.qa.app;

import java.util.HashMap;
import java.util.Map;

public class AccountService {

	Map<String, Account> accountMap = new HashMap<String, Account>();

	public Account getAccount(String accountNum) {

		return accountMap.get(accountNum);
	}

	public String createAccount(String accountNum, String fName, String lName) {

		Account newAccount = new Account(accountNum, fName, lName);

		accountMap.put(accountNum, newAccount);

		return "Account Created";
	}

}
