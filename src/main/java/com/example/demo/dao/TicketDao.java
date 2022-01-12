package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Ticket;

@Repository
public interface TicketDao  extends JpaRepository<Ticket,Integer>{

	@Query(value = "SELECT * FROM Ticket t WHERE t.user.id = ?1",  nativeQuery = true)
	List<Ticket>findTicketstById(String id);
}
