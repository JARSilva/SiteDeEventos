package com.qintess.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.spring.entities.Cart;
import com.qintess.spring.repositories.CartRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository repository;

	public List<Cart> getClientCarts() {
		return repository.findAll();
	}

	public void saveOrUpdateCart(Cart cart) {
		repository.save(cart);
	}

	public Cart getCart(long id) {
		Optional<Cart> obj = repository.findById(id);

		return obj.get();
	}

	public void deleteCart(Long id) {
		Optional<Cart> obj = repository.findById(id);
		Cart deletedCart = obj.get();
		repository.delete(deletedCart);
	}
}
