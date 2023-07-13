package com.bway.ecommerceproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bway.ecommerceproject.model.Category;
import com.bway.ecommerceproject.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService catServ;
	
	@GetMapping("/add")
	public String getAddCategory() {
		
		return "AddCategoryForm";
	}

	@PostMapping("/add")
	public String postAddCategory(@ModelAttribute Category category) {
		
		catServ.addCategory(category);
		
		return "AddCategoryForm";
	}

}
