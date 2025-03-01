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

import com.example.greenEmart.domain.User;
import com.example.greenEmart.dto.UserCreateDTO;
import com.example.greenEmart.dto.UserResponseDTO;
import com.example.greenEmart.service.UsersService;

@RestController
@RequestMapping("/userController")
public class UsersController {
	
	@Autowired
	public UsersService userService;
	
	@PostMapping("/addUser")
	public UserResponseDTO addUser(@RequestBody UserCreateDTO user) {
			return userService.addUser(user);
	}
	
	
	//get user by name
	@GetMapping("/getUserByName")
	public UserResponseDTO getUserByName(@RequestParam("name") String name) {
		return userService.getUserByName(name);
	}
	
	//get user by email
	@GetMapping("/getUserByEmail")
	public UserResponseDTO getUserByEmail(@RequestParam("email") String email) {
		 //System.out.println("Fetching user by email: " + email);
		return userService.getUserByEmail(email);
	}
	
	@PutMapping("/updateUser")
	public UserResponseDTO updateUser(@RequestBody UserCreateDTO user, @RequestParam("id") String id) {
		return userService.updateUser(user, id);
	}
	
	@DeleteMapping("/deleteUser")
	public String deleteUser(@RequestParam("id") String id) {
		return userService.deleteUser(id);
	}

}
