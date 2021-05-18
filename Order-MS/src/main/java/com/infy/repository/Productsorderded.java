package com.infy.repository;

import org.springframework.data.repository.CrudRepository;

import com.infy.entity.CompositeKey;
import com.infy.entity.ProductsOrdered;

public interface Productsorderded extends CrudRepository<ProductsOrdered , CompositeKey>{

}
