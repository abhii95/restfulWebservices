package com.RestPractice.restfulwebservices.UserJPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryJPA extends JpaRepository<UserJPA, Integer> {

}
