package com.bway.ecommerceproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bway.ecommerceproject.model.Category;
import com.bway.ecommerceproject.repository.CategoryRepository;
import com.bway.ecommerceproject.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository catRepo;

	@Override
	public void addCategory(Category category) {
		
		catRepo.save(category);
	}

	@Override
	public void deleteCategory(int id) {
		
		catRepo.deleteById(id);
	}

	@Override
	public void updateCategory(Category category) {
		
		catRepo.save(category);
	}

	@Override
	public Category getCategoryById(int id) {
		
		return catRepo.findById(id).get();
	}

	@Override
	public List<Category> getAllCategory() {
		
		return catRepo.findAll();
	}

}
