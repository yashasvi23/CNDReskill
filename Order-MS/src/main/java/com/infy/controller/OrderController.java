package com.infy.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infy.dto.ProductsOrderedDTO;
import com.infy.service.OrderService;

@RestController
@CrossOrigin
@RequestMapping
public class OrderController {

	Log logger = LogFactory.getLog(OrderController.class);
	@Autowired
	OrderService orderService;
	
//	@GetMapping(value = "/ProductsOrdered", produces = MediaType.APPLICATION_JSON_VALUE)
//	public List<ProductsOrderedDTO> getAllProducts() {
//		logger.info("Fetching all products");
//		return orderService.viewOrder();
//	}

}
