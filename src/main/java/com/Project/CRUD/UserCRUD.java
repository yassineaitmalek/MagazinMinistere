package com.Project.CRUD;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.Project.Entities.User;



public interface UserCRUD extends CrudRepository<User, Long> {

	@Query("from User u where u.email=:email ")
    public User findByEmail(String email);
	
	
}
