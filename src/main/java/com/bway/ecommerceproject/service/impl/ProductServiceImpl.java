package com.bway.ecommerceproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bway.ecommerceproject.model.Product;
import com.bway.ecommerceproject.repository.ProductRepository;
import com.bway.ecommerceproject.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository prodRepo;

	@Override
	public void addProduct(Product product) {
		
		prodRepo.save(product);
	}

	@Override
	public void deleteProduct(int id) {
		
		prodRepo.deleteById(id);
	}

	@Override
	public void updateProduct(Product product) {
		
		prodRepo.save(product);
	}

	@Override
	public Product getProductById(int id) {
		
		return prodRepo.findById(id).get();
	}

	@Override
	public List<Product> getAllProducts() {
		
		return prodRepo.findAll();
	}

	@Override
	public List<Product> getProductByCategory(int id) {
		
		return prodRepo.findByCategory_Id(id);
	}

}
