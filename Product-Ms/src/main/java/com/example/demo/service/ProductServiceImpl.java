package com.example.demo.service;


import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import com.example.demo.exception.ProductMSException;
import com.example.demo.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service(value="productService")
@Transactional
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<ProductDTO> getAllProduct() throws ProductMSException
	{
		Iterable<Product> list=productRepository.findAll();
		if(list==null)
		{
			throw new ProductMSException("Service.PRODUCTS_UNAVAILABLE");
		}
		List<ProductDTO> pDTOList = new ArrayList<>();
		list.forEach(l->{
			ProductDTO pDTO=new ProductDTO();
			pDTO.setProdid(l.getProdId());
			pDTO.setCategory(l.getCategory());
			pDTO.setDiscription(l.getDiscription());
			pDTO.setPrice(l.getPrice());
			pDTO.setProductName(l.getProductName());
			pDTO.setProductRating(l.getProductRating());
			pDTO.setSellerId(l.getSellerId());
			pDTO.setStock(l.getStock());
			pDTO.setSubCategory(l.getSubCategory());
			pDTOList.add(pDTO);
		
		});
		return pDTOList;
	}
	@Override
	public ProductDTO getProductById(Integer prodId) throws ProductMSException
	{
		Optional<Product> optional = productRepository.findById(prodId);
		Product p = optional.orElseThrow(()->new ProductMSException("Service.PRODUCTS_UNAVAILABLE"));
		ProductDTO pDTO =new ProductDTO();
		pDTO.setCategory(p.getCategory());
		pDTO.setDiscription(p.getDiscription());
		pDTO.setPrice(p.getPrice());
		pDTO.setProdid(p.getProdId());
		pDTO.setProductName(p.getProductName());
		pDTO.setProductRating(p.getProductRating());
		pDTO.setSellerId(p.getSellerId());
		pDTO.setStock(p.getStock());
		pDTO.setSubCategory(p.getSubCategory());
		
		return pDTO;
	}
	
	@Override
	public List<ProductDTO> getProductByCategory(String category) throws ProductMSException
	{
		List<Product> plist=productRepository.findByCategory(category);
		if(plist.isEmpty())
		{
			throw new ProductMSException("Service.PRODUCTS_UNAVAILABLE");
		}
		List<ProductDTO> pDTOList = new ArrayList<>();
		plist.forEach(l->{
			ProductDTO pDTO=new ProductDTO();
			pDTO.setProdid(l.getProdId());
			pDTO.setCategory(l.getCategory());
			pDTO.setDiscription(l.getDiscription());
			pDTO.setPrice(l.getPrice());
			pDTO.setProductName(l.getProductName());
			pDTO.setProductRating(l.getProductRating());
			pDTO.setSellerId(l.getSellerId());
			pDTO.setStock(l.getStock());
			pDTO.setSubCategory(l.getSubCategory());
			pDTOList.add(pDTO);
		
		});
		return pDTOList;
	}
}
