package com.qintess.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.spring.entities.City;


public interface CityRepository extends JpaRepository<City, Long>{
	
}
