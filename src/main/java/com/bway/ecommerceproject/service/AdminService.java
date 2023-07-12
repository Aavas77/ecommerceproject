package com.bway.ecommerceproject.service;

import com.bway.ecommerceproject.model.Admin;

public interface AdminService {

	void signup(Admin admin);

	Admin login(String username, String password);

	Admin isAdminExist(String username);

}
