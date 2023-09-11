package com.bway.ecommerceproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="cart_item")
public class Cart{
	@Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY) 
	  private int id;
	  
	  @ManyToOne
	  private Product product;

//	  public Cart(int quantity, Product product) {
//		super();
//		this.quantity = quantity;
//		this.product = product;
//	  }	   
//	   
//	  public Cart() {
//		super();
//	  }
	

}
