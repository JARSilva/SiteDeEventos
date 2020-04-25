package com.qintess.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.spring.entities.State;


public interface StateRepository extends JpaRepository<State, Long>{
	
}
