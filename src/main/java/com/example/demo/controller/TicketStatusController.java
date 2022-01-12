package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.TicketStatus;
import com.example.demo.entity.TicketStatusKey;
import com.example.demo.service.TicketStatusService;

@RestController
@RequestMapping("affectation")
public class TicketStatusController {

	@Autowired
	private TicketStatusService ticketStatusService;

	@PutMapping("{id}")
	public TicketStatus updateStatus(@PathVariable TicketStatusKey id,@PathVariable String libelle,@RequestBody TicketStatus nwticketStatus) {
		return ticketStatusService.updateStatus(id, libelle, nwticketStatus);
	}
	
}
