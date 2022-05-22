package com.monocept.model;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.monocept.service.AccountService;

@Entity
public class Account {
	private static final int minBalance = 500;
	
	@Id
	private String name;
	private double balance;
	private String password;
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	private List<Transaction> transactions;
	
	public Account() {
		
	}
	
	public Account(String name, double balance, String password) {
		this.name = name;
		this.balance = balance;
		this.password = password;
		transactions = new ArrayList<>();
	}
	

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Transaction> getTransactions() {
		return transactions;
	}

	public String getName() {
		return name;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void deposite(double amount) {
		AccountService service = AccountService.getInstance();
		
		service.addTransaction(new Transaction(this,amount,"Deposite", Timestamp.from(Instant.now())));
		balance += amount;
		
		service.updateBalacne(name, balance);
	}

	public void withdraw(double amount) {
		if ((balance - amount) >= minBalance) {
			AccountService service = AccountService.getInstance();
			service.addTransaction(new Transaction(this, amount, "Withdraw", Timestamp.from(Instant.now())));
			balance -= amount;
			service.updateBalacne(name, balance);
		}
			
	}
}
