package com.bway.ecommerceproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bway.ecommerceproject.model.User;
import com.bway.ecommerceproject.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String getUserLogin() {
		
		return "UserLoginForm";
	}
	
	@PostMapping("/login")
	public String postUserLogin(@ModelAttribute User user, Model model) {
		
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		User checkUser = userService.login(user.getUsername(), user.getPassword());
		
		if(checkUser != null) {
			
			return "Homepage";
		}else {
			model.addAttribute("message", "user does not exist!!!");
			return "redirect:/user/login";
		}
		
	}

}
