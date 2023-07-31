package com.bway.ecommerceproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.ecommerceproject.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByUsernameAndPassword(String username, String password);
	
	User findByUsername(String username);

}
