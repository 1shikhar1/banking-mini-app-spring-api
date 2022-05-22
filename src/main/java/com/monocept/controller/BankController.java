package com.monocept.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.model.Account;
import com.monocept.service.AccountService;

@RestController
@RequestMapping("/api/v1/bank")
public class BankController {
	@Autowired
	AccountService service;

	public BankController() {

	}

	@GetMapping(path = "/accounts")
	public ResponseEntity<List<Account>> getAllAccounts() {
		return ResponseEntity.ok(service.getAccounts());
	}

	@PostMapping(path = "/addAccount")
	public ResponseEntity<Account> post(@RequestBody Account account) {
		service.addAccount(account);
		return ResponseEntity.ok(account);
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
