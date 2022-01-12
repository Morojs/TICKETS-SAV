package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Status;
import com.example.demo.entity.Ticket;


@Repository
public interface StatusDao  extends JpaRepository<Status,Integer>{
	@Query(value = "SELECT * FROM Status s WHERE s.libelle = ?1",  nativeQuery = true)
	Status findByLibelle(String status);
}
