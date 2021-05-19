package com.infy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.Orderdto;
import com.infy.dto.ProductsOrderedDTO;
import com.infy.entity.ProductsOrdered;
import com.infy.exception.OrderMsException;
import com.infy.repository.OrderRepository;
import com.infy.repository.ProductsOrderedRepo;

@Service
@Transactional
public class OrderServiceImpl {
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductsOrderedRepo productsOrderedRepo;
	//Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	
	
	
	public Integer placeOrder(ProductsOrderedDTO pOrder) throws OrderMsException
	{
		Optional<ProductsOrdered> po= productsOrderedRepo.findByBuyerIdAndProdId(pOrder.getBuyerId(), pOrder.getProdId());
		if(po.isPresent()) {
			throw new  OrderMsException("OrderService.ALREADY_ORDERED");
		}
		else {			
			
	        ProductsOrdered ordered= new ProductsOrdered();
	        ordered.setBuyerId(pOrder.getBuyerId());
	        ordered.setProdId(pOrder.getProdId());
	        productsOrderedRepo.save(ordered);
			return pOrder.getProdId();
		}
	}
	
	public List<ProductsOrderedDTO> viewOrder() throws OrderMsException
	{

		Iterable<ProductsOrdered> productsOrdered = productsOrderedRepo.findAll();
		List<ProductsOrderedDTO> productsOrderedDTOs = new ArrayList<ProductsOrderedDTO>();

		for (ProductsOrdered pOrder :productsOrdered ) {
			ProductsOrderedDTO pOrderDTO = ProductsOrderedDTO.valueOf(pOrder);
			productsOrderedDTOs.add(pOrderDTO);
		}

		//logger.info("Products Ordered : {}", productsOrderedDTOs);
		return productsOrderedDTOs;
	}
}
