package com.RestPractice.restfulwebservices.User;

import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class UserService {
	//Repo repo

	public List<User> getAllUsers() {
		
		//repo.save(user);

		return UserDataBase.getUsers();
	}

	public User AddUser(User user) {

		return UserDataBase.addUser(user);

	}

	public User getAUser(int id) {

		return UserDataBase.getAUser(id);
	}
	
	
	public User deleteUser(int id) {

		return UserDataBase.deleteUser(id);
	}
	
	

}
