package com.sandeep.ecart.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandeep.ecart.model.Cart;
import com.sandeep.ecart.repository.CartRepository;

@Service
public class CartService {
	
	@Autowired
	private CartRepository cartRepository;
	
	public Cart addCart(Cart cart) {
		try {
			cart.setStatus("active");
			return cartRepository.save(cart);
		}
		catch(Exception px) {
			System.err.println("Exception Occured in CartService.addCart:"+px.getMessage()+"Cause:"+px.getCause());
		}
		return null;
	}
	public List<Cart> getcarts(int userId){
		try {
			return cartRepository.findAllByUserId(userId);
		}
		catch(Exception px) {
			System.err.println("Exception Occured in CartService.getCart:"+px.getMessage()+"Cause:"+px.getCause());
		}
		return Collections.emptyList();
	}
	public Cart getCart(int cartId) {
		try {
			return cartRepository.findById(cartId).get();
		}
		catch(Exception px) {
			System.err.println("Exception Occured in CartService.getCart:"+px.getMessage()+"Cause:"+px.getCause());
		}
		return null;
	}
	public boolean removeCart(int cartId) {
		try {
			cartRepository.deleteById(cartId);
			return true;
		}
		catch(Exception px) {
			System.err.println("Exception Occured in CartService.removeCart:"+px.getMessage()+"Cause:"+px.getCause());
		}
		return false;
	}

}
