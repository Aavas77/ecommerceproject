package com.bway.ecommerceproject.controller;

import javax.servlet.http.HttpSession;

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
	public String postUserLogin(@ModelAttribute User user, Model model, HttpSession session) {
		
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		User checkUser = userService.login(user.getUsername(), user.getPassword());
		
		if(checkUser != null) {
			session.setAttribute("loggedIn", checkUser);
			return "Homepage";
		}else {
			model.addAttribute("message", "username or password incorrect !!");
			return "UserLoginForm";
		}
		
	}
	
	@GetMapping("/signup")
	public String getSignUp() {
		
		return "UserSignUpForm";
	}
	
	@PostMapping("/signup")
	public String postSignUp(@ModelAttribute User user, Model model) {
		User checkUser = userService.isUserExist(user.getUsername());
		if(checkUser == null) {
			user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
			userService.signup(user);
			return "redirect:/user/login";
		}else {
			model.addAttribute("message", "username already exists !!");
			return "UserSignUpForm";
		}
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/user/login";
	}

}
