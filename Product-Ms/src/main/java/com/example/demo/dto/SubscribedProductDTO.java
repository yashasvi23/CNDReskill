package com.example.demo.dto;

import javax.persistence.EmbeddedId;

import com.example.demo.entity.CompositeKey;



public class SubscribedProductDTO {
	
	
	@EmbeddedId
	private CompositeKey id;
	
	public CompositeKey getId() {
		return id;
	}
	public void setId(CompositeKey id) {
		this.id = id;
	}
	
	private Integer quantity;
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
