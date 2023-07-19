package com.bway.ecommerceproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.ecommerceproject.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
