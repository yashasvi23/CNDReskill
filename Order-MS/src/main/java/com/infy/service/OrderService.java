package com.infy.service;

import java.util.List;

import com.infy.dto.Orderdto;
import com.infy.dto.ProductsOrderedDTO;
import com.infy.exception.OrderMsException;

public interface OrderService {

	
	public Integer placeOrder(ProductsOrderedDTO order);
	
	public List<ProductsOrderedDTO> viewOrder();
}
