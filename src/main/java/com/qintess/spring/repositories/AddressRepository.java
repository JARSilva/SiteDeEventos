package com.qintess.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.spring.entities.Address;


public interface AddressRepository extends JpaRepository<Address, Long>{
	
}
