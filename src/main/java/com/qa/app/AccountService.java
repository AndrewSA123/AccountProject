package com.qa.app;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AccountService {

	private Map<String, Account> accountMap = new HashMap<String, Account>();

	private ObjectMapper factory = new ObjectMapper();

	public Account getAccount(String accountNum) {

		return accountMap.get(accountNum);
	}

	public String createAccount(String accountNum, String fName, String lName) {

		Account newAccount = new Account(accountNum, fName, lName);

		accountMap.put(accountNum, newAccount);

		return "Account Created";
	}

	public String printTables() throws JsonProcessingException {


		System.out.println(factory.writeValueAsString(accountMap.values()));

		return "Printing tables";
	}

	public int getAccountSum(String fName) {

		int count = 0;

		for (Account a : accountMap.values()) {
			if (a.firstName.equals(fName)) {
				count++;
			}
		}

		return count;
	}

}
