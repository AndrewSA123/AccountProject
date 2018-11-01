package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class AccountServiceDBImpl {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	private JSONUtil util;

	
	@Transactional(REQUIRED)
	public String createAccount(String account) {
		Account acc = util.getObjectForJSON(account, Account.class);
		manager.persist(acc);
		return "{\"message\": \"Movie Successfully Added\"}";
	}

	public Account findAccount(Long id) {
		return manager.find(Account.class, id);
	}

	public String getAllAccounts() {
		Query q = manager.createQuery("Select a FROM ACCOUNT a");
		Collection<Account> accounts = (Collection<Account>) q.getResultList();
		return util.getJSONForObject(accounts);
	}

	@Transactional(REQUIRED)
	public String deleteAccount(Long id) {
		Account accountInDb = findAccount(id);
		if (accountInDb != null) {
			manager.remove(accountInDb);
		}
		return "{\"message\": \"Account sucessfully deleted\"}";
	}

	@Transactional(REQUIRED)
	public String updateAccount(Account a, Long id) {
		Account old = manager.find(Account.class, id);

		old.setFirstName(a.getFirstName());
		old.setLastName(a.getLastName());
		old.setAccountNumber(a.getAccountNumber());

		return "{\"message\": \"Account sucessfully updated\"}";


	}

}
