package com.bway.ecommerceproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/")
	public String getHomepage() {
		
		return "Homepage";
	}
	
	@GetMapping("/admin")
	public String getUser() {
		
		return "LoginForm";
	}

}
