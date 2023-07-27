package com.bway.ecommerceproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bway.ecommerceproject.model.Product;
import com.bway.ecommerceproject.service.CategoryService;
import com.bway.ecommerceproject.service.ProductService;
import com.bway.ecommerceproject.utils.FileUtil;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService prodServ;
	
	@Autowired
	private FileUtil fileUtil;
	
	@Autowired
	private CategoryService catServ;
	
	@GetMapping("/add")
	 public String getAddProduct(Model model) {
		 model.addAttribute("categoryList", catServ.getAllCategory());
		 return "AddProductForm";
	 }
	
	@PostMapping("/add")
	public String postAddProduct(@ModelAttribute Product product, @RequestParam MultipartFile img, Model model) {
		
		if(!img.isEmpty()) {
			
			String imageName = img.getOriginalFilename();
			product.setImage(imageName);
			fileUtil.imageUpload(img);
			prodServ.addProduct(product);
			model.addAttribute("message", "Product added successfully !!");
			return "redirect:/product/add";
		}
		
		return "AddProductForm";
	}
	
	@GetMapping("/list")
	public String listProducts(Model model) {
		model.addAttribute("productList", prodServ.getAllProducts());
		return "ListProductForm";
	}
	
	@GetMapping("/view")
	public String getViewProduct(@RequestParam int id, Model model) {
		model.addAttribute("productObject", prodServ.getProductById(id));
		return "ViewProductForm";
	}
	
	@PostMapping("/view")
	public String postViewProduct() {
		
		return "redirect:/product/list";
	}
	
	@GetMapping("/delete")
	public String deleteProduct(@RequestParam int id) {
		prodServ.deleteProduct(id);
		return "ViewProductForm";
	}
	
	@GetMapping("/edit")
	public String editProduct(@RequestParam int id, Model model) {
		model.addAttribute("categoryList", catServ.getAllCategory());
		model.addAttribute("productObject", prodServ.getProductById(id));
		return "EditProductForm";
	}

	@PostMapping("/edit")
	public String postEditProduct(@ModelAttribute Product product, @RequestParam MultipartFile img, Model model) {
		
		if(!img.isEmpty()) {
			
			String imageName = img.getOriginalFilename();
			product.setImage(imageName);
			fileUtil.imageUpload(img);
			prodServ.addProduct(product);
			
			return "redirect:/product/list";
		}else {
			prodServ.addProduct(product);
			
			return "redirect:/product/list";
			
		}
	}
	
	@GetMapping("/listByCategory")
	public String viewProductByCategory(@RequestParam int id, Model model) {
		model.addAttribute("products", prodServ.getProductByCategory(id));
		return "ListProductByCategoryForm";
	}
	
}
