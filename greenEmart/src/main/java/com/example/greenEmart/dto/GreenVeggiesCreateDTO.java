package com.example.greenEmart.dto;

import java.util.Date;

public class GreenVeggiesCreateDTO {
	private String name;
	private String category;
	private boolean isSeasonal;
	private double price;
	private Integer quantity;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public boolean isSeasonal() {
		return isSeasonal;
	}
	public void setSeasonal(boolean isSeasonal) {
		this.isSeasonal = isSeasonal;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}	
	
	
}
