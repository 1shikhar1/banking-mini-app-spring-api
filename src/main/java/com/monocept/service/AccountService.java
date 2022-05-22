package com.monocept.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.model.Account;
import com.monocept.model.Transaction;
import com.monocept.repository.AccountRepository;

@Service
public class AccountService {
  @Autowired
  AccountRepository repo;
  
  private static AccountService instance = null;

  private AccountService() {

  }
  
  public static AccountService getInstance() {
    if (instance == null)
      instance = new AccountService();
    return instance;
  }

  
  public void addAccount(Account account) {
    
    repo.addAccount(account);
  }
  
  public void addTransaction(Transaction transaction) {
    
      repo.addTransaction(transaction);
  }
  
  public List<Transaction> getTransactions(String name){
    
	  return repo.getTransactions(name);
  }
  
  public List<Account> getAccounts(){
    
    return repo.getAccounts();
  }
  
  public Account findAccount(String name) {
    
	return repo.findAccount(name);
  }
  
  public void updateBalacne(String name, double balance) {
    
    try {
      repo.updateBalance(name, balance);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}