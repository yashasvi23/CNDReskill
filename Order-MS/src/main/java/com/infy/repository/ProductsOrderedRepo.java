package com.infy.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.infy.entity.CompositeKey;
import com.infy.entity.ProductsOrdered;

public interface ProductsOrderedRepo extends CrudRepository<ProductsOrdered, CompositeKey>{
	
	Optional<ProductsOrdered> findByIdProdId(Integer prodId);
	Optional<ProductsOrdered> findByIdBuyerId(Integer buyerId);

}
