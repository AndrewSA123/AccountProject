package com.qa.persistence.repository;

import com.qa.persistence.domain.Account;

public class IdCheck {

	public boolean checkID(Account account) {
		if (account.getAccountNumber().equals("9999")) {
			return false;
		}
		return true;
	}

}
