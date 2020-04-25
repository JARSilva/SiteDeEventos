package com.qintess.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.spring.entities.Client;
import com.qintess.spring.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	public List<Client> getClients() {
		return repository.findAll();
	}

	public void saveOrUpdateClient(Client client) {
		repository.save(client);
	}

	public Client getClient(long id) {
		Optional<Client> obj = repository.findById(id);

		return obj.get();
	}

	public void deleteClient(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client deletedClient = obj.get();
		repository.delete(deletedClient);
	}
	
}
