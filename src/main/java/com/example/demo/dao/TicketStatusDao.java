package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.TicketStatus;
import com.example.demo.entity.TicketStatusKey;

@Repository
public interface TicketStatusDao extends JpaRepository<TicketStatus, TicketStatusKey>{

}
