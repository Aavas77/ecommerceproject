package com.bway.ecommerceproject.service;

import java.util.List;

import com.bway.ecommerceproject.model.Category;

public interface CategoryService {
	
	void addCategory(Category category);
	void deleteCategory(int id);
	void updateCategory(Category category);
	Category getCategoryById(int id);
	List<Category> getAllCategory();

}
