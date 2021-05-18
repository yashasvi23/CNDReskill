package com.example.demo.dto;

import java.math.BigDecimal;

public class ProductDTO {
	private Long prodid;
    private String productName;
    private BigDecimal price;
    private int stock;
    private String discription;
    private String category;
    private Long sellerId;
    private String subCategory;
    private Long productRating;
    

	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Long getSellerId() {
		return sellerId;
	}
	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	public Long getProdid() {
		return prodid;
	}
	public void setProdid(Long prodid) {
		this.prodid = prodid;
	}
	public Long getProductRating() {
		return productRating;
	}
	public void setProductRating(Long productRating) {
		this.productRating = productRating;
	}
	
}
