package com.infy.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
	
	
	@PostMapping(value="/placeorder")
	public ResponseEntity<String> placeOrder(@RequestBody ProductsOrderedDTO productsOrderedDTO) throws OrderMSException{
		System.out.println("3");
		Boolean val = new RestTemplate().getForObject("http://localhost:8200/products/"+productsOrderedDTO.getProdid()+"/"+productsOrderedDTO.getQuantity(), Boolean.class);
		System.out.println("4");
		if(val==true) {
			System.out.println("2");
			String message = "Order placed for "+orderService.placeOrder(productsOrderedDTO);
			return new ResponseEntity<String>(message,HttpStatus.OK);
		}
else {
	 System.out.println("1");
	   String message2 = "Not Found ";
	   return new ResponseEntity<String>(message2,HttpStatus.BAD_REQUEST);
			
		}
		
		
	}
//	
//
//
//	@GetMapping(value = "/ProductsOrdered", produces = MediaType.APPLICATION_JSON_VALUE)
//	public List<ProductsOrderedDTO> getAllProducts() throws OrderMsException {
//		logger.info("Fetching all products");
//		return orderService.viewOrder();
//	}
//	@RequestMapping(value="/addOrder", method=RequestMethod.POST)
//	public ResponseEntity<String> addToOrder(@RequestBody ProductsOrderedDTO pOrder) throws OrderMsException
//	{
//		Integer id=orderService.placeOrder(pOrder);
//		String message=environment.getProperty("OrderController.ORDER_ADDED")+ ""+id+" "+
//		environment.getProperty("OrderController.ORDER_ADDED2");
//		new RestTemplate().getForObject("http://localhost:8100/orders/"+pOrder.getProdId(),Orderdto.class);
//		return new ResponseEntity<String>(message,HttpStatus.OK);
//	}
//
//
}
