package com.qintess.spring.config;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.qintess.spring.entities.Client;
import com.qintess.spring.entities.Contact;
import com.qintess.spring.entities.Event;
import com.qintess.spring.entities.Order;
import com.qintess.spring.entities.OrderItem;
import com.qintess.spring.entities.Role;
import com.qintess.spring.entities.ShowHouse;
import com.qintess.spring.repositories.AddressRepository;
import com.qintess.spring.repositories.CityRepository;
import com.qintess.spring.repositories.ClientRepository;
import com.qintess.spring.repositories.ContactRepository;
import com.qintess.spring.repositories.EventRepository;
import com.qintess.spring.repositories.OrderItemRepository;
import com.qintess.spring.repositories.OrderRepository;
import com.qintess.spring.repositories.RoleRepository;
import com.qintess.spring.repositories.ShowHouseRepository;
import com.qintess.spring.repositories.StateRepository;


//Classe que faz os testes no banco h2(banco de teste, utiliza a memoria)
@Configuration
public class TestConfig implements CommandLineRunner {

	//Injeções de dependencia
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private ContactRepository contactRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private ShowHouseRepository showHouseRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Event ev = new Event("Festa da aaaa", "Sem criativity", null, 5.0, 3000, null, null);
		eventRepository.save(ev);
		
		Role role = new Role("ROLE_CLIENT");
		
		Role role1 = new Role("ROLE_EVENTMAKER");
		
		roleRepository.saveAll(Arrays.asList(role, role1));
	}
}
