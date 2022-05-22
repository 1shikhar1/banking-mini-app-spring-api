package com.monocept.model;

import java.sql.Timestamp;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {
	
	private String name;
	private double amount;
	private String type;
	private Timestamp time;
	
	@ManyToOne
	private Account account;
	
	public Transaction(String name, double amount, String type, Timestamp time) {
		
		this.name = name;
		this.amount = amount;
		this.type =type;
		this.time = time;
	}
	
	public String getName() {
		return name;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public String getType() {
		return type;
	}
	
	public Timestamp getTime() {
		return time;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}
	
}
