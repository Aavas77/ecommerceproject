package com.bway.ecommerceproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bway.ecommerceproject.model.Admin;
import com.bway.ecommerceproject.repository.AdminRepository;
import com.bway.ecommerceproject.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository adminRepo;

	@Override
	public void signup(Admin admin) {
		adminRepo.save(admin);
		
	}

	@Override
	public Admin login(String username, String password) {
		
		return adminRepo.findByUsernameAndPassword(username, password);
	}

	@Override
	public Admin isAdminExist(String username) {
		
		return adminRepo.findByUsername(username);
	}

}
