package com.RestPractice.restfulwebservices.User;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.RestPractice.restfulwebservices.exception.UsernotFoundException;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public List<User> getallUsers() {

		return userService.getAllUsers();
	}

	@GetMapping("/users/{id}")
	public User getAUserByID(@PathVariable int id) {

		User auser = userService.getAUser(id);
		if (auser == null)
			throw new UsernotFoundException("ID : " + id);
		else
			return auser;

	}

	@PostMapping("/users")
	public ResponseEntity<?> createAUser(@Valid @RequestBody User user) {

		User auser = userService.AddUser(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(auser.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<Object> deleteAUserByID(@PathVariable int id) {

		User auser = userService.deleteUser(id);
		if (auser == null)
			throw new UsernotFoundException("ID : " + id);

		return ResponseEntity.noContent().build();

	}
}
