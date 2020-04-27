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
import com.qintess.spring.entities.ShowHouse;
import com.qintess.spring.repositories.AddressRepository;
import com.qintess.spring.repositories.CityRepository;
import com.qintess.spring.repositories.ClientRepository;
import com.qintess.spring.repositories.ContactRepository;
import com.qintess.spring.repositories.EventRepository;
import com.qintess.spring.repositories.OrderItemRepository;
import com.qintess.spring.repositories.OrderRepository;
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

	@Override
	public void run(String... args) throws Exception {
		
		Client client = new Client("João", "1231321", null, "jo@hotmail.com");
		clientRepository.save(client);
		Order order = new Order(null, 10.0, null);
		orderRepository.save(order);
		order.setClient(client);
		orderRepository.save(order);
		Event ev = new Event("Festa da aaaa", "Sem criativity", null, 5.0, 3000, null, null);
		eventRepository.save(ev);
		System.out.println(eventRepository.findById(1L).get());
		OrderItem od = new OrderItem(orderRepository.findById(1L).get(), eventRepository.findById(1L).get(), 2, 5.0);
		System.out.println(od);
		orderItemRepository.save(od);
	}
}
