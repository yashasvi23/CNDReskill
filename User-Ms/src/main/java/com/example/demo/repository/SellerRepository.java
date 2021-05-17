package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;


import com.example.demo.entity.Seller;

public interface SellerRepository extends CrudRepository<Seller , Integer>{
	
	public Seller findByContactNumber(String contactNumber);
	
	public Seller findByEmailId(String emailId);
	
	

}
