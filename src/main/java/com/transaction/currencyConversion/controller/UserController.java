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

import com.transaction.currencyConversion.entity.User;
import com.transaction.currencyConversion.repository.UserRepository;

//annotation for Spring to understand that this class is a controller.
@RestController
//Defines the url that the class will be accessed to perform requests.
@RequestMapping("/user")
public class UserController {

	// The annotation is for spring to instantiate the class, for the query methods
	// to be accessed by the controller.
	@Autowired
	// Repository class injection.
	private UserRepository userRepository;

	// The annotation of the method that will be used in the external request, in
	// the get case to fetch all users.
	@GetMapping
	// Creation of the findAll method, which will search the list of all users.
	public ResponseEntity<List<User>> getAll() {
		return ResponseEntity.ok(userRepository.findAll());
	}

	// The annotation of the method that will be used in the external request, in
	// the get case to search users by id, containing the id parameter that will
	// return a user with a given id.
	@GetMapping("/{idUser}")
	// The @PathVariable annotation captures the value coming url.
	public ResponseEntity<User> getById(@PathVariable long idUser) {
		return userRepository.findById(idUser).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.badRequest().build());
	}

	// The annotation of the method that will be used in the external request, in
	// the get case to find a name, has a subpath so as not to duplicate the
	// endpoint.
	@GetMapping("/name/{name}")
	// The @PathVariable annotation captures the value coming url.
	public ResponseEntity<List<User>> getByName(@PathVariable String name) {
		return ResponseEntity.ok(userRepository.findByNameContainingIgnoreCase(name));
	}

	// The annotation of the method that will be used in the external request, in
	// this case post to register a user.
	@PostMapping
	// The RequestBody annotation is used to map the body and the return must be
	// written to the response body.
	public ResponseEntity<User> postUser(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(user));
	}

	// The annotation of the method that will be used in the external request, in
	// this case delete to delete a user, containing the parameter id of the user to
	// be deleted.
	@DeleteMapping("/{idUser}")
	// The @PathVariable annotation captures the value coming url.
	public void deleteUser(@PathVariable long idUser) {
		userRepository.deleteById(idUser);
	}

}
