package com.example.demo.controller;

import com.example.demo.dto.ProductDTO;

import com.example.demo.exception.ProductMSException;
import com.example.demo.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping
public class ProductController {
	  @Autowired
	    private ProductService productService;
	  
	  @RequestMapping(value="/allProducts" , method =RequestMethod.GET)
	  public ResponseEntity<List<ProductDTO>> getAllProducts() throws ProductMSException {
	  List<ProductDTO> productList = productService.getAllProduct();
		return new ResponseEntity<>(productList, HttpStatus.OK);
	    
	  }
	  
	  @RequestMapping(value="/products/{productId}" , method =RequestMethod.GET)
	  public ResponseEntity<ProductDTO> getProduct(@PathVariable Integer productId) throws ProductMSException {
	  ProductDTO product = productService.getProductById(productId);
		return new ResponseEntity<>(product, HttpStatus.OK);
	    
	  }
	  
	  @RequestMapping(value="/products/category/{category}" , method =RequestMethod.GET)
	  public ResponseEntity<List<ProductDTO>> getByCategory(@PathVariable String category) throws ProductMSException {
		  List<ProductDTO> productList = productService.getProductByCategory(category);
			return new ResponseEntity<>(productList, HttpStatus.OK);
	    
	  }
	  
	  @RequestMapping(value="/products/{productId}/{quantity}" , method =RequestMethod.GET)
	  public Boolean placeOrder(@PathVariable Integer productId,@PathVariable Integer quantity) throws ProductMSException {
		  Boolean b = productService.placeOrder(productId, quantity);
			return b;
	  } 
	  
}
