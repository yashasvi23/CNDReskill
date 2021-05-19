package com.infy.dto;

public class ProductsOrderedDTO {
	private Integer buyerId;
	private Integer prodid;
	private Integer sellerId;
	private Integer quantity;
	@Override
	public String toString() {
		return "ProductsOrderedDTO [buyerId=" + buyerId + ", prodid=" + prodid + ", sellerId=" + sellerId
				+ ", quantity=" + quantity + "]";
	}
	public Integer getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}
	public Integer getProdid() {
		return prodid;
	}
	public void setProdid(Integer prodid) {
		this.prodid = prodid;
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
