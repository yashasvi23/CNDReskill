package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BuyerDTO;
import com.example.demo.dto.SellerDTO;
import com.example.demo.entity.Buyer;
import com.example.demo.entity.Seller;
import com.example.demo.exception.UserMSException;
import com.example.demo.repository.BuyerRepository;
import com.example.demo.repository.SellerRepository;
import com.example.demo.validator.BuyerValidator;
import com.example.demo.validator.SellerValidator;

@Service(value="userService")
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private BuyerRepository buyerRepository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Override
	public String reisterBuyer(BuyerDTO buyer) throws UserMSException
	{
		BuyerValidator.validateBuyerForRegistration(buyer);
		if(buyerRepository.findByContactNumber(buyer.getContactNumber())!=null)
		{
			throw new UserMSException("Service.BUYER_ALREADY_EXISTS");
		}
			Buyer buyerEntity= new Buyer();
			buyerEntity.setBuyerId(buyer.getBuyerId());
			buyerEntity.setContactNumber(buyer.getContactNumber());
			buyerEntity.setEmailId(buyer.getEmailId());
			buyerEntity.setIsActive(buyer.getIsActive());
			buyerEntity.setIsPriviliged(buyer.getIsPriviliged());
			buyerEntity.setName(buyer.getName());
			buyerEntity.setPassword(buyer.getPassword());
			buyerEntity.setRewardPoints(buyer.getRewardPoints());
			buyerRepository.save(buyerEntity);
			return buyerEntity.getName();
		
	}
	
	@Override
	public String registerSeller(SellerDTO seller) throws UserMSException
	{
		SellerValidator.validateSellerForRegistration(seller);
		if(sellerRepository.findByContactNumber(seller.getContactNumber())!=null)
		{
			throw new UserMSException("Service.SELLER_ALREADY_EXISTS");
		}
		Seller sellerEntity=new Seller();
		sellerEntity.setContactNumber(seller.getContactNumber());
		sellerEntity.setEmailId(seller.getEmailId());
		sellerEntity.setIsActive(seller.getIsActive());
		sellerEntity.setName(seller.getName());
		sellerEntity.setPassword(seller.getPassword());
		sellerEntity.setSellerId(seller.getSellerId());
		sellerRepository.save(sellerEntity);
		return sellerEntity.getName();
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
				BuyerDTO bDTO = new BuyerDTO();
				bDTO.setBuyerId(optional.getBuyerId());
				bDTO.setContactNumber(optional.getContactNumber());
				bDTO.setEmailId(optional.getEmailId());
				bDTO.setIsActive(optional.getIsActive());
				bDTO.setIsPriviliged(optional.getIsPriviliged());
				bDTO.setName(optional.getName());
				bDTO.setPassword(optional.getPassword());
				bDTO.setRewardPoints(optional.getRewardPoints());
				return bDTO;
			}
			else {
				throw new UserMSException("Service.INVALID_CREDENTIALS");
			}
		else
		{
			throw new UserMSException("Service.INVALID_CREDENTIALS");
		}
	}
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
				SellerDTO sDTO = new SellerDTO();
				sDTO.setSellerId(optional.getSellerId());
				sDTO.setContactNumber(optional.getContactNumber());
				sDTO.setEmailId(optional.getEmailId());
				sDTO.setIsActive(optional.getIsActive());
				
				sDTO.setName(optional.getName());
				sDTO.setPassword(optional.getPassword());
				
				return sDTO;
			}
			else {
				throw new UserMSException("Service.INVALID_CREDENTIALS");
			}
		else
		{
			throw new UserMSException("Service.INVALID_CREDENTIALS");
		}
	}

}
