package com.sandeep.ecart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandeep.ecart.GenericResponse;
import com.sandeep.ecart.model.Cart;
import com.sandeep.ecart.service.CartService;

@RestController
@RequestMapping("cart")
@CrossOrigin("http://localhost:4200")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/add")
	public GenericResponse<Cart> addCart(@RequestBody Cart cart){
		Cart response = cartService.addCart(cart);
		if(response!=null) {
			return GenericResponse.<Cart>builder().success(true).data(response).message("").build();
		}
		else {
			return GenericResponse.<Cart>builder().success(false).data(null).message("Cart Not Add..").build();
		}
	}
	@GetMapping("/by-ref-id/{userId}")
	public GenericResponse<List<Cart>> getCarts(@PathVariable("userId") int userId){
		List<Cart> response = cartService.getcarts(userId);
		if(!response.isEmpty()) {
			return GenericResponse.<List<Cart>>builder().success(true).data(response).message("").build();
		}
		else {
			return GenericResponse.<List<Cart>>builder().success(false).data(null).message("No Record Found").build();
		}
	}
	@GetMapping("/by-Id/{cartId}")
	public GenericResponse<Cart> getCart(@PathVariable("cartId") int cartId){	
		Cart response=cartService.getCart(cartId);
		if(response!=null) {
			return GenericResponse.<Cart>builder().success(true).data(response).message("").build();
		}
		else {
			return GenericResponse.<Cart>builder().success(false).data(null).message("Cart Not found").build();
		}
	}
	@GetMapping("/remove/{cartId}")
	public GenericResponse<Boolean> removeCart(@PathVariable("cartId") int cartId){
		if(cartService.removeCart(cartId)) {
			return GenericResponse.<Boolean>builder().success(true).data(true).message("Data Deleted SuccessFully..!").build();
		}
		else {
			return GenericResponse.<Boolean>builder().success(false).data(false).message("Not Deleted Try Again!").build();
		}
	}
}
