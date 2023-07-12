package com.bway.ecommerceproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bway.ecommerceproject.model.Admin;
import com.bway.ecommerceproject.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/login")
	public String getLogin() {
		
		return "LoginForm";
	}
	
	@PostMapping("/login")
	public String postLogin(@ModelAttribute Admin admin, Model model) {
		
		admin.setPassword(DigestUtils.md5DigestAsHex(admin.getPassword().getBytes()));
		Admin checkAdmin = adminService.login(admin.getUsername(), admin.getPassword());
		
		if(checkAdmin != null) {
		return "Dashboard";
		}else {

			model.addAttribute("message", "username or password incorrect !!");
			return "LoginForm";
			
		}
	}
	
	@GetMapping("/register")
	public String getRegister() {
		
		return "RegisterForm";
	}
	
	@PostMapping("/register")
	public String postRegister(@ModelAttribute Admin admin, Model model) {
		
		Admin existingUsernameCheck = adminService.isAdminExist(admin.getUsername());
		
		if(existingUsernameCheck == null) {
			
			admin.setPassword(DigestUtils.md5DigestAsHex(admin.getPassword().getBytes()));
			
			adminService.signup(admin);
			
			return "LoginForm";
		}else {
			model.addAttribute("message", "username already exists !!");
			return "RegisterForm";
		}
		
	}
	
	@GetMapping("/dashboard")
	public String getDashboard() {
		
		return "Dashboard";
	}

}
