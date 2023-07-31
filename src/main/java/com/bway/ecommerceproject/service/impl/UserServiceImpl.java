package com.bway.ecommerceproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bway.ecommerceproject.model.User;
import com.bway.ecommerceproject.repository.UserRepository;
import com.bway.ecommerceproject.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public void signup(User user) {
		
		userRepo.save(user);
	}

	@Override
	public User login(String username, String password) {
		
		return userRepo.findByUsernameAndPassword(username, password);
	}

	@Override
	public User isUserExist(String username) {
		
		return userRepo.findByUsername(username);
	}
	
	

}
