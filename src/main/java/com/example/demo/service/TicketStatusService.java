package com.example.demo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StatusDao;
import com.example.demo.dao.TicketStatusDao;
import com.example.demo.entity.Status;
import com.example.demo.entity.TicketStatus;
import com.example.demo.entity.TicketStatusKey;


@Service
public class TicketStatusService {

	@Autowired
	private TicketStatusDao ticketStatusDao;
	
	@Autowired
	private StatusDao statusDao;
	
    public TicketStatus updateStatus(TicketStatusKey id, String libelle,TicketStatus nwticketStatus) {
    	TicketStatus ticketStatus =new TicketStatus();
    	Status status=statusDao.findByLibelle(libelle);
    	ticketStatus=this.findById(id);
    	ticketStatus.setStatus(status);
    	ticketStatus.setTicket(nwticketStatus.getTicket());
    	ticketStatus.setDate_ouverture(new Date());
    	ticketStatus.setDate_fermeture(nwticketStatus.getDate_fermeture());
    	this.save(ticketStatus);
        return ticketStatus;
    }

	public TicketStatus findById(TicketStatusKey id) {
		return ticketStatusDao.findById(id).get();
	}

	public TicketStatus save(TicketStatus ticketStatus) {
		return ticketStatusDao.save(ticketStatus);
	}
	
    
    
}
