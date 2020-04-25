package com.qintess.spring.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.qintess.spring.entities.Client;
import com.qintess.spring.entities.Contact;
import com.qintess.spring.entities.Event;
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
		
		Contact c1 = new Contact("132231212", client);
		Contact c2 = new Contact("222222212", client);
		Contact c3 = new Contact("454545452", client);
		Contact c4 = new Contact("235555232", client);
		Contact c5 = new Contact("000000000", client);
		
		client.getContacts().addAll(Arrays.asList(c1,c2,c3,c4,c5));
		
		clientRepository.save(client);
	}
}
