package com.infy.service;

import java.util.List;



import com.infy.dto.ProductsOrderedDTO;
import com.infy.exception.OrderMsException;

public interface OrderService {

	

	public List<ProductsOrderedDTO> viewOrder() throws OrderMsException;

	public Integer placeOrder(ProductsOrderedDTO order)throws OrderMsException;
	
	
}
