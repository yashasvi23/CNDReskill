package com.infy.service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//
////import com.infy.dto.Orderdto;
//import com.infy.dto.ProductsOrderedDTO;
//import com.infy.entity.ProductsOrdered;
//import com.infy.exception.OrderMsException;
////import com.infy.repository.OrderRepository;
//import com.infy.repository.ProductsOrderedRepo;
//


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.infy.dto.OrderDTO;
import com.infy.dto.ProductsOrderedDTO;
import com.infy.entity.CompositeKey;
import com.infy.entity.Order;
import com.infy.entity.ProductsOrdered;
import com.infy.exception.OrderMSException;
import com.infy.repository.OrderRepository;
import com.infy.repository.ProductsOrderedRepo;

@Service(value="orderService")
@Transactional
public class OrderServiceImpl implements OrderService{

	@Autowired
	private ProductsOrderedRepo prodRepo;
	
	@Autowired
	private OrderRepository orderRepo;



	@Override
	public String placeProduct(ProductsOrderedDTO productsOrderedDTO) throws OrderMSException {
		
		//prodRepo.findByIdBuyerId(productsOrderedDTO.getBuyerId()).orElseThrow(()->new OrderMSException("OrderService.No_such_buyer_exists"));
		ProductsOrdered po = new ProductsOrdered();
        CompositeKey newId = new CompositeKey();
        Order ord=new Order();
		newId.setBuyerId(productsOrderedDTO.getBuyerId());
		newId.setProdId(productsOrderedDTO.getProdid());
		po.setId(newId);
        po.setSellerId(productsOrderedDTO.getSellerId());
		po.setQuantity(productsOrderedDTO.getQuantity());
		ord.setBuyerId(productsOrderedDTO.getBuyerId());
		ord.setStatus("Success");
		
		//orderRepo.save(ord);
		prodRepo.save(po);
		String val = "Buyer ID: "+productsOrderedDTO.getBuyerId()+" and Product ID: "+productsOrderedDTO.getProdid();
		return val;
	}
	@Override
	public void deleteOrder(Integer orderId) throws OrderMSException
	{
		Optional<Order> order = orderRepo.findById(orderId);
		Order order1 = order.orElseThrow(()-> new OrderMSException("Service.NO_ORDER_FOUND"));
		
		orderRepo.delete(order1);
	
	}
	@Override
	public List<OrderDTO> viewOrder(Integer orderId) throws OrderMSException
	{
		List<OrderDTO> l= new ArrayList<OrderDTO>();
		Optional<Order> optional = orderRepo.findById(orderId);
		Order order = optional.orElseThrow(()-> new OrderMSException("No Order Found"));
		OrderDTO oDTO = new OrderDTO();
		oDTO.setOrderId(order.getOrderId());
		oDTO.setAddress(order.getAddress());
		oDTO.setAmount(order.getAmount());
		oDTO.setBuyerId(order.getBuyerId());
		oDTO.setDate(order.getDate());
		oDTO.setStatus(order.getStatus());
		l.add(oDTO);
		return l;
	}
	public Integer placeOrder(OrderDTO oDTO) throws OrderMSException
	{
		
		LocalDate d =  LocalDate.now();
		Order o = new Order();
		o.setBuyerId(oDTO.getBuyerId());
		o.setAddress(oDTO.getAddress());
		o.setAmount(oDTO.getAmount());
		o.setDate(d);
		o.setStatus("Placed");
		
		Order booked = orderRepo.save(o);
		return booked.getOrderId();
		
		
		
	}
}
