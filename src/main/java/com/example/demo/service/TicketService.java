package com.example.demo.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StatusDao;
import com.example.demo.dao.TicketDao;
import com.example.demo.dao.TicketStatusDao;
import com.example.demo.dao.TypeDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.Role;
import com.example.demo.entity.Status;
import com.example.demo.entity.Ticket;
import com.example.demo.entity.TicketStatus;
import com.example.demo.entity.Type;
import com.example.demo.entity.User;


@Service
public class TicketService {

	@Autowired
	private TicketDao ticketDao;
	@Autowired
	private StatusDao statusDao;
	@Autowired
	private TicketStatusDao ticketStatusDao;
	@Autowired
	private TypeDao typeDao;
	
	@Autowired
	private UserDao userDao;

	public List<Ticket> findAll() {
		return ticketDao.findAll();
	}
	
	public List<Ticket> findTicketstById(String id) {
		
		return ticketDao.findTicketstById(id);
	}

	public Ticket findById(Integer id) {
		return ticketDao.findById(id).get();
	}

	public Ticket save(Ticket ticket) {
		/*Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Optional<User> user=userDao.findById(currentPrincipalName);*/
		Status status=statusDao.findByLibelle("Actif");
		TicketStatus ticketStatus=new TicketStatus();
		ticketStatus.setStatus(status);
		ticketStatus.setTicket(ticket);
		ticketStatus.setDate_ouverture(new Date());
		ticketStatus.setDate_fermeture(null);
		ticketStatusDao.save(ticketStatus);
		Set<TicketStatus> sts= new HashSet<>();
		sts.add(ticketStatus);
		ticket.setTicketStatus(sts);
		//ticket.setUser(user.get());
		return ticketDao.save(ticket);
	}

	public void deleteById(Integer id) {
		ticketDao.deleteById(id);
	}
	
	
	
}
