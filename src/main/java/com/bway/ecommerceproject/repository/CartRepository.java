package com.bway.ecommerceproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.ecommerceproject.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{

}
