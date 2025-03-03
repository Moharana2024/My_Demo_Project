package com.example.greenEmart.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.greenEmart.domain.User;
import com.example.greenEmart.dto.UserCreateDTO;
import com.example.greenEmart.dto.UserResponseDTO;
import com.example.greenEmart.repository.UserRepository;

import exception.UserException;

import java.util.Optional;

@Service
public class UsersService {

    @Autowired
	public UserRepository userRepo;
    
	
	public Object addUser(UserCreateDTO userCreateDTO) throws UserException{
		
		// Check if user already exist by matching email. if present then raise an custom exception saying 
		// user already exist.
		
			try {
					User userDetails=userRepo.findByEmail(userCreateDTO.getEmail());
					
					if(userDetails!=null) {
						
						throw new UserException("user already exist");
						
					}else {
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
						   		   
						return userDTO;
					}
				   	}catch(UserException e) {
				   		 return userCreateDTO.getEmail()+" is already exist";
			}
	}
	
	
	public Object getUserByName(String name) throws UserException{
		
		// As we are implementing soft delete, after fetching user details, check if user deleted or not. If deleted raise
		// Custom exception saying user not available.
		try {
			   User userData = userRepo.findByName(name);
			   
			   if(userData.getActive()) {
				   UserResponseDTO userDTO = new UserResponseDTO();
				   
				   userDTO.setId(userData.getId());
				   userDTO.setName(userData.getName());
				   userDTO.setEmail(userData.getEmail());
				   userDTO.setPassword(userData.getPassword());
				   userDTO.setRole(userData.getRole());
				   
				   
				return userDTO;
			   }
			   else {
				  
				 throw new UserException("user is not exist");
			   }
			   
			   
		}catch(UserException e) {
			return name+" user is not exist";
		}	
		
	}
	
	public Object getUserByEmail(String email) throws UserException{
		
		// As we are implementing soft delete, after fetching user details, check if user deleted or not. If deleted raise
		// Custom exception saying user not available.
		try {
			User userData = userRepo.findByEmail(email);
			
			if(userData.getActive()) {
				UserResponseDTO userDTO = new UserResponseDTO();
				   
				   userDTO.setId(userData.getId());
				   userDTO.setName(userData.getName());
				   userDTO.setEmail(userData.getEmail());
				   userDTO.setPassword(userData.getPassword());
				   userDTO.setRole(userData.getRole());
				   
		
				
				return userDTO;
			}
			else {
				throw new UserException("user is not exist");
			}
			
		}catch(UserException e) {
			return email+" user is not exist";
		}
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
	
	public String deleteUser(String id) throws UserException{
		
		// Check for user existance then delete if not available then send proper message.
		// Implement soft delete.
		try {
			User user =userRepo.findById(id).get();
			
			if(user != null && user.getActive()) {
						
				user.setActive(false);
				userRepo.save(user);
				return user.getName()+" deleted successfully";
				
				
			 }else {
				throw new UserException("This user is not available"+ user.getId());
			}
		} catch(UserException e) {
			return id + " is not present";
		}
		
		
//		userRepo.deleteById(optionalUser.get().getId());
		
		
	}
}
