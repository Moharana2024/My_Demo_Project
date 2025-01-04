package com.example.greenEmart.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.greenEmart.domain.GreenVeggies;
import com.example.greenEmart.domain.User;


@Repository
public interface UserRepository extends MongoRepository<User, String>{
	
	 User findByName(String name);
	 
	 User findByEmail(String email);

}
