package com.monocept.service;

import java.sql.SQLException;
import java.util.List;

import com.monocept.model.Account;
import com.monocept.model.Transaction;
import com.monocept.repository.AccountRepository;

public class AccountService {
	private static AccountService instance = null;

	private AccountService() {

	}
	
	public static AccountService getInstance() {
		if (instance == null)
			instance = new AccountService();
		return instance;
	}

	
	public void addAccount(Account account) {
		AccountRepository repo = AccountRepository.getInstance();
		
		try {
			repo.addAccount(account);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addTransaction(Transaction transaction) {
		AccountRepository repo = AccountRepository.getInstance();
		
		try {
			repo.addTransaction(transaction);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Transaction> getTransactions(String name){
		AccountRepository repo = AccountRepository.getInstance();
		
		try {
			return repo.getTransactions(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Account> getAccounts(){
		AccountRepository repo = AccountRepository.getInstance();
		
		try {
			return repo.getAccounts();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Account findAccount(String name) {
		AccountRepository repo = AccountRepository.getInstance();
		
		try {
			return repo.findAccount(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateBalacne(String name, double balance) {
		AccountRepository repo = AccountRepository.getInstance();
		
		try {
			repo.updateBalance(name, balance);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
