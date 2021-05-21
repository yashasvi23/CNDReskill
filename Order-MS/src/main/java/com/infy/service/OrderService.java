package com.infy.service;

import java.util.List;

import com.infy.dto.OrderDTO;
import com.infy.dto.ProductsOrderedDTO;
import com.infy.exception.OrderMSException;

public interface OrderService {
	
	public String placeProduct(ProductsOrderedDTO productsOrderedDTO) throws OrderMSException;
	public void deleteOrder(Integer orderId) throws OrderMSException;
	public List<OrderDTO> viewOrder(Integer orderId) throws OrderMSException;
	public Integer placeOrder(OrderDTO oDTO) throws OrderMSException;
	

}
