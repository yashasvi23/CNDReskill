package com.infy.service;

import java.util.List;



import com.infy.dto.ProductsOrderedDTO;
import com.infy.exception.OrderMsException;

public interface OrderService {

	
//    public void addToCart(CartDTO cartDTO)throws OrderMsException;
//    public void removeCart(CartDTO cartDTO) throws OrderMsException;
	public List<ProductsOrderedDTO> viewOrder() throws OrderMsException;;
}
