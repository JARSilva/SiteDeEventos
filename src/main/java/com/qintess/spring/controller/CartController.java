package com.qintess.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qintess.spring.entities.Cart;
import com.qintess.spring.entities.Client;
import com.qintess.spring.entities.Event;
import com.qintess.spring.services.CartService;
import com.qintess.spring.services.ClientService;
import com.qintess.spring.services.EventService;

@Controller
@RequestMapping("/cart")
public class CartController {

	private EventService eventService;
	private CartService cartService;
	private ClientService clientService;

	@Autowired
	public CartController(EventService eventService, CartService cartService, ClientService clientService) {
		super();
		this.eventService = eventService;
		this.cartService = cartService;
		this.clientService = clientService;
	}

	@GetMapping("/showInfo")
	public String getEvent(@RequestParam("eventId") int eventId, Model model) {

		Event event = eventService.getEvent(eventId);

		model.addAttribute("event", event);

		return "event-info";
	}

	@GetMapping("/showOrderForm")
	public String showOrderForm(@RequestParam("eventId") int eventId, Model model) {
		Cart cart = new Cart();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		Client client = clientService.findByUsername(name);
		cart.setClient(client);
		
		Event event = eventService.getEvent(eventId);

		model.addAttribute("event", event);
		
		System.out.println("|||||||||||||||||||||||||||||||");
		System.out.println(event);

		return "order-form";
	}

	@PostMapping("/putInCart")
	public String putInCart(@ModelAttribute("cartItem") Cart cart) {
		
		cartService.saveOrUpdateCart(cart);
		
		return "redirect:/home/showHome";
	}

}
