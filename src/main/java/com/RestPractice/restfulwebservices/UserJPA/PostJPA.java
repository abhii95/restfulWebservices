package com.RestPractice.restfulwebservices.UserJPA;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Post")
public class PostJPA {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min = 5, message = "Length of the Name must be greater than 5 characters")
	private String description;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private UserJPA user;
	

	public UserJPA getUser() {
		return user;
	}

	public void setUser(UserJPA user) {
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
