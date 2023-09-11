package com.bway.ecommerceproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bway.ecommerceproject.service.CategoryService;
import com.bway.ecommerceproject.service.ProductService;

@Controller
@RequestMapping("/shop")
public class ShopController {
	
	@Autowired
	private CategoryService catServ;
	
	@Autowired
	private ProductService prodServ;
	
	@GetMapping("/view")
	public String viewShop(Model model) {
		model.addAttribute("categoryList", catServ.getAllCategory());
		model.addAttribute("products", prodServ.getAllProducts());
		
		return "Shop";
	}
	
	@GetMapping("/about")
	public String about() {
		
		return "About";
	}
	
	@GetMapping("/contact")
	public String contact() {
		
		return "Contact";
	}
	
	@GetMapping("/category/{id}")
	public String shopByCategory(@PathVariable int id, Model model) {
		model.addAttribute("categoryList", catServ.getAllCategory());
		model.addAttribute("products", prodServ.getProductByCategory(id));
		return "Shop";
	}
	
	@GetMapping("/shopsingle/{id}")
	public String shopSingleItem(@PathVariable int id, Model model) {
		model.addAttribute("product", prodServ.getProductById(id));
		return "ShopSingle";
	}

}
