package com.sandeep.ecart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandeep.ecart.model.User;
import com.sandeep.ecart.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User addUser(User user) {
		try {
			return userRepository.save(user);
		}
		catch(Exception px) {
			System.err.println("Exception Occured In addUser :"+px.getMessage()+"Cause :"+px.getCause());
		}
		return null;
	}
	public User login(String username,String password) {
		try {
		return userRepository.login(username,password);
		}
		catch(Exception px) {
			System.err.println("Exception Occured In login"+px.getMessage()+"Cause:"+px.getCause());
		}
		return null;
	}
	public List<User> getUser(){
		try {
			userRepository.findAll();
		}
		catch(Exception px) {
			System.err.println("Exception Occured In getUser :"+px.getMessage()+"Cause :"+px.getCause());
		}
		return null;
	}
	public User getUser(int userId) {
		try {
			return userRepository.findById(userId).get();
		}
		catch(Exception px){
			System.err.println("Exception Occured In getUser :"+px.getMessage()+"Cause :"+px.getCause());
	    }
		return null;
	}
}
	
