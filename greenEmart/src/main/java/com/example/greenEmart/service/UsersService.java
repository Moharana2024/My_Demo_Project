package com.example.greenEmart.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.greenEmart.domain.User;
import com.example.greenEmart.repository.UserRepository;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
	public UserRepository userRepo;
	
	public User addUser(User user) {
		return userRepo.save(user);
	}
	
	
	public User getUserByName(String name) {
		return userRepo.findByName(name);
	}
	
	public User getUserByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	
	public User updateUser(User user) {
	 Optional<User> optionalUser= userRepo.findById(user.getId());
	 
	 if(optionalUser.isPresent()) {
		 User user1=optionalUser.get();
		 user1.setName(user.getName());
		 user1.setEmail(user.getEmail());
		 user1.setPassword(user.getPassword());
		 user1.setRole(user.getRole());
		 
		 
		 return userRepo.save(user1);
		 
	 }
	 else {
		 throw new RuntimeException("User not found with id: " + user.getId());
	 } 
	}
	
	public String deleteUser(User user) {
		User optionalUser =userRepo.findByName(user.getName());
		userRepo.delete(optionalUser);
		
		return user.getName()+" deleted successfully";
	}
}
