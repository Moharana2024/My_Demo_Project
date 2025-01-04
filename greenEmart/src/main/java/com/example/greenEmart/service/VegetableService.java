package com.example.greenEmart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.greenEmart.domain.GreenVeggies;
import com.example.greenEmart.repository.VegetableRepository;

@Service
public class VegetableService {
	

	@Autowired
	public VegetableRepository vegRepo;
	
	public void toCheckAvailability() {
		
	}

	
	public void calculateTotalPrice(GreenVeggies veggies) {
		if(veggies.getQuantitty()!=null && veggies.getPrice()>0) {
			veggies.setTotalPrice(Math.round(veggies.getQuantitty()*veggies.getPrice()));
		}
		else {
			veggies.setTotalPrice(0);
		}
	}

	public GreenVeggies addVegetable(GreenVeggies vegetable) {
	    calculateTotalPrice(vegetable); 
	    return vegRepo.save(vegetable); 
	}

	
	public List<GreenVeggies> getAllVegetable(){
		return vegRepo.findAll();
	}
	
	public List<GreenVeggies> getVegetableByName(String name) {
		return vegRepo.findByName(name);
	}
	
	public String updateVegetable(GreenVeggies vegetable){
		Optional<GreenVeggies> optionalVegetable=vegRepo.findById(vegetable.getId());
		
		if(optionalVegetable.isPresent()) {
			GreenVeggies veggie= optionalVegetable.get();
			veggie.setName(vegetable.getName());
			
			 vegRepo.save(veggie);
			 return "Vegetable updated successfully!";
		}else {
			
			throw new RuntimeException("Vegetable not found with id: " + vegetable.getId());
		}	
	}
	
	public List<GreenVeggies> getVeggiesByCategory(String category) {
		
		return vegRepo.findByCategory(category);	
	}
	
	
	
	
	
}
