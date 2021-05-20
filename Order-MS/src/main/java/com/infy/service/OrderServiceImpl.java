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

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.ProductsOrderedDTO;
import com.infy.entity.CompositeKey;
import com.infy.entity.ProductsOrdered;
import com.infy.exception.OrderMSException;
import com.infy.repository.ProductsOrderedRepo;

@Service(value="orderService")
@Transactional
public class OrderServiceImpl implements OrderService{
////	@Autowired
////	private OrderRepository orderRepository;
//	
	@Autowired
	private ProductsOrderedRepo prodRepo;
//	//Logger logger = LoggerFactory.getLogger(this.getClass());
//	
//
////	@Override
////	public void addToCart(CartDTO cartDTO)throws OrderMsException {
////
////		Optional<Buyer> opBuyer= buyerRepository.findById(cartDTO.getBuyerId());
////		opBuyer.orElseThrow(()-> new UserMSException("UserService.NO_USER"));
////
////		Optional<Cart> optional= cartRepository.findByBuyerIdAndProdId(cartDTO.getBuyerId(), cartDTO.getProdId());
////		if(optional.isPresent()) {
////			throw new  UserMSException("UserService.ALREADY_CART");
////		}
////        Cart cart= new Cart();
////		cart.setBuyerId(cartDTO.getBuyerId());
////		cart.setProdId(cartDTO.getProdId());
////		cart.setQuantity(cartDTO.getQuantity());
////		cartRepository.save(cart);
////	}
////	@Override
////	public void removeCart(CartDTO cartDTO) throws OrderMsException{
////		Optional<Buyer> opBuyer= buyerRepository.findById(cartDTO.getBuyerId());
////		opBuyer.orElseThrow(()-> new UserMSException("UserService.NO_USER"));
////        Optional<Cart> optionalCart= cartRepository.findByBuyerIdAndProdId(cartDTO.getBuyerId(), cartDTO.getProdId());
////		Cart cart= optionalCart.orElseThrow(()-> new UserMSException("UserService.NO_SUCH_CART"));
////		cartRepository.delete(cart);
////	}
//
//	
//	
//	
//	
//	public Integer placeOrder(ProductsOrderedDTO pOrder) throws OrderMsException
//	{
//		Optional<ProductsOrdered> po= productsOrderedRepo.findByBuyerIdAndProdId(pOrder.getBuyerId(), pOrder.getProdId());
//		if(po.isPresent()) {
//			throw new  OrderMsException("OrderService.ALREADY_ORDERED");
//		}
//		else {			
//			
//	        ProductsOrdered ordered= new ProductsOrdered();
//	        ordered.setBuyerId(pOrder.getBuyerId());
//	        ordered.setProdId(pOrder.getProdId());
//	        productsOrderedRepo.save(ordered);
//			return pOrder.getProdId();
//		}
//	}
//
//	
//	public List<ProductsOrderedDTO> viewOrder() throws OrderMsException
//	{
//
//		Iterable<ProductsOrdered> productsOrdered = productsOrderedRepo.findAll();
//		List<ProductsOrderedDTO> productsOrderedDTOs = new ArrayList<ProductsOrderedDTO>();
//
//		for (ProductsOrdered pOrder :productsOrdered ) {
//			ProductsOrderedDTO pOrderDTO = ProductsOrderedDTO.valueOf(pOrder);
//			productsOrderedDTOs.add(pOrderDTO);
//		}
//
//		//logger.info("Products Ordered : {}", productsOrderedDTOs);
//		return productsOrderedDTOs;
//	}
	@Override
	public String placeOrder(ProductsOrderedDTO productsOrderedDTO) throws OrderMSException {
		
		//prodRepo.findByIdBuyerId(productsOrderedDTO.getBuyerId()).orElseThrow(()->new OrderMSException("OrderService.No_such_buyer_exists"));
		ProductsOrdered po = new ProductsOrdered();
        CompositeKey newId = new CompositeKey();
		newId.setBuyerId(productsOrderedDTO.getBuyerId());
		newId.setProdId(productsOrderedDTO.getProdid());
		po.setId(newId);
        po.setSellerId(productsOrderedDTO.getSellerId());
		po.setQuantity(productsOrderedDTO.getQuantity());
		prodRepo.save(po);
		String val = "Buyer ID: "+productsOrderedDTO.getBuyerId()+" and Product ID: "+productsOrderedDTO.getProdid();
		return val;
	}
}
