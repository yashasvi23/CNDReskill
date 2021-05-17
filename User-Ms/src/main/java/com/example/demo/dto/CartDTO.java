package com.example.demo.dto;

import com.example.demo.entity.Buyer;

public class CartDTO {
	private Buyer buyerId;
	private Integer quantity;
	public Buyer getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Buyer buyerId) {
		this.buyerId = buyerId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
