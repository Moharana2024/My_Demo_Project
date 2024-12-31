package com.example.greenEmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.greenEmart.model.GreenVeggies;
import com.example.greenEmart.repository.VegetableRepository;
import com.example.greenEmart.service.VegetableService;

@RestController
@RequestMapping("/vegController")
public class VegetableController {
	
	@Autowired
	public VegetableService vegService;
	
	@PostMapping("/addVeg")
	public GreenVeggies addVegetable(@RequestBody GreenVeggies vegetable) {
		return vegService.addVegetable(vegetable);
	}
	
	@GetMapping("/getAllVegetable")
	public List<GreenVeggies> getAllVegetable(){
		return vegService.getAllVegetable();
	}
	
	@GetMapping("/getVegetableByName")
	public GreenVeggies getVegetableByName(@RequestParam("id") String id) {
		return vegService.getVegetableByName(id);
	}
	
	@PutMapping("/updateVegetable")
	public String updateVegetable(@RequestBody GreenVeggies vegetable) {
		return vegService.updateVegetable(vegetable);
	}
	
	@GetMapping("/getVeggiesByCategory")
	public List<GreenVeggies> getVeggiesByCategory(@RequestParam("category") String category) {
		return vegService.getVeggiesByCategory(category);
	}
	
	
	
}
