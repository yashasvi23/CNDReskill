package com.infy.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.Table;



@Entity
@Table(name="productsordered")

public class ProductsOrdered {
	
	@EmbeddedId
	private CompositeKey id;
	
	private Integer sellerId;
	
	private Integer quantity;

	

	public CompositeKey getId() {
		return id;
	}

	public void setId(CompositeKey id) {
		this.id = id;
	}

	public Integer getSellerId() {
		return sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
