package com.example.demo.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Ticket {
	static final long serialVersionUID = -476067348552556658L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JoinColumn(name = "idType", nullable = false)
	private Type type;

	private String description;
	private String objet;

	@OneToMany(mappedBy = "ticket")
	Set<TicketStatus> ticketStatus;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public long getId() {
		return id;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public Set<TicketStatus> getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(Set<TicketStatus> ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


}
