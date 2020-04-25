package com.qintess.spring.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_address")
public class Address implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private Long id;
	
	@Column(name = "address_place")
	private String place;
	
	@Column(name = "address_number")
	private String number;
	
	@Column(name = "address_complement")
	private String complement;
	
	@Column(name = "address_neighborhood")
	private String neighborhood;
	
	@Column(name = "address_cep")
	private String cep;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "city_id")
	private City city;
	
	public Address() {
		super();
	}

	public Address(String place, String number, String complement, String neighborhood, String cep, City city) {
		super();
		this.place = place;
		this.number = number;
		this.complement = complement;
		this.neighborhood = neighborhood;
		this.cep = cep;
		this.city = city;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
	

	@Override
	public String toString() {
		return "Address [id=" + id + ", place=" + place + ", number=" + number + ", complement=" + complement
				+ ", neighborhood=" + neighborhood +  ", city=" + city + "]";
	}
	
	
	

}
