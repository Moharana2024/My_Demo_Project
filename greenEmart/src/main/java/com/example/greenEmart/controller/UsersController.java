package com.example.greenEmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.greenEmart.model.User;
import com.example.greenEmart.service.UsersService;

@RestController
@RequestMapping("/userController")
public class UsersController {
	
	@Autowired
	public UsersService userService;
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	
	//get user by name
	@GetMapping("/getUserByName")
	public User getUserByName(@RequestParam("name") String name) {
		return userService.getUserByName(name);
	}
	
	//get user by email
	@GetMapping("/getUserByEmail")
	public User getUserByEmail(@RequestParam("email") String email) {
		 //System.out.println("Fetching user by email: " + email);
		return userService.getUserByEmail(email);
	}
	
	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	@DeleteMapping("/deleteUser")
	public String deleteUser(@RequestBody User user) {
		return userService.deleteUser(user);
	}

}
