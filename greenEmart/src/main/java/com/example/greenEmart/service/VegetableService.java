package com.example.greenEmart.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.greenEmart.domain.GreenVeggies;
import com.example.greenEmart.dto.GreenVeggiesCreateDTO;
import com.example.greenEmart.dto.GreenVeggiesResponseDTO;
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

	/**
	 * 
	 * @param vegetable
	 * @return
	 */
	public GreenVeggiesResponseDTO addVegetable(GreenVeggiesCreateDTO vegetable) {
		
		//Creating Domain object
		GreenVeggies greenVeg= new GreenVeggies();
		
		//adding dto data to domain for saving into DB
		greenVeg.setName(vegetable.getName());
		greenVeg.setCategory(vegetable.getCategory());    
		greenVeg.setPrice(vegetable.getPrice()); 
		greenVeg.setQuantitty(vegetable.getQuantity()); 
		greenVeg.setSeasonal(vegetable.isSeasonal()); 
		greenVeg.setAvailable(vegetable.getQuantity()>0?true:false); 
		
		Date local = new Date();
		 greenVeg.setCreatedAt(local);
		
	    calculateTotalPrice(greenVeg); 
	    
	    //Saving Domain Data to DB.
	    GreenVeggies addedData= vegRepo.save(greenVeg); 
	    
	    //Creating ResponseDTO object
	    GreenVeggiesResponseDTO savedVegetable = new GreenVeggiesResponseDTO();
	    
	   
	    
	    //Adding Domain data to ResponseDto object for sending Response.
	    savedVegetable.setId(addedData.getId());
	    savedVegetable.setName(addedData.getName());
	    savedVegetable.setCategory(addedData.getCategory());
	    savedVegetable.setPrice(addedData.getPrice());
	    savedVegetable.setQuantity(addedData.getQuantitty());
	    savedVegetable.setSeasonal(addedData.isSeasonal());
	    savedVegetable.setCreatedAt(addedData.getCreatedAt());
	    savedVegetable.setTotalPrice(addedData.getTotalPrice());  
	    savedVegetable.setAvailable(addedData.isAvailable());             
	    
	    return savedVegetable;
	}

	
	public List<GreenVeggies> getAllVegetable(){
		return vegRepo.findAll();
	}
	
	public List<GreenVeggies> getVegetableByName(String name) {
		return vegRepo.findByName(name);
	}
	//update vegetable....
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
	
	
	
	public List<GreenVeggiesResponseDTO> getVeggiesByCategory(String category) {		
		
		List<GreenVeggies> CategoryData=vegRepo.findByCategory(category);
		
		GreenVeggiesResponseDTO savedVegetable = new GreenVeggiesResponseDTO();
 
		List<GreenVeggiesResponseDTO> list = new ArrayList<>();
		
		for(GreenVeggies i: CategoryData) {
			savedVegetable.setId(i.getId());
			savedVegetable.setName(i.getName());
			savedVegetable.setCategory(i.getCategory());
			savedVegetable.setSeasonal(i.isSeasonal());
			savedVegetable.setPrice(i.getPrice());
			savedVegetable.setQuantity(i.getQuantitty());
			savedVegetable.setTotalPrice(i.getTotalPrice());
			savedVegetable.setAvailable(i.isAvailable());
			savedVegetable.setCreatedAt(i.getCreatedAt());
			
			list.add(savedVegetable);
		}
		           
		return list;
		       	
	}
	
	
	
}
