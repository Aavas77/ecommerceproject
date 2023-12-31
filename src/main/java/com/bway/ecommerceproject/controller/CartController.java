package com.bway.ecommerceproject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bway.ecommerceproject.model.Cart;
import com.bway.ecommerceproject.model.Product;
import com.bway.ecommerceproject.service.CartService;
import com.bway.ecommerceproject.service.ProductService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private  ProductService productService;
	
	@Autowired
	private CartService cartServ;
	
	@PostMapping("/add")
	public String addToCart(@RequestParam int productId, Model model) {
		
		Product product = productService.getProductById(productId);
		
		if (product != null) {
			Cart cart = new Cart();
			cart.setProduct(product);
			cartServ.addItemToCart(cart);
			
        } else {
            model.addAttribute("error", "Product not found.");
        }
		
        model.addAttribute("message", "Item added to cart successfully");
        return "redirect:/shop/shopsingle/" + productId; // Redirect back to the product detail page
    }
	
	@GetMapping("/view")
	public String viewCart(Model model, HttpSession session) {
		
		int total = 0;
		for(Cart cart : cartServ.getAllCartItems()) {
			total = total + cart.getProduct().getPrice();
		}
		model.addAttribute("cartItems", cartServ.getAllCartItems());
		session.setAttribute("total", total);
		return "UserCart";
	}
	
	@GetMapping("/delete")
	public String deleteProductFromCart(@RequestParam int id) {
		cartServ.deleteItemFromCart(id);
		return "redirect:/cart/view";
	}
	
	@GetMapping("/checkout")
	public String userCheckOut() {
		return "UserCheckOut";
	}
	
}


