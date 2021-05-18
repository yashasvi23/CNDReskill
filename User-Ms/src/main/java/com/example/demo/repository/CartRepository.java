package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Cart;
import com.example.demo.entity.CompositeKey;


public interface CartRepository extends CrudRepository<Cart,CompositeKey>{
	public Optional<Cart> findByBuyerIdAndProdId(Integer buyerId, Integer prodId);

}
