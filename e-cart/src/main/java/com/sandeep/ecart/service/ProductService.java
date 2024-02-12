package com.sandeep.ecart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandeep.ecart.model.Products;
import com.sandeep.ecart.repository.ProductsRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductsRepository productRepository;
	
	public Products addProduct(Products products) {  /*For Insert and Update*/
		try {
		    return productRepository.save(products);
		}
		catch(Exception ex) {
			System.err.println("Exception Occured In addProduct :"+ex.getMessage()+"Cause"+ex.getCause());
		}
		return null;
	}
	public boolean removeProduct(int productId) {
		try {
			productRepository.deleteById(productId);
			return true;
		}
		catch(Exception ex) {
			System.err.println("Exception Occurred In removeProduct :"+ex.getMessage()+"Cause"+ex.getCause());
		}
		return false;
	}
	public List<Products> getProducts(){
		try {
			productRepository.findAll();
		}
		catch(Exception ex) {
			System.err.println("Exception Occurred In getProducts :"+ex.getMessage()+"Cause"+ex.getCause());
		}
		return null;
	}
	public Products getProduct(int productId) {
		try {
			return productRepository.findById(productId).get();
		}
		catch(Exception ex) {
			System.err.println("Exception Occured In getProduct :"+ex.getMessage()+"Cause"+ex.getCause());
		}
		return null;
	}
	public List<Products> getProductsBySubCat(int subCatId){
		return productRepository.findBySubCatId(subCatId);
	}

}
