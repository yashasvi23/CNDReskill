package com.infy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.infy.dto.OrderDTO;
import com.infy.dto.ProductsOrderedDTO;
import com.infy.exception.OrderMSException;
import com.infy.service.OrderService;


@RestController
@CrossOrigin
@RequestMapping
public class OrderController {
//
//	Log logger = LogFactory.getLog(OrderController.class);
	@Autowired
	private OrderService orderService;
	
	
	
	@PostMapping(value="/placeproduct")
	public ResponseEntity<String> placeProduct(@RequestBody ProductsOrderedDTO productsOrderedDTO) throws OrderMSException{
		
		Boolean val = new RestTemplate().getForObject("http://localhost:8200/products/"+productsOrderedDTO.getProdid()+"/"+productsOrderedDTO.getQuantity(), Boolean.class);
		
		if(val==true) {
			
			String message = "Products Ordered for  "+orderService.placeProduct(productsOrderedDTO);
			return new ResponseEntity<String>(message,HttpStatus.OK);
		}
else {
	 
	   String message2 = "Not Found ";
	   return new ResponseEntity<String>(message2,HttpStatus.BAD_REQUEST);
			
		}
		
		
	}
	@RequestMapping(value = "/order/{orderId}" , method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteBuyer(@PathVariable Integer orderId) throws OrderMSException {
		orderService.deleteOrder(orderId);
		String successMessage = "Order with order Id "+orderId+ " deleted succesfully";
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
	 @RequestMapping(value="/order/order/{orderId}" , method =RequestMethod.GET)
	  public ResponseEntity<List<OrderDTO>> getOrder(@PathVariable Integer orderId) throws OrderMSException {
	  List<OrderDTO> orderList = orderService.viewOrder(orderId);
		return new ResponseEntity<>(orderList, HttpStatus.OK);
	    
	  }
	 
	 @PostMapping(value="/placeorder")
		public ResponseEntity<String> placeOrder(@RequestBody OrderDTO orderDTO) throws OrderMSException{
			
			Boolean val = new RestTemplate().getForObject("http://localhost:8000/buyer/buyer/"+orderDTO.getBuyerId(),Boolean.class);
			
			if(val==true) {
				
				String message = "Order placed. Order Id"+ orderService.placeOrder(orderDTO);
				return new ResponseEntity<String>(message,HttpStatus.OK);
			}
	else {
		 
		   String message2 = "Not Found ";
		   return new ResponseEntity<String>(message2,HttpStatus.BAD_REQUEST);
				
			}
			
	 }
}
