package com.transaction.currencyConversion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transaction.currencyConversion.entity.DataConversion;
import com.transaction.currencyConversion.repository.DataConversionRepository;

//The annotation for Spring to understand that this class is a controller.
@RestController
//Defines the url that the class will be accessed to perform requests.
@RequestMapping("/dataconversion")
public class DataConversionController {

	// The annotation is for spring to instantiate the class, for the query methods
	// to be accessed by the controller.
	@Autowired
	// Repository class injection.
	private DataConversionRepository dataConversionRepository;

	// The annotation of the method that will be used in the external request, in
	// the get case to fetch all data conversions.
	@GetMapping
	// Creation of the findAll method, which will search the list of all data conversions.
	public ResponseEntity<List<DataConversion>> getAll() {
		return ResponseEntity.ok(dataConversionRepository.findAll());
	}

	// The annotation of the method that will be used in the external request, in
	// the get case to search conversion by id, containing the id parameter that
	// willreturn a conversion with a given id.
	@GetMapping("/{idConversion}")
	// The @PathVariable annotation captures the value coming url.
	public ResponseEntity<DataConversion> getById(@PathVariable long idConversion) {
		return dataConversionRepository.findById(idConversion).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.badRequest().build());
	}

	// The annotation of the method that will be used in the external request, in
	// the get case to find a currency origin, has a subpath so as not to duplicate
	// the endpoint.
	@GetMapping("/currencyOrigin/{currencyOrigin}")
	// The @PathVariable annotation captures the value coming url.
	public ResponseEntity<List<DataConversion>> getBycurrencyOrigin(@PathVariable String currencyOrigin) {
		return ResponseEntity.ok(dataConversionRepository.findBycurrencyOriginContainingIgnoreCase(currencyOrigin));
	}

	// The annotation of the method that will be used in the external request, in
	// the get case to find a destination currency, has a subpath so as not to duplicate
	// the endpoint.
	@GetMapping("/destinationCurrency/{destinationCurrency}")
	// The @PathVariable annotation captures the value coming url.
	public ResponseEntity<List<DataConversion>> getBydestinationCurrency(@PathVariable String destinationCurrency) {
		return ResponseEntity.ok(dataConversionRepository.findBydestinationCurrencyContainingIgnoreCase(destinationCurrency));
	}
	
	// The annotation of the method that will be used in the external request, in
	// this case post to register a data conversion.
	@PostMapping
	// The RequestBody annotation is used to map the body and the return must be
	// written to the response body.
	public ResponseEntity<DataConversion> postDataConversion(@RequestBody DataConversion dataConversion) {
		return ResponseEntity.status(HttpStatus.CREATED).body(dataConversionRepository.save(dataConversion));
	}

	// The annotation of the method that will be used in the external request, in
	// this case delete to delete a data conversion, containing the parameter id of the user to
	// be deleted.
	@DeleteMapping("/{idConversion}")
	// The @PathVariable annotation captures the value coming url.
	public void deleteUser(@PathVariable long idConversion) {
		dataConversionRepository.deleteById(idConversion);
	}
}
