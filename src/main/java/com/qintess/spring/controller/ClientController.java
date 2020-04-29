package com.qintess.spring.controller;

import java.util.Arrays;

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
import com.qintess.spring.entities.Role;
import com.qintess.spring.services.ClientService;
import com.qintess.spring.services.RoleService;
import com.qintess.spring.validation.ClientValidation;

@Controller
@RequestMapping("/client")
public class ClientController {
	
	private ClientService clientService;
	private RoleService roleService;

	@Autowired
	public ClientController(ClientService clientService, RoleService roleService) {
		super();
		this.clientService = clientService;
		this.roleService = roleService;
	}

	@GetMapping("/showClient")
	public String getClient(@RequestParam("clientId") int clientId, Model model) {

		Client client = clientService.getClient(clientId);

		model.addAttribute("client", client);

		return "client-info";
	}
	
	@GetMapping("/showAddForm")
	public String showAddForm(Model model) {

		ClientValidation client = new ClientValidation();
		
		model.addAttribute("client", client);

		return "client-form";
	}

	@PostMapping("/saveClient")
	public String saveClient(@ModelAttribute("client") ClientValidation clientV) {
		
		Client client = new Client();
		
		client.setName(clientV.getName());
		client.setEmail(clientV.getEmail());
		client.setCpf(clientV.getCpf());
		client.setUsername(clientV.getUsername());
		client.setPassword(clientV.getPassword());
		client.setBirthDate(clientV.getBirthDate());
		
		if("EVENTMAKER".equals(clientV.getType())) {
			Role role = roleService.findByName("ROLE_EVENTMAKER");
			client.setRoles(Arrays.asList(roleService.findByName("ROLE_CLIENT"), role));
		}else {
			client.setRoles(Arrays.asList(roleService.findByName("ROLE_CLIENT")));
		}
			
		
		clientService.saveOrUpdateClient(client);

		return "redirect:/";
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

		return "redirect:/home/showHome";
	}

}
