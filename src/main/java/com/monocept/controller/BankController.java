package com.monocept.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.model.Account;
import com.monocept.model.Transaction;
import com.monocept.service.AccountService;

@RestController
@RequestMapping("/api/v1/bank")
public class BankController {
	@Autowired
	AccountService service;

	public BankController() {

	}

	@GetMapping(path = "/findAccount/{name}")
	public ResponseEntity<Account> findAccount(@PathVariable("name") String name) {
		
		System.out.println("name: "+name);
		return ResponseEntity.ok(service.findAccount(name));
	}
	
	@GetMapping(path = "/accounts")
	public ResponseEntity<List<Account>> getAllAccounts() {
		return ResponseEntity.ok(service.getAccounts());
	}
	
	@GetMapping(path = "/transactions/{name}")
	public ResponseEntity<List<Transaction>> getAllTransactions(@PathVariable("name") String name) {
		return ResponseEntity.ok(service.getTransactions(name));
	}

	@PostMapping(path = "/addAccount")
	public ResponseEntity<Account> post(@RequestBody Account account) {
		service.addAccount(account);
		return ResponseEntity.ok(account);
	}
	
	@PostMapping(path = "/addTransaction")
	public ResponseEntity<Transaction> post(@RequestBody Transaction transaction) {
		service.addTransaction(transaction);
		return ResponseEntity.ok(transaction);
	}

	
	@PutMapping
	public String put() {
		return "inside put";
	}

	@DeleteMapping
	public String delete() {
		return "inside delete";
	}

}
