package com.sandeep.ecart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sandeep.ecart.model.Orders;
import com.sandeep.ecart.service.OrdersService;

@RestController
public class OrdersController {
	
	@Autowired
	private OrdersService orderService;
	
	@PostMapping("/add-order")
	public Orders add(@RequestBody Orders order) {
		Orders orderRes = orderService.addOrder(order);
		if(orderRes!=null) {
			return orderRes;
		}
		else {
			return null;
		}
	}
	@GetMapping("cancel-order/{orderId}")
	public boolean cancelOrder(@PathVariable("orderId") int orderId) {
		return orderService.cancelOrder(orderId);
	}
	@GetMapping("/orders")
	public List<Orders> getOrders(){
		return orderService.getOrders();
	}
	@GetMapping("/order/{orderId}")
	public Orders getOrder(@PathVariable("orderId") int orderId) {
		return orderService.getOrders(orderId);
	}

}
