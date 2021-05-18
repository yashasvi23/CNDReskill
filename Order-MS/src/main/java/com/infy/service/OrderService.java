package com.infy.service;

import java.util.List;

import com.infy.dto.Orderdto;
import com.infy.dto.ProductsOrderedDTO;
import com.infy.exception.OrderMsException;

public interface OrderService {
public void addProduct(Orderdto order) throws OrderMsException;
	
	public void removeProduct(Orderdto order);
	
	public void placeOrder(Orderdto order);
	
	public List<ProductsOrderedDTO> viewOrder();
}
