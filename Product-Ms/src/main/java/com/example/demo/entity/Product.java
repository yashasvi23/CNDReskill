package com.example.demo.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="product")
public class Product {
	 	@Id
	    @GeneratedValue (strategy = GenerationType.IDENTITY)
	    private Integer prodId;
	    private String productName;
	    private Integer price;
	    private Integer stock;
	    private String discription;
	    private Integer sellerId;
	    private String category;
	    private String subCategory;
	    private Integer productRating;
	    
	    
		
		
		
		public Integer getProdId() {
			return prodId;
		}
		public void setProdId(Integer prodId) {
			this.prodId = prodId;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		
		
		
		
		public Integer getPrice() {
			return price;
		}
		public void setPrice(Integer price) {
			this.price = price;
		}
		public Integer getStock() {
			return stock;
		}
		public void setStock(Integer stock) {
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
		public String getSubCategory() {
			return subCategory;
		}
		public void setSubCategory(String subCategory) {
			this.subCategory = subCategory;
		}
		public Integer getSellerId() {
			return sellerId;
		}
		public void setSellerId(Integer sellerId) {
			this.sellerId = sellerId;
		}
		public Integer getProductRating() {
			return productRating;
		}
		public void setProductRating(Integer productRating) {
			this.productRating = productRating;
		}
		
		
}
	    


