package com.example.demo.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BuyerDTO;
import com.example.demo.dto.CartDTO;
import com.example.demo.dto.SellerDTO;
import com.example.demo.dto.WishlistDTO;
import com.example.demo.entity.Buyer;
import com.example.demo.entity.Cart;
import com.example.demo.entity.Seller;
import com.example.demo.entity.Wishlist;
import com.example.demo.exception.UserMSException;
import com.example.demo.repository.BuyerRepository;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.SellerRepository;
import com.example.demo.repository.WishListRepository;
import com.example.demo.validator.BuyerValidator;
import com.example.demo.validator.SellerValidator;

@Service(value="userService")
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private BuyerRepository buyerRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Autowired
	private WishListRepository wishListRepository;
	
	@Override
	public String reisterBuyer(BuyerDTO buyer) throws UserMSException
	{
		BuyerValidator.validateBuyerForRegistration(buyer);
		if(buyerRepository.findByContactNumber(buyer.getContactNumber())!=null)
		{
			throw new UserMSException("Service.BUYER_ALREADY_EXISTS");
		}
			Buyer buyer1= new Buyer();
			buyer1.setBuyerId(buyer.getBuyerId());
			buyer1.setContactNumber(buyer.getContactNumber());
			buyer1.setEmailId(buyer.getEmailId());
			buyer1.setIsActive(buyer.getIsActive());
			buyer1.setIsPriviliged(buyer.getIsPriviliged());
			buyer1.setName(buyer.getName());
			buyer1.setPassword(buyer.getPassword());
			buyer1.setRewardPoints(buyer.getRewardPoints());
			buyerRepository.save(buyer1);
			return buyer1.getName();
		
	}
	
	@Override
	public String registerSeller(SellerDTO seller) throws UserMSException
	{
		SellerValidator.validateSellerForRegistration(seller);
		if(sellerRepository.findByContactNumber(seller.getContactNumber())!=null)
		{
			throw new UserMSException("Service.SELLER_ALREADY_EXISTS");
		}
		Seller seller2=new Seller();
		seller2.setContactNumber(seller.getContactNumber());
		seller2.setEmailId(seller.getEmailId());
		seller2.setIsActive(seller.getIsActive());
		seller2.setName(seller.getName());
		seller2.setPassword(seller.getPassword());
		seller2.setSellerId(seller.getSellerId());
		sellerRepository.save(seller2);
		return seller2.getName();
	}
	@Override
	public BuyerDTO buyerLogin(String emailId,String password)throws UserMSException
	{
		Buyer optional=buyerRepository.findByEmailId(emailId);
		if(optional==null)
		{
			throw new UserMSException("Service.INVALID_CREDENTIALS");
		}
		String buyerPassword=optional.getPassword();
		if(buyerPassword!=null)
			if(buyerPassword.equals(password))
			{
				BuyerDTO b = new BuyerDTO();
				b.setBuyerId(optional.getBuyerId());
				b.setContactNumber(optional.getContactNumber());
				b.setEmailId(optional.getEmailId());
				b.setIsActive(optional.getIsActive());
				b.setIsPriviliged(optional.getIsPriviliged());
				b.setName(optional.getName());
				b.setPassword(optional.getPassword());
				b.setRewardPoints(optional.getRewardPoints());
				return b;
			}
			else {
				throw new UserMSException("Service.INVALID_CREDENTIALS");
			}
		else
		{
			throw new UserMSException("Service.INVALID_CREDENTIALS");
		}
	}
	@Override
	public SellerDTO sellerLogin(String emailId,String password)throws UserMSException
	{
		Seller optional=sellerRepository.findByEmailId(emailId);
		if(optional==null)
		{
			throw new UserMSException("Service.INVALID_CREDENTIALS");
		}
		String sellerPassword=optional.getPassword();
		if(sellerPassword!=null)
			if(sellerPassword.equals(password))
			{
				SellerDTO s = new SellerDTO();
				s.setSellerId(optional.getSellerId());
				s.setContactNumber(optional.getContactNumber());
				s.setEmailId(optional.getEmailId());
				s.setIsActive(optional.getIsActive());
				
				s.setName(optional.getName());
				s.setPassword(optional.getPassword());
				
				return s;
			}
			else {
				throw new UserMSException("Service.INVALID_CREDENTIALS");
			}
		else
		{
			throw new UserMSException("Service.INVALID_CREDENTIALS");
		}
	}
	@Override
	public void deleteBuyer(Integer buyerId) throws UserMSException {
		Optional<Buyer> optional = buyerRepository.findById(buyerId);
	Buyer b  = optional.orElseThrow(() -> new UserMSException("Service.USER_NOT_FOUND"));
		buyerRepository.deleteById(buyerId);
	}
	@Override
	public void deleteSeller(Integer sellerId) throws UserMSException {
		Optional<Seller> optional = sellerRepository.findById(sellerId);
		Seller s = optional.orElseThrow(() -> new UserMSException("Service.USER_NOT_FOUND"));
		sellerRepository.deleteById(sellerId);
	}
	
	@Override
	public Integer addProductToWishlist(WishlistDTO wishlist) throws UserMSException
	{
		Optional<Buyer> opBuyer= buyerRepository.findById(wishlist.getBuyerId());
		Buyer b = opBuyer.orElseThrow(()-> new UserMSException("UserService.NO_USER"));

		Optional<Wishlist> op= wishListRepository.findByBuyerIdAndProdId(wishlist.getBuyerId(), wishlist.getProdId());
		if(op.isPresent()) {
			throw new  UserMSException("UserService.ALREADY_WISHLISTED");
		}
		else {			
			
	        Wishlist wishl= new Wishlist();
			wishl.setBuyerId(wishlist.getBuyerId());
			wishl.setProdId(wishlist.getProdId());
			wishListRepository.save(wishl);
			return wishlist.getProdId();
		}
		
	}
	
	@Override
	public void addToCart(CartDTO cartDTO)throws UserMSException {

		Optional<Buyer> opBuyer= buyerRepository.findById(cartDTO.getBuyerId());
		Buyer b= opBuyer.orElseThrow(()-> new UserMSException("UserService.NO_USER"));

		Optional<Cart> optional= cartRepository.findByBuyerIdAndProdId(cartDTO.getBuyerId(), cartDTO.getProdId());
		if(optional.isPresent()) {
			throw new  UserMSException("UserService.ALREADY_CART");
		}
        Cart cart= new Cart();
		cart.setBuyerId(cartDTO.getBuyerId());
		cart.setProdId(cartDTO.getProdId());
		cart.setQuantity(cartDTO.getQuantity());
		cartRepository.save(cart);
	}
	@Override
	public void removeCart(CartDTO cartDTO) throws UserMSException{
		Optional<Buyer> opBuyer= buyerRepository.findById(cartDTO.getBuyerId());
		Buyer b =opBuyer.orElseThrow(()-> new UserMSException("UserService.NO_USER"));
        Optional<Cart> optionalCart= cartRepository.findByBuyerIdAndProdId(cartDTO.getBuyerId(), cartDTO.getProdId());
		Cart cart= optionalCart.orElseThrow(()-> new UserMSException("UserService.NO_SUCH_CART"));
		cartRepository.delete(cart);
	}
}
