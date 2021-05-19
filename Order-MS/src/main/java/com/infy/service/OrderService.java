package com.infy.service;

import com.infy.dto.ProductsOrderedDTO;
import com.infy.exception.OrderMSException;

public interface OrderService {
	
	public String placeOrder(ProductsOrderedDTO productsOrderedDTO) throws OrderMSException;

}
