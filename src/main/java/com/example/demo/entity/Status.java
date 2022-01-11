package com.example.demo.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Status {
	
	static final long serialVersionUID = -136067348552556409L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String libelle;
	private String description;
	
	@OneToMany(mappedBy = "status")
	Set<TicketStatus> ticketStatus;

	public Status() {
		super();
	}

	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}



	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}
