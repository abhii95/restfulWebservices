package com.RestPractice.restfulwebservices.User;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer id;

	@Size(min = 5, message = "Length of the Name must be greater than 5 characters")
	@Pattern(regexp = "^[a-zA-Z]*$", message = "Name should contains only alphabets")
	private String name;

	@NotNull
	@Past
	private Date birthDate;

	public User(int id, String name, Date birthDate) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public User() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [Id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}

}
