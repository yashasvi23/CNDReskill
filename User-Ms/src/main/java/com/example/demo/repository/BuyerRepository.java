package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Buyer;
import com.example.demo.entity.Seller;

public interface BuyerRepository extends CrudRepository<Buyer,Integer>{
	public Buyer findByContactNumber(String contactNumber);
	public Buyer findByEmailId(String emailId);

}
