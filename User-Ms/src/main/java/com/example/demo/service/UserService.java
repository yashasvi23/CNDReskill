package com.example.demo.service;

import com.example.demo.dto.BuyerDTO;
import com.example.demo.dto.CartDTO;
import com.example.demo.dto.SellerDTO;
import com.example.demo.dto.WishlistDTO;
import com.example.demo.exception.UserMSException;

public interface UserService {
	public String reisterBuyer(BuyerDTO buyer) throws UserMSException;
	public String registerSeller(SellerDTO seller) throws UserMSException;
	public BuyerDTO buyerLogin(String emailid,String password) throws  UserMSException;
	public SellerDTO sellerLogin(String emailid,String password) throws  UserMSException;
	public void deleteBuyer(Integer buyerId)throws  UserMSException;
	public void deleteSeller(Integer sellerId)throws  UserMSException;
	public Integer addProductToWishlist(WishlistDTO wishlist) throws UserMSException;
	public void addToCart(CartDTO cartDTO)throws UserMSException;
	public void removeCart(CartDTO cartDTO) throws UserMSException;
	

}
