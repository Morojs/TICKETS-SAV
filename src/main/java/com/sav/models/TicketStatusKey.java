package com.sav.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TicketStatusKey {

	
	 @Column(name = "ticket_id")
	 Long ticketId;

	 @Column(name = "status_id")
	 Long statusId;
}
