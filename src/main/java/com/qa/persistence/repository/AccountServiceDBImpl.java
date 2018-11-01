package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class AccountServiceDBImpl implements IConnect {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	@Inject
	IdCheck BR;

	@Override
	@Transactional(REQUIRED)
	public String createAccount(String account) {
		Account acc = util.getObjectForJSON(account, Account.class);

		if(BR.checkID(acc)) {
			manager.persist(acc);
			return "{\"message\": \"Account Successfully Added\"}";
		}
		return "{\"message\": \"This Account is Blocked\"}";

	}


	@Override
	public Account findAccount(Long id) {
		return manager.find(Account.class, id);
	}


	@Override
	public String getAllAccounts() {
		Query q = manager.createQuery("Select a FROM Account a");
		Collection<Account> accounts = (Collection<Account>) q.getResultList();
		return util.getJSONForObject(accounts);
	}


	@Override
	@Transactional(REQUIRED)
	public String deleteAccount(Long id) {
		Account accountInDb = findAccount(id);
		if (accountInDb != null) {
			manager.remove(accountInDb);
		}
		return "{\"message\": \"Account sucessfully deleted\"}";
	}


	@Override
	@Transactional(REQUIRED)
	public String updateAccount(String a, Long id) {
		Account newAccount = util.getObjectForJSON(a, Account.class);
		Account old = manager.find(Account.class, id);

		old.setFirstName(newAccount.getFirstName());
		old.setLastName(newAccount.getLastName());
		old.setAccountNumber(newAccount.getAccountNumber());

		return "{\"message\": \"Account sucessfully updated\"}";


	}

}
