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
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.monocept.model.Account;
import com.monocept.model.Transaction;
import com.monocept.service.AccountService;

@Repository
public class AccountRepository {
	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void addAccount(Account account) {
		em.persist(account);
	}
	
	public void addTransaction(Transaction transaction) throws SQLException {

	}
	
	public List<Transaction> getTransactions(String userName) throws SQLException{
		List<Transaction> transactions = new ArrayList<>();

	    return transactions;
	}
	
	public List<Account> getAccounts() {

	    return em.createQuery("From Account").getResultList();
	}
	
	public Account findAccount(String name) throws SQLException {

	    
	    return null;
	}
	
	public void updateBalance(String name, double balance) throws SQLException {

	}
	
}
