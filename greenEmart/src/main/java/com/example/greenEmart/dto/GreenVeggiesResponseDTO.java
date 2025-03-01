package com.example.greenEmart.dto;

import java.util.Date;

public class GreenVeggiesResponseDTO {

		private String id;
		private String name;
		private String category;
		private boolean isSeasonal;
		private double price;
		private Integer quantity;
		private long totalPrice;
		private boolean isAvailable;
		private Date createdAt;
		
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
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
		public long getTotalPrice() {
			return totalPrice;
		}
		public void setTotalPrice(long totalPrice) {
			this.totalPrice = totalPrice;
		}
		public boolean isAvailable() {
			return isAvailable;
		}
		public void setAvailable(boolean isAvailable) {
			this.isAvailable = isAvailable;
		}
		public Date getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}
		
		public GreenVeggiesResponseDTO(){
			
		}
		public GreenVeggiesResponseDTO(String id, String name, String category, boolean isSeasonal, double price,
				Integer quantity, long totalPrice, boolean isAvailable, Date createdAt) {
			//super();
			this.id = id;
			this.name = name;
			this.category = category;
			this.isSeasonal = isSeasonal;
			this.price = price;
			this.quantity = quantity;
			this.totalPrice = totalPrice;
			this.isAvailable = isAvailable;
			this.createdAt = createdAt;
		}
		
		
		

}
