package com.example.demo.validator;

import com.example.demo.dto.BuyerDTO;
import com.example.demo.exception.UserMSException;

public class BuyerValidator {
	
	public static void validateBuyerForRegistration(BuyerDTO buyer) throws UserMSException{
		if(!validateName1(buyer.getName()))
			throw new UserMSException("Validator.INVALID_NAME_FORMAT");
		if(!validateEmail1(buyer.getEmailId()))
			throw new UserMSException("Validator.INVALID_EMAIL_FORMAT");
		if(!validateContactNumber1(buyer.getContactNumber()))
			throw new UserMSException("Validator.INVALID_CONTACTNUMBER_FORMAT");
		if(!validatePassword1(buyer.getPassword()))
			throw new UserMSException("Validator.INVALID_PASSWORD_FORMAT");
		
	}
	public static void validateBuyerLogin1(String email,String password)throws UserMSException{
		if(!validateEmail1(email))
			throw new UserMSException("Validator.INVALID_EMAIL_FORMAT");
		if(!validatePassword1(password))
			throw new UserMSException("Validator.INVALID_PASSWORD_FORMAT");
	}
	
	public static Boolean validateName1(String name)
	{
	 if(name==null || name.trim().length()!=name.length())
	 
		 return false;
	 
	 return name.matches("[A-Za-z ]+");
	}
	public static Boolean validateEmail1(String email)
	{
		if(email==null)
			return false;
		return email.matches("[A-Za-z]+@[A-Za-z]+[.]com");
	}
	public static Boolean validateContactNumber1(String contactNumber)
	{
		if(contactNumber==null)
			return false;
		Boolean flag=false;
		if(contactNumber.matches("[6-9][0-9]{9}"))
			flag=true;
		return flag;
	}
	public static Boolean validatePassword1(String password)
	{
		if(password==null)
			return false;
		Boolean flag=false;
		if(password.length()>=7 && password.length()<=20)
			if(password.matches(".*[A-Z]+.*"))
				if(password.matches(".*[0-9]+.*"))
					if(password.matches(".*[!@#$%^&*].*"))
						flag=true;
		return flag;
	}

}
