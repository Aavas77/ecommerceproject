package com.bway.ecommerceproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.ecommerceproject.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
}
