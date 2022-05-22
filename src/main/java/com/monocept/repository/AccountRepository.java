package com.monocept.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.monocept.model.Account;
import com.monocept.model.Transaction;

@Repository
public class AccountRepository {
	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void addAccount(Account account) {
		em.persist(account);
	}
	
	@Transactional
	public void addTransaction(Transaction transaction) {
		em.persist(transaction);
	}
	
	public List<Transaction> getTransactions(String userName) {
		Query query = em.createQuery("Select tr from Transaction tr where tr.account_name=:arg1");
		query.setParameter("arg1", userName);
		return  query.getResultList();
	}
	
	public List<Account> getAccounts() {

	    return em.createQuery("From Account").getResultList();
	}
	
	public Account findAccount(String name) {
		Query query = em.createQuery("Select ac from Account ac where ac.name=:arg1");
		query.setParameter("arg1", name);
		return  (Account) query.getSingleResult();
	}
	
	public void updateBalance(String name, double balance) throws SQLException {
		Query query = em.createQuery("UPDATE Account SET balance=?1 WHERE name=?2");
		query.setParameter(1, balance);
		query.setParameter(2, name);
	}
	
}
