package com.sandeep.ecart.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandeep.ecart.model.Orders;
import com.sandeep.ecart.repository.OrdersRepository;

@Service
public class OrdersService {

	@Autowired
	private OrdersRepository ordersRepository;
	
	public Orders addOrder(Orders order) {
		try {
			
			ordersRepository.save(order);
		}
		catch(Exception px) {
			System.err.println("Exception Occured In addOrder :"+px.getMessage()+"Cause :"+px.getCause());
		}
		return null;
	}
	public boolean cancelOrder(int orderId) {
		try {
			if(ordersRepository.cancelOrder(orderId)>0) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception px) {
			System.err.println("Exception Occured In cancelOrder :"+px.getMessage()+"Cause :"+px.getCause());
		}
		return false;
	}
	public List<Orders> getOrders(){
		try {
		return ordersRepository.findAll();
		}
		catch(Exception px) {
			System.err.println("Exception Occured In getOrders: "+px.getMessage()+"Cause: "+px.getCause());
		}
		return null;
	}
	public Orders getOrders(int orderId) {
		try {
			if(orderId!=0) {
			   return ordersRepository.findById(orderId).get();
		     }
		}
		catch(Exception px){
			System.err.println("Exception Occured In getOrders :"+px.getMessage()+"Cause :"+px.getCause());
		}
		return null;
			}
			
	}
