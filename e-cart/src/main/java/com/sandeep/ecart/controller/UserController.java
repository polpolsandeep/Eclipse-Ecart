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
import com.sandeep.ecart.model.User;
import com.sandeep.ecart.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:4200")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/add-user")
	public User addUser(@RequestBody User user) {
		User u =userService.addUser(user);
		if(u!=null) {
			return u;
		}
		else {
		  return null;	
		}
	}
	@PostMapping("login")
	public GenericResponse<User> login(@RequestBody User user) {
		User userRes =userService.login(user.getEmail(),user.getPassword());
		if(userRes!=null) {
			return GenericResponse.<User>builder().data(userRes).success(true).message("Login Success-Fully").build();
		}
		else {
			return GenericResponse.<User>builder().data(null).success(false).message("Username & Password Is Incorrect").build();
		}
	}
	@GetMapping("/users")
	public List<User> getUsers(){
		return userService.getUser();
	}
	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable("userId") int userId) {
		return userService.getUser(userId);
	}
}
