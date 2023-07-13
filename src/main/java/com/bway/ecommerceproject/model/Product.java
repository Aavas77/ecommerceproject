//package com.bway.ecommerceproject.model;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//import lombok.Data;
//
//@Data
//@Entity
//@Table(name="product_tbl")
//public class Product {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
//	@OneToOne
//	@JoinColumn(name = "categoryId")
//	private Category category;
//	private String company;
//	private String name;
//	@Column(columnDefinition = "text")
//	private String description;
//	private String price;
//	private String image;
//	
//
//}
