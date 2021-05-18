package com.infy.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.infy.entity.CompositeKey;
import com.infy.entity.ProductsOrdered;

public interface ProductsOrderedRepo extends CrudRepository<ProductsOrdered , CompositeKey>{
	
}
