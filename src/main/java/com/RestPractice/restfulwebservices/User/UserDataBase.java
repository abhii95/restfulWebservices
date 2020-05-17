package com.RestPractice.restfulwebservices.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDataBase {

	private static List<User> users = new ArrayList<>();
	private static Integer counter = 4;

	static {

		users.add(new User(1, "Red", new Date()));
		users.add(new User(2, "Blue", new Date()));
		users.add(new User(3, "Yellow", new Date()));

	}

	public static List<User> getUsers() {
		return users;
	}

	public static User addUser(User user) {
		user.setId(counter++);
		users.add(user);
		return user;
	}

	public static User getAUser(int id) {
		for (User aUser : users) {
			if (aUser.getId().equals(id)) {
				return aUser;
			}
		}
		return null;
	}

	public static User deleteUser(int id) {
		for (User aUser : users) {
			if (aUser.getId().equals(id)) {
				users.remove(aUser);
				return aUser;
			}
		}
		return null;
	}

}
