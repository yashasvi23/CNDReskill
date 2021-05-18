package com.example.demo.repository;


import org.springframework.data.repository.CrudRepository;


import com.example.demo.entity.Product;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Integer> {
    public List<Product> findAll();
    
}
