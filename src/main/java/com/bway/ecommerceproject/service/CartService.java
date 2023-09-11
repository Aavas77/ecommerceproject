package com.bway.ecommerceproject.service;

import java.util.List;

import com.bway.ecommerceproject.model.Cart;

public interface CartService {
	
	void addItemToCart(Cart cartItem);
	
	void deleteItemFromCart(int cartItemId);
	
	List<Cart> getAllCartItems();
	
}
