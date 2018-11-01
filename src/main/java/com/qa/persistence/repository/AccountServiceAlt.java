package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;
import java.util.HashMap;

import javax.enterprise.inject.Alternative;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Alternative
public class AccountServiceAlt {

	@PersistenceContext(unitName = "primary")
	private JSONUtil util;
	HashMap<Long, Account> accounts = new HashMap<>();

	@Transactional(REQUIRED)
	public String createAccount(String account) {
		Account acc = util.getObjectForJSON(account, Account.class);
		accounts.put(acc.getID(), acc);
		return "{\"message\": \"Accounth Successfully Added\"}";
	}

	public Account findAccount(Long id) {
		return accounts.get(id);
	}

	public Collection<Account> getAllAccounts() {
		return accounts.values();
	}

	@Transactional(REQUIRED)
	public String deleteAccount(Long id) {
		Account accountInDb = findAccount(id);
		if (accountInDb != null) {
			accounts.remove(id);
		}
		return "{\"message\": \"Account sucessfully deleted\"}";
	}

	@Transactional(REQUIRED)
	public String updateAccount(Account a, Long id) {
		accounts.put(id, a);
		return "{\"message\": \"Account sucessfully updated\"}";

	}

}
