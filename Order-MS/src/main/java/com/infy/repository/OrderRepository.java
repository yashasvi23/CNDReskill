package com.infy.repository;

import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.data.repository.CrudRepository;

import com.infy.entity.Orders;

public interface OrderRepository extends CrudRepository<Orders,Integer> {
	//public OrderDto getOrderId(int orderId);
}
