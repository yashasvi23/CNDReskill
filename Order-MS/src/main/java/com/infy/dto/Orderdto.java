package com.infy.dto;

import java.time.LocalDate;

import com.infy.entity.Orders;

public class Orderdto {
	private Integer orderId;
	private Integer buyerId;
	private float amount;
	private LocalDate date;
	private String address;
	private String status;
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public static Orderdto valueOf(Orders orders) {
		Orderdto orderdto=new Orderdto();
		orderdto.setAddress(orders.getAddress());
		orderdto.setAmount(orders.getAmount());
		orderdto.setBuyerId(orders.getBuyerId());
		orderdto.setDate(orders.getDate());
		orderdto.setOrderId(orders.getOrderId());
		orderdto.setStatus(orders.getStatus());
		return orderdto;
	}
}
