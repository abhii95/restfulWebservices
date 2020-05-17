package com.RestPractice.restfulwebservices.UserJPA;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceJPA {

	@Autowired
	UserRepositoryJPA userRepository;

	public List<UserJPA> getAllUsers() {
		return userRepository.findAll();
	}

	public UserJPA createOneUser(UserJPA user) {
		return userRepository.save(user);
	}

	public Optional<UserJPA> retriveOneUser(int id) {

		return userRepository.findById(id);
	}

	public void deleteUser(int id) {

		userRepository.deleteById(id);
	}

}
