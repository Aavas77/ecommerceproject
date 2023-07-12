package com.bway.ecommerceproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="category_tbl")
public class Category {
	@Id
	@GeneratedValue
	private int id;
	private String category;
}
