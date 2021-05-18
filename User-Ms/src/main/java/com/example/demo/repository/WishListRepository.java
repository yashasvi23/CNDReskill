package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.CompositeKey;
import com.example.demo.entity.Wishlist;

public interface WishListRepository extends CrudRepository<Wishlist, CompositeKey>{
	public Optional<Wishlist> findByBuyerIdAndProdId(Integer buyerId, Integer prodId);

}
