package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ProductDTO;
import com.example.demo.exception.ProductMSException;

public interface ProductService {
	    
	public List<ProductDTO> getAllProduct() throws ProductMSException;
	public ProductDTO getProductById(Integer prodId) throws ProductMSException;
	
	   
}


