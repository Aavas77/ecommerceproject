package com.bway.ecommerceproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bway.ecommerceproject.model.Cart;
import com.bway.ecommerceproject.repository.CartRepository;
import com.bway.ecommerceproject.service.CartService;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepository cartRepo;

	@Override
	public void addItemToCart(Cart cartItem) {
		
		cartRepo.save(cartItem);
	}

	@Override
	public void deleteItemFromCart(int cartItemId) {

		cartRepo.deleteById(cartItemId);
		
	}

	@Override
	public List<Cart> getAllCartItems() {
		
		return cartRepo.findAll();
	}

}
