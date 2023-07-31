package com.bway.ecommerceproject.service;

import com.bway.ecommerceproject.model.User;

public interface UserService {
	
	void signup(User user);
	
	User login (String username, String password);
	
	User isUserExist(String username);

}
