package com.qintess.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.spring.entities.Cart;


public interface CartRepository extends JpaRepository<Cart, Long>{
	
}
