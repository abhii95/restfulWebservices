package com.RestPractice.restfulwebservices.UserJPA;

import java.net.URI;
import java.util.List;
import java.util.Optional;
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
public class UserControllerJPA {

	@Autowired
	private UserServiceJPA userService;
	@Autowired
	private PostServiceJPA postService;

	@GetMapping("jpa/users")
	public List<UserJPA> getallUsers() {

		return userService.getAllUsers();
	}

	@GetMapping("jpa/users/{id}")
	public Optional<UserJPA> getAUserByID(@PathVariable int id) {

		Optional<UserJPA> auser = userService.retriveOneUser(id);

		if (!auser.isPresent())
			throw new UsernotFoundException("ID : " + id);
		else
			return auser;
	}

	@PostMapping("jpa/users")
	public ResponseEntity<Object> createAUser(@Valid @RequestBody UserJPA user) {

		UserJPA savedUser = userService.createOneUser(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}

	@DeleteMapping("jpa/users/{id}")
	public void deleteAUserByID(@PathVariable int id) {

		userService.deleteUser(id);

	}

	// ------------------------------------------------------------------------------------------//

	@GetMapping("jpa/users/{id}/posts")
	public List<PostJPA> getAUserPostsByID(@PathVariable int id) {

		// return postService.getAllPostsOfAUser(id);

		return postService.getAllPostsOfOneUser(getAUserByID(id));

	}

	@PostMapping("jpa/users/{id}/posts")
	public ResponseEntity<Object> createPostForAUser(@Valid @PathVariable int id, @RequestBody PostJPA post) {

		PostJPA savedPost = postService.createAPostForUser(getAUserByID(id), post);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPost.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}

}
