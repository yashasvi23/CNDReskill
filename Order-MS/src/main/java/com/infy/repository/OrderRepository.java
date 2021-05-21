package com.infy.repository;

import org.springframework.data.repository.CrudRepository;

import com.infy.entity.Order;


public interface OrderRepository extends CrudRepository<Order, Integer>{
	
	

}
