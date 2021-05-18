package com.infy.entity;



import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.Table;

@Entity
@Table(name="productsordered")
public class ProductsOrdered {
	
	@EmbeddedId
	private CompositeKey id;
  
    public CompositeKey getId() {
		return id;
	}
	public void setId(CompositeKey id) {
		this.id = id;
	}
	private String sellerId;
    
    private int quantity;
	
	
	
	
	
	
	
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
    

}
