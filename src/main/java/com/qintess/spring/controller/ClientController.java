package com.qintess.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qintess.spring.entities.Client;
import com.qintess.spring.entities.ShowHouse;
import com.qintess.spring.services.ClientService;
import com.qintess.spring.services.ShowHouseService;

@Controller
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private ClientService clientService;

	@GetMapping("/showClients")
	public String getClients(Model model) {

		List<Client> clients = clientService.getClients();

		model.addAttribute("clients", clients);

		return "main";
	}

	@GetMapping("/showClient")
	public String getClient(@RequestParam("clientId") int clientId, Model model) {

		Client client = clientService.getClient(clientId);

		model.addAttribute("client", client);

		return "client-info";
	}
	
	@GetMapping("/showAddForm")
	public String showAddForm(Model model) {

		Client client = new Client();
		
		model.addAttribute("client", client);

		return "client-form";
	}

	@PostMapping("/saveClient")
	public String saveClient(@ModelAttribute("client") Client client) {
		clientService.saveOrUpdateClient(client);

		return "redirect:/event/showEvents";
	}

	@GetMapping("/showUpdateForm")
	public String showUpdateForm(@RequestParam("clientId") int clientId, Model model) {

		Client client = clientService.getClient(clientId);

		model.addAttribute("client", client);

		return "client-form";
	}

	@DeleteMapping("/deleteClient")
	public String deleteClient(@RequestParam("showHouseId") long id) {

		clientService.deleteClient(id);

		return "redirect:/event/showEvents";
	}

}
