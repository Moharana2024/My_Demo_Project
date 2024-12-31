package com.example.greenEmart.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.greenEmart.model.GreenVeggies;

public interface VegetableRepository extends MongoRepository<GreenVeggies, String>{

	List<GreenVeggies> findByCategory(String category);
}
