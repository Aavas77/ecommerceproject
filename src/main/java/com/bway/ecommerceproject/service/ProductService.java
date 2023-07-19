package com.bway.ecommerceproject.service;

import java.util.List;

import com.bway.ecommerceproject.model.Product;

public interface ProductService {
	
	void addProduct(Product product);
	
	void deleteProduct(int id);
	
	void updateProduct(Product product);
	
	Product getProductById(int id);
	
	List<Product> getAllProducts();

}
