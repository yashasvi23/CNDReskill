package com.infy.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infy.dto.Orderdto;
import com.infy.dto.ProductsOrderedDTO;
import com.infy.exception.OrderMsException;
import com.infy.service.OrderService;

@RestController
@CrossOrigin
@RequestMapping
public class OrderController {

	Log logger = LogFactory.getLog(OrderController.class);
	@Autowired
	OrderService orderService;
	@Autowired
	private Environment environment;
	
	@GetMapping(value = "/ProductsOrdered", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductsOrderedDTO> getAllProducts() {
		logger.info("Fetching all products");
		return orderService.viewOrder();
	}
	@RequestMapping(value="/addOrder", method=RequestMethod.POST)
	public ResponseEntity<String> addToOrder(@RequestBody ProductsOrderedDTO pOrder) throws OrderMsException
	{
		Integer id=orderService.placeOrder(pOrder);
		String message=environment.getProperty("OrderService.ORDER_ADDED")+ ""+id+" "+
		environment.getProperty("OrderService.ORDER_ADDED2");
		new RestTemplate().getForObject("http://localhost:8200/orders/"+pOrder.getProdId(),Orderdto.class);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}

}
