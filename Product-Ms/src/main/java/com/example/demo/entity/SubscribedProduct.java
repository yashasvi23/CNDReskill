package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

public class SubscribedProduct {
	@Table
	public class Cart {
		@OneToOne(cascade=CascadeType.ALL)
		@JoinColumn(name="buyer_id")
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

}
