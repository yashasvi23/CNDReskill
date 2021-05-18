package com.infy.dto;

import com.infy.entity.ProductsOrdered;

public class ProductsOrderedDTO {
	private int buyerId;
	private int prodId;
	private String sellerId;
	private int quantity;
	public ProductsOrderedDTO() {
		super();
		
	}
	public ProductsOrderedDTO(int buyerId, int prodId, String sellerId, int quantity) {
		this();
		this.buyerId = buyerId;
		this.prodId = prodId;
		this.sellerId = sellerId;
		this.quantity = quantity;
	}
	public int getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
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
	public static ProductsOrderedDTO valueOf(ProductsOrdered productsOrdered) {
		ProductsOrderedDTO productsOrderDto=new ProductsOrderedDTO();
		//productsOrderDto.setBuyerId(productsOrdered.getBuyerId());
		//productsOrderDto.setProdId(productsOrdered.getProdId());
//		productsOrderDto.setQuantity(productsOrdered.getQuantity());
//		productsOrderDto.setSellerId(productsOrdered.getSellerId());
		return productsOrderDto;
	}
}
