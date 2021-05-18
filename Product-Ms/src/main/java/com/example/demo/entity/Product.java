package com.example.demo.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
@Entity
public class Product {
	 	@Id
	    @GeneratedValue (strategy = GenerationType.IDENTITY)
	    private Long Proid;
	    private String productName;
	    private BigDecimal price;
	    private int stock;
	    private String discription;
	    private Long sellerId;
	    private String category;
	    private String subCategory;
	    private Long ProductRating;
	    
	    
		public Long getProid() {
			return Proid;
		}
		public void setProid(Long proid) {
			Proid = proid;
		}
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
		public Long getSellerId() {
			return sellerId;
		}
		public void setSellerId(Long sellerId) {
			this.sellerId = sellerId;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getSubCategory() {
			return subCategory;
		}
		public void setSubCategory(String subCategory) {
			this.subCategory = subCategory;
		}
		public Long getProductRating() {
			return ProductRating;
		}
		public void setProductRating(Long productRating) {
			ProductRating = productRating;
		}
	    
}
	    


