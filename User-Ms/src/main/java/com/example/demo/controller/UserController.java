package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.dto.BuyerDTO;
import com.example.demo.dto.SellerDTO;
import com.example.demo.exception.UserMSException;
import com.example.demo.service.UserService;

@CrossOrigin
@RestController
@RequestMapping
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private Environment environment;
	
	@RequestMapping(value="/buyerRegister" , method =RequestMethod.POST)
	public ResponseEntity<String> registerBuyer(@RequestBody BuyerDTO buyer) throws UserMSException
	{
		
			String userName= userService.reisterBuyer(buyer) ;
			String message= environment.getProperty("UserController.BUYER_SUCCESS2") +" "+ userName +" "+ 
					environment.getProperty("UserController.BUYER_SUCCESS");
			return new ResponseEntity<String>(message,HttpStatus.OK);
		
	}
	@RequestMapping(value="/sellerRegister" , method =RequestMethod.POST)
	public ResponseEntity<String> registerSeller(@RequestBody SellerDTO seller) throws UserMSException
	{
		
			String userName= userService.registerSeller(seller);
			String message= environment.getProperty("UserController.SELLER_SUCCESS2") +" "+ userName +" "+ 
					environment.getProperty("UserController.SELLER_SUCCESS");
			return new ResponseEntity<String>(message,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/sellerLogin" , method =RequestMethod.POST)
	public ResponseEntity<SellerDTO> sellerLogin(@RequestBody SellerDTO seller) throws UserMSException
	{
		
			SellerDTO sellerD= userService.sellerLogin(seller.getEmailId(), seller.getPassword());
			
			return new ResponseEntity<SellerDTO>(sellerD,HttpStatus.OK);
		
		
	}
	@RequestMapping(value="/buyerLogin" , method =RequestMethod.POST)
	public ResponseEntity<BuyerDTO> buyerLogin(@RequestBody BuyerDTO buyer) throws UserMSException
	{
		
			BuyerDTO buyerD= userService.buyerLogin(buyer.getEmailId(), buyer.getPassword());
			
			return new ResponseEntity<BuyerDTO>(buyerD,HttpStatus.OK);
		
		
	}
//	

}
