package com.example.demo.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class TicketStatus {
	static final long serialVersionUID = -136067348342556409L;
	@EmbeddedId
	private TicketStatusKey id;

	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@MapsId("ticketId")
	@JoinColumn(name = "ticket_id")
	private Ticket ticket;

	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@MapsId("statusId")
	@JoinColumn(name = "status_id")
	private Status status;

	private Date date_ouverture;
	private Date date_fermeture;

	public TicketStatus() {
		super();
	}

	public TicketStatusKey getId() {
		return id;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Object getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getDate_ouverture() {
		return date_ouverture;
	}

	public void setDate_ouverture(Date date_ouverture) {
		this.date_ouverture = date_ouverture;
	}

	public Date getDate_fermeture() {
		return date_fermeture;
	}

	public void setDate_fermeture(Date date_fermeture) {
		this.date_fermeture = date_fermeture;
	}

}
