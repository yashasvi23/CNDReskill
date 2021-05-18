package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.dto.ProductDTO;
import com.example.demo.service.ProductService;
import com.example.demo.header.HeaderGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


public class ProductController {
	  @Autowired
	    private ProductService productService;
	    
	    @Autowired
	    private HeaderGenerator headerGenerator;

	    @GetMapping (value = "/products")
	    public ResponseEntity<List<Product>> getAllProducts(){
	        List<Product> products =  productService.getAllProduct();
	        if(!products.isEmpty()) {
	        	return new ResponseEntity<List<Product>>(
	        			products,
	        			headerGenerator.getHeadersForSuccessGetMethod(),
	        			HttpStatus.OK);
	        }
	        return new ResponseEntity<List<Product>>(
	        		headerGenerator.getHeadersForError(),
	        		HttpStatus.NOT_FOUND);       
	    }

	    @GetMapping(value = "/products", params = "category")
	    public ResponseEntity<List<Product>> getAllProductByCategory(@RequestParam ("category") String category){
	        List<Product> products = productService.getAllProductByCategory(category);
	        if(!products.isEmpty()) {
	        	return new ResponseEntity<List<Product>>(
	        			products,
	        			headerGenerator.getHeadersForSuccessGetMethod(),
	        			HttpStatus.OK);
	        }
	        return new ResponseEntity<List<Product>>(
	        		headerGenerator.getHeadersForError(),
	        		HttpStatus.NOT_FOUND);
	    }

	    @GetMapping (value = "/products/{id}")
	    public ResponseEntity<Product> getOneProductById(@PathVariable ("id") long id){
	        Product product =  productService.getProductById(id);
	        if(product != null) {
	        	return new ResponseEntity<Product>(
	        			product,
	        			headerGenerator.getHeadersForSuccessGetMethod(),
	        			HttpStatus.OK);
	        }
	        return new ResponseEntity<Product>(
	        		headerGenerator.getHeadersForError(),
	        		HttpStatus.NOT_FOUND);
	    }

	    @GetMapping (value = "/products", params = "name")
	    public ResponseEntity<List<Product>> getAllProductsByName(@RequestParam ("name") String name){
	        List<Product> products =  productService.getAllProductsByName(name);
	        if(!products.isEmpty()) {
	        	return new ResponseEntity<List<Product>>(
	        			products,
	        			headerGenerator.getHeadersForSuccessGetMethod(),
	        			HttpStatus.OK);
	        }
	        return new ResponseEntity<List<Product>>(
	        		headerGenerator.getHeadersForError(),
	        		HttpStatus.NOT_FOUND);
	    }

}
