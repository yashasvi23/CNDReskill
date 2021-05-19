package com.infy.entity;



import java.io.Serializable;

import javax.persistence.Embeddable;



@Embeddable
public class CompositeKey implements Serializable{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
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
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((buyerId == null) ? 0 : buyerId.hashCode());
			result = prime * result + ((prodId == null) ? 0 : prodId.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			CompositeKey other = (CompositeKey) obj;
			if (buyerId == null) {
				if (other.buyerId != null)
					return false;
			} else if (!buyerId.equals(other.buyerId))
				return false;
			if (prodId == null) {
				if (other.prodId != null)
					return false;
			} else if (!prodId.equals(other.prodId))
				return false;
			return true;
		}
		
		
}



