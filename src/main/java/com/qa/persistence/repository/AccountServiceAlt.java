package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;

import java.util.HashMap;

import javax.enterprise.inject.Alternative;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@ApplicationScoped
@Alternative
public class AccountServiceAlt implements IConnect {

	private JSONUtil util;
	HashMap<Long, Account> accounts = new HashMap<>();

	@Inject
	IdCheck BR;

	@Transactional(REQUIRED)
	public String createAccount(String account) {
		Account acc = util.getObjectForJSON(account, Account.class);
		if (BR.checkID(acc)) {
			accounts.put(acc.getID(), acc);
			return "{\"message\": \"Account Successfully Added\"}";
		}

		return "{\"message\": \"This Account is Blocked\"}";
	}

	public Account findAccount(Long id) {
		return accounts.get(id);
	}

	public String getAllAccounts() {
		return accounts.values().toString();
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
	public String updateAccount(String a, Long id) {
		Account NewAccount = util.getObjectForJSON(a, Account.class);
		accounts.put(id, NewAccount);
		return "{\"message\": \"Account sucessfully updated\"}";

	}

}
