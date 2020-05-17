package com.RestPractice.restfulwebservices.UserJPA;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.RestPractice.restfulwebservices.exception.UsernotFoundException;

@Service
@Transactional
public class PostServiceJPA {

	@Autowired
	UserRepositoryJPA userRepository;
	@Autowired
	PostRepositoryJPA postRepository;

	/*
	 * public List<PostJPA> getAllPostsOfAUser(int id) {
	 * 
	 * Optional<UserJPA> auser = userService.retriveOneUser(id);
	 * 
	 * if (!auser.isPresent()) throw new UsernotFoundException("ID : " + id); else
	 * return auser.get().getPosts();
	 * 
	 * }
	 */

	public List<PostJPA> getAllPostsOfOneUser(Optional<UserJPA> auser) {

		// userRepository.findById(id).get().getPosts();

		return auser.get().getPosts();

	}

	public PostJPA createAPostForUser(Optional<UserJPA> auser, PostJPA post) {

		post.setUser(auser.get());
		postRepository.save(post);

		return post;

	}

}
