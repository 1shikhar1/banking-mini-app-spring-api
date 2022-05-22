package com.monocept.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bank")
public class BankController {

	public BankController() {
	
	}
	

	@GetMapping
	public String get() {
		return "inside get";
	}

	@PostMapping
	public String post() {
		return "inside post";
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
