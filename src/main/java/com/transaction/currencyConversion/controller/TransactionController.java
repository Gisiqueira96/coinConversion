package com.transaction.currencyConversion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transaction.currencyConversion.entity.Transaction;
import com.transaction.currencyConversion.repository.TransactionRepository;

//The annotation for Spring to understand that this class is a controller.
@RestController
//Defines the url that the class will be accessed to perform requests.
@RequestMapping("/transaction")
public class TransactionController {

	// The annotation is for spring to instantiate the class, for the query methods
	// to be accessed by the controller.
	@Autowired
	// Repository class injection.
	private TransactionRepository transactionRepository;

	// The annotation of the method that will be used in the external request, in
	// the get case to fetch all transaction.
	@GetMapping
	// Creation of the findAll method, which will search the list of all
	// transaction.
	public ResponseEntity<List<Transaction>> getAll() {
		return ResponseEntity.ok(transactionRepository.findAll());
	}

	// The annotation of the method that will be used in the external request, in
	// the get case to search conversion by id, containing the id parameter that
	// will return a transaction with a given id.
	@GetMapping("/{idTransaction}")
	// The @PathVariable annotation captures the value coming url.
	public ResponseEntity<Transaction> getById(@PathVariable long idTransaction) {
		return transactionRepository.findById(idTransaction)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.badRequest().build());
	}

}
