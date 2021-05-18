package com.example.demo.dto;



public class WishlistDTO {
	private Integer buyerId;
	private Integer prodId;
	public Integer getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}
	public Integer getProdId() {
		return prodId;
	}
	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}
	@Override
	public String toString() {
		return "WishlistDTO [buyerId=" + buyerId + ", prodId=" + prodId + "]";
	}
	
	
 
}
