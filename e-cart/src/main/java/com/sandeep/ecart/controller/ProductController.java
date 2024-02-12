package com.sandeep.ecart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sandeep.ecart.model.Products;
import com.sandeep.ecart.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	@PostMapping("/add-product")
	
	public Products addProduct(@RequestBody Products products) {
		return productService.addProduct(products);
	}
	@GetMapping("/remove-product/{productId}")
	public String removeProduct(@PathVariable("productId")int productId) {
		if(productService.removeProduct(productId)) {
			return "Success";
		}
		else {
			return "Unsuccess";
		}
	}
	@GetMapping("/products")
	public List<Products> getProducts(){
		return productService.getProducts();
	}
	@GetMapping("/products/{productId}")
	public Products getProduct(@PathVariable("productId") int productId) {
		return productService.getProduct(productId);
	}
	@GetMapping("/products-by-cat/{subcatId}")
	public List<Products> getProductsBySubCat(@PathVariable("SubcatId") int SubcatId){
		return productService.getProductsBySubCat(SubcatId);
	}
}
	
