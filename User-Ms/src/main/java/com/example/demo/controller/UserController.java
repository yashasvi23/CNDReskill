package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.BuyerDTO;
import com.example.demo.dto.CartDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.SellerDTO;
import com.example.demo.dto.WishlistDTO;
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
	@RequestMapping(value = "/buyer/{buyerId}" , method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteBuyer(@PathVariable Integer buyerId) throws UserMSException {
		userService.deleteBuyer(buyerId);
		String successMessage = environment.getProperty("UserController.DELETE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
	@RequestMapping(value = "/seller/{sellerId}" , method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteSeller(@PathVariable Integer sellerId) throws UserMSException {
		userService.deleteSeller(sellerId);
		String successMessage = environment.getProperty("UserController.DELETE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
	@RequestMapping(value="/addWishlist" , method =RequestMethod.POST)
	public ResponseEntity<String> addToWishList(@RequestBody WishlistDTO wishlist) throws UserMSException
	{
		
			Integer id = userService.addProductToWishlist(wishlist);
			String message=environment.getProperty("UserService.ADDED_TO_WISHLIST")+ " "+id+" "+
			environment.getProperty("UserService.ADDED_TO_WISHLIST2");
			new RestTemplate().getForObject("http://localhost:8200/products/"+wishlist.getProdId(),
					ProductDTO.class);
			return new ResponseEntity<String>(message,HttpStatus.OK);
		
		
	}
//	@RequestMapping(value="/addWishlist" , method =RequestMethod.POST)
//	public ResponseEntity<ProductDTO> addToWishList(@RequestBody WishlistDTO wishlist) throws UserMSException
//	{
//		
//			userService.addProductToWishlist(wishlist);
//			//String message=environment.getProperty("UserService.ADDED_TO_WISHLIST")+ " "+id+" "+
//			//environment.getProperty("UserService.ADDED_TO_WISHLIST2");
//			ProductDTO pDTO=new RestTemplate().getForObject("http://localhost:8200/products/"+wishlist.getProdId(),
//					ProductDTO.class);
//			return new ResponseEntity<>(pDTO,HttpStatus.OK);
//		
//		
//	}
//	
	@RequestMapping(value="/addCart" , method =RequestMethod.POST)
	public ResponseEntity<String> addToCart(@RequestBody CartDTO cartDTO) throws UserMSException
	{
		
		userService.addToCart(cartDTO);
		new RestTemplate().getForObject("http://localhost:8200/products/"+cartDTO.getProdId(),
				ProductDTO.class);	
         String message= environment.getProperty("UserService.CART_ADDED");
		return new ResponseEntity<>(message, HttpStatus.OK);
		
		
	}
	@RequestMapping(value = "/delete" , method=RequestMethod.DELETE)
	public ResponseEntity<String>  deleteFromCart(@RequestBody CartDTO cartDTO)throws UserMSException
	{
		new RestTemplate().getForObject("http://localhost:8200/products/"+cartDTO.getProdId(),
				ProductDTO.class);
		userService.removeCart(cartDTO);
		String message= environment.getProperty("UserService.REMOVE_CART");
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
}
