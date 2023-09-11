package com.bway.ecommerceproject.utils;

import java.util.ArrayList;
import java.util.List;

import com.bway.ecommerceproject.model.Product;

public class GlobalData {
	public static List<Product> cart;
	static {
		cart = new ArrayList<Product>();
	}
	
}
