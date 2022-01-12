package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Ticket;
import com.example.demo.service.TicketService;

@RestController
@RequestMapping("api/tickets")
public class TicketController {
	
	@Autowired
	private TicketService ticketService;

	@DeleteMapping("delete/{id}")
	@PreAuthorize("hasRole('Admin')")
	public void delete(@PathVariable Integer id) {
		ticketService.deleteById(id);
	}

	@GetMapping("")
	@PreAuthorize("hasRole('Admin')")
	public List<Ticket> findAll() {
		return ticketService.findAll();
	}
	
	@GetMapping("all/{id}")
	public List<Ticket> findTicketstById(@PathVariable String id) {
		return ticketService.findTicketstById(id);
	}

	@GetMapping("{id}")
	public Ticket findById(@PathVariable Integer id) {
		return ticketService.findById(id);
	}

	@PostMapping("create")
	public Ticket save(@RequestBody Ticket ticket) {
		return ticketService.save(ticket);
	}
	
	

}
