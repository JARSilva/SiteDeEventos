package com.qintess.spring.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_state")
public class State implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "state_id")
	private Long id;
	
	@Column(name = "state_name")
	private String name;
	
	@Column(name = "state_initials")
	private String initials;
	
	@OneToMany(mappedBy =  "state", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<City> cities = new HashSet<City>();
	
	public State() {
		super();
	}

	public State(String name, String initials, Set<City> cities) {
		super();
		this.name = name;
		this.initials = initials;
		this.cities = cities;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	public Set<City> getCities() {
		return cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}
	
	

	@Override
	public String toString() {
		return "State [id=" + id + ", name=" + name + ", initials=" + initials + ", cities=" + cities + "]";
	}
	
	
	

}
