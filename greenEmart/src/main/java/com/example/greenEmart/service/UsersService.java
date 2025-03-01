package com.example.greenEmart.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.greenEmart.domain.User;
import com.example.greenEmart.dto.UserCreateDTO;
import com.example.greenEmart.dto.UserResponseDTO;
import com.example.greenEmart.repository.UserRepository;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
	public UserRepository userRepo;
    
	
	public UserResponseDTO addUser(UserCreateDTO userCreateDTO) {
		
		User user= new User();
		
		   user.setName(userCreateDTO.getName());
		   user.setEmail(userCreateDTO.getEmail());
		   user.setPassword(userCreateDTO.getPassword());
		   user.setRole(userCreateDTO.getRole());
		   user.setActive(true);
		   
		   User savedUserData = userRepo.save(user);
		   
		   UserResponseDTO userDTO = new UserResponseDTO();
		   
		   userDTO.setId(savedUserData.getId());
		   userDTO.setName(savedUserData.getId());
		   userDTO.setEmail(savedUserData.getEmail());
		   userDTO.setPassword(savedUserData.getPassword());
		   userDTO.setRole(savedUserData.getRole());
		   userDTO.setActive(savedUserData.isActive());
		   
		return userDTO;
	}
	
	
	public UserResponseDTO getUserByName(String name) {
		
		   User userData = userRepo.findByName(name);
		   
		   UserResponseDTO userDTO = new UserResponseDTO();
		   
		   userDTO.setId(userData.getId());
		   userDTO.setName(userData.getName());
		   userDTO.setEmail(userData.getEmail());
		   userDTO.setPassword(userData.getPassword());
		   userDTO.setRole(userData.getRole());
		   userDTO.setActive(userData.isActive());
		   
		return userDTO;
	}
	
	public UserResponseDTO getUserByEmail(String email) {
		
		User userData = userRepo.findByEmail(email);
		
		UserResponseDTO userDTO = new UserResponseDTO();
		   
		   userDTO.setId(userData.getId());
		   userDTO.setName(userData.getName());
		   userDTO.setEmail(userData.getEmail());
		   userDTO.setPassword(userData.getPassword());
		   userDTO.setRole(userData.getRole());
		   userDTO.setActive(userData.isActive());

		
		return userDTO;
	}
	
	public UserResponseDTO updateUser(UserCreateDTO user, String id) {
	 Optional<User> optionalUser= userRepo.findById(id);
	 
	 if(optionalUser.isPresent()) {
		 User user1=optionalUser.get();
		 user1.setName(user.getName());
		 user1.setEmail(user.getEmail());
		 user1.setPassword(user.getPassword());
		 user1.setRole(user.getRole());
		 
		 User userData = userRepo.save(user1);
		 
		 UserResponseDTO  userDTO = new UserResponseDTO();
		 
		 userDTO.setId(userData.getId());  
		 userDTO.setName(userData.getName());
		 userDTO.setEmail(userData.getEmail());
		 userDTO.setRole(userData.getRole());
		 
		 return userDTO;
		 
	 }
	 else {
		 throw new RuntimeException("User not found with id: " + id);
	 } 
	}
	
	public String deleteUser(String id) {
		
		Optional<User> optionalUser =userRepo.findById(id);
		
		
		userRepo.deleteById(optionalUser.get().getId());
		
		return optionalUser.get().getName()+" deleted successfully";
	}
}
