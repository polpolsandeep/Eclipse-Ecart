package com.sandeep.ecart.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="cart_id")
   private int cartId;
   
   @Column(name="prod_id")
   private int productId;
   
   @Column(name="user_id")
   private int userId;
   
   @Column(name="status")
   private String status;

public int getCartId() {
	return cartId;
}

public void setCartId(int cartId) {
	this.cartId = cartId;
}

public int getProductId() {
	return productId;
}

public void setProductId(int productId) {
	this.productId = productId;
}

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}
   
   
   
}
