package com.bway.ecommerceproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/list")
	public String getCategoryList(Model model) {
		
		model.addAttribute("catList", catServ.getAllCategory());
		
		return "ListCategory";
	}
	
	@GetMapping("/delete")
	public String getDelete(@RequestParam int id) {
		
		catServ.deleteCategory(id);
		
		return "redirect:/category/list";
	}
	
	@GetMapping("/edit")
	public String editCategory(@RequestParam int id, Model model) {
		model.addAttribute("categoryObject", catServ.getCategoryById(id));
		return "EditCategoryForm";
	}
	
	@PostMapping("/update")
	public String updateCategory(@ModelAttribute Category category) {
		catServ.updateCategory(category);
		return "redirect:/category/list";
	}

}
