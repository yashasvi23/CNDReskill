package com.example.demo.dto;

import com.example.demo.entity.Product;

public class SubscribedProductDTO {
	private Integer ProId;
	private Integer buyerId;
	private Integer quantity;
	
	public Integer getProId() {
		return ProId;
	}
	public void setProId(Integer proId) {
		ProId = proId;
	}
	public Integer getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
