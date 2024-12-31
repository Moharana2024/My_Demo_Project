package com.example.greenEmart.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.greenEmart.model.GreenVeggies;
import com.example.greenEmart.model.User;


@Repository
public interface UserRepository extends MongoRepository<User, String>{
	
	 User findByUsername(String username);
	 
	 User findByEmail(String email);

}
