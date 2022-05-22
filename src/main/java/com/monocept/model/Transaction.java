package com.monocept.model;

import java.sql.Timestamp;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {
	
	private double amount;
	private String type;
	@Id
	private Timestamp time;
	
	@ManyToOne
	@JoinColumn
	private Account account;
	
	public Transaction() {
		
	}
	
	public Transaction(Account account, double amount, String type, Timestamp time) {
		
		this.account = account;
		this.amount = amount;
		this.type =type;
		this.time = time;
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
